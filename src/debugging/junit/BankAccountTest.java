package debugging.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith( Parameterized.class )//Vai usar o construtor para parametizar os testes, isto e,
							   //vai fazer teste para cada entrada da coleccao de parametros
public class BankAccountTest {
	
	private BankAccount account;
	private static int callCount;
	
	//definir atributos para serem usados em metodos e definidos os seus valores no contrutor
	//para poder usar o poder de parametized test
	private double amount;
	private boolean branch;
	private double expected;
	
	public BankAccountTest( double amount, boolean branch, double expected ){
		this.amount = amount;
		this.branch = branch;
		this.expected = expected;
	}
	
	//define a coleccao de parametros que seram usados para criar
	//instancias da classe de teste e fazer teste com cada instancia
	//neste caso, vai fazer 5 testes, porque a collecao tem 5 parametizers
	@Parameterized.Parameters
	public static Collection<Object[]> parametros(){
		List< Object[] > tests = new ArrayList<>();
		Object[] params1 = { 200.0		,true	,6000200.0 };
		tests.add(params1);
		Object[] params2 = { 325.14	,true	,6000325.15 };
		tests.add(params2);
		Object[] params3 = { 12545.88	,true	,6012545.88 };
		tests.add(params3);
		Object[] params4 = { 3.14		,true	,6000003.14 };
		tests.add(params4);
		Object[] params5 = { 800.0		,false	,6000800.0 };
		tests.add(params5);
		
		return tests;
		/*
		return Arrays.asList( new Object[][] {
			{ 200.0		,true	,6000200.0 },
			{ 325.14	,true	,6000325.15 },
			{ 12545.88	,true	,6012545.88 },
			{ 3.14		,true	,6000003.14 },
			{ 800.0		,false	,6000800.0 }
		} );*/
	}
	
	@BeforeClass
	public static void correAntesDeTodosNaClasse() {
		System.out.println("Primeiro a correr. callCount = " +callCount++);
	}
	
	@Before
	public void correAntesDeCadaTeste() {
		account = new BankAccount("Bento", "Arao", 6000000, BankAccount.CHECKING );
		System.out.println("Correndo um teste...saldo inicial = " + account.getBalance() );
		System.out.println("Corre antes de cada teste. callCount = " +callCount++);
	}

	@Test
	public void deposit() {
		//this test uses the parametized testing, the test will be called for every entry
		//in the test list
		double saldo = account.deposit( this.amount, this.branch );
		assertEquals( this.expected, saldo, 0.011 );
	}

	@Test
	public void withdrawFromBranch() {
		double saldo = account.withdraw( 600, true );
		assertEquals( 5999400, saldo, 0 );
	}
	
	//expecifica a classe da excepcao que pode ser lancada pelo codigo no teste.
	//Se este teste lancar esta excepcao, significa que deu certo, isto e, nao e
	//possivel levantar mais de 500 na ATM, entao teste passou (success, working well)
	@Test( expected = IllegalArgumentException.class )
	public void withdrawFromATM() throws Exception {
		account.withdraw( 600, false );//aqui so estamos a testar se e possivel levantar mais de 500 na ATM
									   //Se lancar excepcao, nao aceita levantar, e o sistema esta bom
									   //Se nao lancar, significa que foi possivel levantar e nao esta bom
	}
 
	@Test
	public void getBalanceAfterDeposit() {
		account.deposit( 200, true );
		assertEquals( 6000200, account.getBalance(), 0 );
	}

	@Test
	public void getBalanceAfterWithdraw() {
		account.withdraw( 200, true );
		assertNotEquals( "The withdraw method is not withdrawing money from the account", 6000000, account.getBalance(), 0 );
		assertEquals( "The withdraw method is not withdrawing money from the account correcty", 5999800, account.getBalance(), 0 );
	}
	
	@Test
	public void isCheckingAccount() {
		assertTrue( "The account is not a checking account", account.isChecking() );
	}
	
	@After
	public void correDepoisDeCadaTeste() {
		System.out.println("Terminou um teste. callCount = " +callCount++);
	}
	
	@AfterClass
	public static void correDepoisDeTodosTestes() {
		System.out.println("Terminaram os testes. callCount = " +callCount++);
	}

}






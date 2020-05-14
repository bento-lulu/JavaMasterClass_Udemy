package cuncurrency.challenge;

public class Challenge1 {

	public static void main(String[] args) {
		
		BankAccount account = new BankAccount( 1000, "124578" );
		
		AccountUser1 user1 = new AccountUser1( account );
		AccountUser2 user2 = new AccountUser2( account );
		
		new Thread( user1 ).start();
		new Thread( user2 ).start();
	}
}



class AccountUser1 implements Runnable{
	BankAccount account;
	
	public AccountUser1( BankAccount account ) {
		this.account = account;
	}
	
	@Override
	public void run() {
		account.deposit( 300 );
		account.withdraw( 50 );
	}
}


class AccountUser2 implements Runnable{
	BankAccount account;
	
	public AccountUser2( BankAccount account ) {
		this.account = account;
	}
	
	@Override
	public void run() {
		account.deposit( 203.75 );
		account.withdraw( 100.00 );
	}
}





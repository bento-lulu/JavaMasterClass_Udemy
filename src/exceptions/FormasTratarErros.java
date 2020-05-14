package exceptions;

public class FormasTratarErros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//LBYL - Look Before You Leave
	//Para tratar de possiveis erros, verificamos primeiro, depois se o valor for errado paramos, se for
	//certo proceguimos
	public static int devideLBYL( int x, int y ) {
		if ( y == 0 ) {
			return 0;//nao se divide por 0
		} else {
			return x/y;
		}
	}
	
	//EAFP - Easy to Ask for Forgiveness than Permission
	//Tenta fazer a operacao, se algo der errado, trata do assunto com catch blocks
	public static int devideEAFP( int x, int y ) {
		try {
			return x/y;
		}catch( ArithmeticException exc ) {
			return 0;
		}
	}

}

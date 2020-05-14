package lambdas;

public class LambdaScope {

	public static void main(String[] args) {
		/*
		 * Expressoes lambdas e classes anonimas so aceitam variaveis 'final' ou 'effectivelly final' porque a hora em
		 * que este codigo corre, nao e sequencial, como por exemplo nos eventos de um botao na GUI, em um Thread,
		 * entao se usar variavel que nao e final, o codigo pode correr enquanto a variavel ja nao existe na memoria e
		 * foi recolhida com garbage collector, entao se for final, o programa assume o primeiro valor atribuido a
		 * esta variavel, e se for final o valor sera o mesmo sempre, dai essa necessidade de final.
		 * */
		
		
		int messageCount = 1;
		MessageSender messageSender = ( sender, receiver, message) -> {
			if ( sender==null || receiver==null || message==null ) {
				System.out.println("\nMensagem nao enviada\n");
				return false;
			}
			System.out.println("\n********************Message " +messageCount+ " Sent********************");
			System.out.format("Sender: %s\nReceiver: %s\nMessage: %s\n", sender,
																		   receiver,
																		   message);
			//messageCount++;
			//Queria fazer contagem de mensagens com a variavel fora da expressao lambda,
			//mas nao e possivel pois expressoes lambdas, embora nao criam classes anonimas como classes
			//anonimas, elas so aceitam variaveis fora dele que sao 'final' ou 'effectivelly final', isto e,
			//cujo valor nao altera.
			
			return true;
		};
		
		sendMessage( messageSender, "CPU", "RAM", "LOAD data on address 5FA6 to register R4" );
		sendMessage( messageSender, "CPU", "Register", "STORE data on register R4 to memory address 78FF" );
		
		
		MessageSender messageSender2 = new MessageSender() {
			int counter =1;
			@Override
			public boolean sendMessage(String sender, String receiver, String message) {
				if ( sender==null || receiver==null || message==null ) {
					System.out.println("\nMensagem nao enviada\n");
					return false;
				}
				System.out.println("\n********************Message " +counter+ " Sent********************");
				System.out.format("Sender: %s\nReceiver: %s\nMessage: %s\n", sender,
																			   receiver,
																			   message);
				//Com anonymous class e possivel criar um atributo na classe anonima e usar para contagem
				counter++;
				
				return true;
			}
		};

		sendMessage( messageSender2, "CPU", "RAM", "LOAD data on address 5FA6 to register R4" );
		sendMessage( messageSender2, "CPU", "Register", "STORE data on register R4 to memory address 78FF" );
	}


	private static boolean sendMessage( MessageSender messageSender, String sender, String receiver, String message ) {
		return messageSender.sendMessage(sender, receiver, message);
	}
	
}

interface MessageSender {
	boolean sendMessage( String sender, String receiver, String message );
}
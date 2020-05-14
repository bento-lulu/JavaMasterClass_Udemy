package arraylists;

import java.util.Scanner;

public class MobilePhoneMain {
	
	private static Scanner scanner = new Scanner( System.in );
	private static MobilePhone phone = new MobilePhone();

	public static void main(String[] args) {
		
		imprimirMenu();
		
		boolean running = true;
		while( running ) {
			System.out.print(">");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
			case 0:
				imprimirMenu();
				break;
			case 1:
				imprimirContactos();
				break;
			case 2:
				adicionarContacto();
				break;
			case 3:
				actualizarContacto();
				break;
			case 4:
				removerContacto();
				break;
			case 5:
				procurarContacto();
				break;
			case 6:
				running = false;
				break;
			default:
				System.err.println("Opcao Invalida!");
				break;
			}
		}
		
		System.out.println("Obrigado por usar o nosso sistema!");
	}

	private static void imprimirMenu() {
		//Quit, print list of contacts, add new contact, update existing contact, remove contact
		System.out.println("0. Menu\n" +
						   "1. Imprimir Contactos\n" +
						   "2. Adicionar Contacto\n" +
						   "3. Actualizar Contacto\n" +
						   "4. Remover Contacto\n" +
						   "5. Pesquisar Contacto\n" +
						   "6. Sair\n");
	}



	private static void imprimirContactos() {
		phone.imprimirLista();
	}

	private static void adicionarContacto() {
		System.out.print("Insere o nome do novo contacto: ");
		String nome = scanner.nextLine();
		System.out.print("Insere o numero do contacto: ");
		String numero = scanner.nextLine();
		Contact contact = new Contact(nome, numero);
		phone.store(contact);
	}

	private static void actualizarContacto() {
		System.out.print("Insere o nome do contacto por actualizar: ");
		String old_nome = scanner.nextLine();
		System.out.print("Insere o nome do novo contacto: ");
		String nome = scanner.nextLine();
		System.out.print("Insere o numero do contacto: ");
		String numero = scanner.nextLine();
		Contact old_contact = new Contact(old_nome, "");
		Contact contact = new Contact(nome, numero);
		phone.modify(old_contact, contact);
	}
	
	private static void removerContacto() {
		System.out.print("Insere o nome do contacto por remover: ");
		String nome = scanner.nextLine();
		phone.remove( new Contact(nome, "") );
	}
	
	private static void procurarContacto() {
		System.out.print("Insere o nome do contacto por pesquisar: ");
		String nome = scanner.nextLine();
		
		phone.query(nome);
	}
}

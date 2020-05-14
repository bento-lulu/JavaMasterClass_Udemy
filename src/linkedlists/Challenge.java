package linkedlists;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Album> albuns = new ArrayList<Album>();
		Album album1 = new Album();
		albuns.add(album1);
		album1.add( new Song("Cry me a river", 3.1) );
		album1.add( new Song("What goues around, comes around", 5.0) );
		album1.add( new Song("Sexyback", 3.5) );

		Album album2 = new Album();
		albuns.add(album2);
		album2.add( new Song("Do it to me", 3.4) );
		album2.add( new Song("Remind Me", 4.1) );
		album2.add( new Song("Nice and SLow", 3.8) );

		Album album3 = new Album();
		albuns.add(album3);
		album3.add( new Song("Who are you", 3.2) );
		album3.add( new Song("Adult Film", 5.1) );
		album3.add( new Song("Tanasia", 3.9) );
		
		PlayList playList = new PlayList( albuns );
		playList.add( new Song("What goues around, comes around", 5.0) );
		playList.add( new Song("Nice and SLow", 3.8) );
		playList.add( new Song("CREAM", 4.9) );
		playList.add( album3.get(0) );
		playList.add( album3.get(1) );
		playList.add( album3.get(2) );
		
		printMenu();
		
		boolean correr = true;
		while( correr ) {
			System.out.print("> ");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 0:
				System.out.println("Fechou programa!");
				correr = false;
				break;
			case 1:
				playList.next();
				break;
			case 2:
				playList.previous();
				break;
			case 3:
				playList.replay();
				break;
			case 4:
				playList.list();
				break;
			default:
				break;
			}
		}
		
	}

	
	private static void printMenu() {
		System.out.println("\nMenu:\n" +
						   "0. Sair\n" +
						   "1. Proxima\n" +
						   "2. Anterior\n" +
						   "3. Replay\n" +
						   "4. Listar\n");
	}
}

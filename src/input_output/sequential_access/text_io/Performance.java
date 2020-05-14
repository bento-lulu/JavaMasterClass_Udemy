package input_output.sequential_access.text_io;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Performance {

	public static void main(String[] args) {
		int nanosFileReader = 0, nanosBufferedReader = 0;
		
		try ( Scanner scanner = new Scanner( new FileReader("big_text_file.txt") ) ){
			LocalDateTime start = LocalDateTime.now();
			while ( scanner.hasNextLine() ) {
				String line = scanner.nextLine();
				//System.out.println(line);
			}
			LocalDateTime end =  LocalDateTime.now();
			nanosFileReader = end.getNano() - start.getNano();
			System.out.println("Time Spent in FileReader(Nano): " + nanosFileReader );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try ( BufferedReader bReader = new BufferedReader( new FileReader("big_text_file.txt") ) ){
			LocalDateTime start = LocalDateTime.now();
			String line = null;
			while ( (line = bReader.readLine()) != null ) {
				//System.out.println(line);
			}
			LocalDateTime end =  LocalDateTime.now();
			nanosBufferedReader = end.getNano() - start.getNano();
			System.out.println("Time Spent in BufferedReader(Nano): " + nanosBufferedReader );
			
			
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		
		if ( nanosBufferedReader < nanosFileReader ) {
			System.out.println("BufferedReader e " +((double)nanosFileReader/nanosBufferedReader)+
								" vezes mais rapido que o FileReader, pois usa buffer para ler um monte de dados e\n "
								+ "guardar no buffer para o programa o aceder rapidamente na memoria e nao no\n "
								+ "dispositivo de armazenamento palavra por palavra como faz o FileReader");
		} else if ( nanosBufferedReader > nanosFileReader ) {
			System.out.println("Estranhamente, o FileReader foi " +((double)nanosBufferedReader/nanosFileReader)+
							   " vezes mais rapido que o BufferedReader");
		} else {
			System.out.println("Incrivel, levaram o mesmo tempo");
		}
	}

}

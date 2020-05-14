package input_output.sequential_access.text_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Local> {
	private static Map<Integer, Local> locations = new HashMap<Integer, Local>();
	/*
	 * Metodo main usado so para escrever dados nos ficheiros do jogo para ter os mesmos gravados em disco
	 */
	public static void main(String[] args) throws IOException {
		
		//with try with resources, the data created inside the parenthesis will be closed, or the
		//resources will be closed after the statement occurs, and any exception in closing these
		//resources will not be thrown, as it has nothing to do with the actual functionality of the
		//application, the actual functionality is normally in the try block.
		//You can still add a finally block if you want, to do other strange stuff
		try ( BufferedWriter writer = new BufferedWriter( new FileWriter("locations.txt") );
			  BufferedWriter writerSaidas = new BufferedWriter( new FileWriter("directions.txt")) ) {
			
			for ( Local local : locations.values() ) {
				writer.write( local.getIdLocal() + "," + local.getDescricao() + "\n" );
				
				for ( String direction : local.getSaidas().keySet() ) {
					if ( !direction.equalsIgnoreCase("Q") ) {
						writerSaidas.write(local.getIdLocal() + "," + direction + "," + local.getSaidas().get(direction) + "\n");
					}
				}
			}
		}
		
		 /* Old Code of the above one
		FileWriter writer = null;
		try {
			writer = new FileWriter("locations.txt");
			for( Local local: locations.values() ) {
				writer.write(local.getIdLocal() + "," +local.getDescricao() + "\n");
			}
		} finally {
			if ( writer != null ) {
				writer.close();
			}
		}*/
	}
	
	static {
		
		try ( BufferedReader reader = new BufferedReader( new FileReader("locations.txt") );
			  BufferedReader reader2 = new BufferedReader( new FileReader("directions.txt")) ) {
			
			String line = reader.readLine();//tenta pegar primeira linha
			while ( line != null ) {//way 1, teste facil de perceber
				String[] words = line.split(",");
				int loc_id = Integer.parseInt( words[0] );
				String descricao = words[1];
				System.out.println("Importados: " +loc_id+ ": " +descricao);
				Map<String, Integer> temExit = new HashMap<>();
				locations.put( loc_id, new Local(loc_id, descricao, temExit));
				
				line = reader.readLine();//pega a proxima linha, para testar no proximo loop do 'while loop'
			}
			
			while ( (line = reader2.readLine() ) != null ) {//way 2, most common and actually very beautiful
				String[] workds = line.split(",");
				int id_loc = Integer.parseInt( workds[0] );
				String direction = workds[1];
				int exit_id = Integer.parseInt( workds[2] );
				System.out.println(id_loc+ " : " +direction+ " : " +exit_id);
				locations.get(id_loc).adicionarSaida( direction, exit_id );
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		/*
		 * Old code, replaced by the above sofisticated one
		Scanner scanner = null;
		
		try {
			scanner = new Scanner( new FileReader("locations_big.txt") );
			scanner.useDelimiter(",");
			while (scanner.hasNextLine()) {
				int loc_id = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String descricao = scanner.nextLine();
				System.out.println("Importados: " +loc_id+ ": " +descricao);
				Map<String, Integer> temExit = new HashMap<>();
				locations.put( loc_id, new Local(loc_id, descricao, temExit));
			}
			
		} catch(IOException exc) {
			exc.printStackTrace();
		} finally {
			if ( scanner != null ) {
				scanner.close();
			}
		}
		
		try {
			scanner = new Scanner( new BufferedReader( new FileReader("directions_big.txt")) );
			scanner.useDelimiter(",");
			
			while(scanner.hasNextLine()) {
				int id_loc = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String direction = scanner.next();
				scanner.skip(scanner.delimiter());
				int exit_id = Integer.parseInt( scanner.nextLine() );
				System.out.println(id_loc+ " : " +direction+ " : " +exit_id);
				
				locations.get(id_loc).adicionarSaida( direction, exit_id );
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		*/
		
		
		
		
		/*
		Map<String, Integer> temp_saidas = new HashMap<>();
		locations.put(0, new Local(0, "Saida do Jogo", temp_saidas) );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("W", 2);
		temp_saidas.put("S", 4);
		temp_saidas.put("E", 3);
		temp_saidas.put("N", 5);
		Local road = new Local( 1, "Road", temp_saidas );
		locations.put(1, road );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("N", 5);
		Local hill = new Local( 2, "Hill", temp_saidas );
		locations.put(2, hill );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("W", 1);
		Local building = new Local( 3, "Building", temp_saidas );
		locations.put(3, building );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("N", 1 );
		temp_saidas.put("W", 2 );
		Local valley = new Local( 4, "Valley", temp_saidas );
		locations.put(4, valley );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("S", 1);
		temp_saidas.put("W", 2 );
		Local forest = new Local( 5, "Forest", temp_saidas );
		locations.put(5, forest );
		*/
	}

	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return containsValue(value);
	}

	@Override
	public Local get(Object key) {
		return locations.get(key);
	}

	@Override
	public Local put(Integer key, Local value) {
		return locations.put(key, value);
	}

	@Override
	public Local remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Local> m) {
		
	}

	@Override
	public void clear() {
		locations.clear();
	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Collection<Local> values() {
		return locations.values();
	}

	@Override
	public Set<Entry<Integer, Local>> entrySet() {
		return locations.entrySet();
	}

}

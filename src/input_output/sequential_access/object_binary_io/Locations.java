package input_output.sequential_access.object_binary_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Local> {
	private static Map<Integer, Local> locations = new HashMap<Integer, Local>();
	
	public static void main(String[] args) throws IOException {
		
		try( ObjectOutputStream objOut = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream("locations.dat")) )  ){
			for ( Local local : locations.values() ) {
				objOut.writeObject(local);
				System.out.println("Write: " +local);
			}
		}
	}
	
	static {
		try ( ObjectInputStream objIn = new ObjectInputStream( new BufferedInputStream( new FileInputStream("locations.dat"))) ){
			while( true ) {
				try {
					Local local = (Local) objIn.readObject();
					System.out.println("Read Location->: " +local );
					locations.put( local.getIdLocal(), local );
				}catch (EOFException e) {
					System.out.println("Terminou de ler o ficheiro: " +e.getMessage());
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		locations.put( 0, new Local(0, "Fim do Jogo", null) );//Adicionar local de saida para a lista de locais
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
	
	@Override
	public String toString() {
		return locations.toString();
	}

}

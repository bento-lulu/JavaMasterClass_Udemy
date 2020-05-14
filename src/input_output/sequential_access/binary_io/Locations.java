package input_output.sequential_access.binary_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import input_output.sequential_access.text_io.Local;

public class Locations implements Map<Integer, Local> {
	private static Map<Integer, Local> locations = new HashMap<Integer, Local>();
	
	public static void main(String[] args) throws IOException {
		
		try( DataOutputStream dataOut = new DataOutputStream( new BufferedOutputStream( new FileOutputStream("locations.dat")) )  ){
			for ( Local local : locations.values() ) {
				dataOut.writeInt(local.getIdLocal());
				dataOut.writeUTF(local.getDescricao());
				System.out.print( "Location: " +local.getIdLocal()+ " : " +local.getDescricao() );
				dataOut.writeInt( local.getSaidas().size()-1 );
				System.out.println(". Tem " +(local.getSaidas().size()-1)+ " saidas:");
				
				for ( String direction : local.getSaidas().keySet() ) {
					if ( !direction.equalsIgnoreCase("Q") ) {
						dataOut.writeUTF(direction);
						dataOut.writeInt(local.getSaidas().get(direction));
						System.out.println("\t\t" +direction+ " : " +local.getSaidas().get(direction));
					}
				}
			}
		}
	}
	
	static {
		try ( DataInputStream dataIn = new DataInputStream( new BufferedInputStream( new FileInputStream("locations.dat"))) ){
			while( true ) {
				try {
					Map<String, Integer> saidas = new HashMap<>();
					int idLocal = dataIn.readInt();
					String descricao = dataIn.readUTF();
					int num_saidas = dataIn.readInt();
					System.out.println("Read Location-> id: " +idLocal+ ", desc: " +descricao );
					for ( int i=0; i<num_saidas; i++ ) {
						String direction = dataIn.readUTF();
						int saida = dataIn.readInt();
						saidas.put( direction , saida );
						System.out.println( "\t\tSaida -> " +direction+ " : " +saida );
					}
					locations.put( idLocal, new Local(idLocal, descricao, saidas) );
				}catch (EOFException e) {
					System.out.println("Terminou de ler o ficheiro");
					break;
				} 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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

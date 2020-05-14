package input_output.random_access;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Local> {
	private static Map<Integer, Local> locations = new HashMap<Integer, Local>();
	private static Map<Integer, Index> indexes = new HashMap<>();
	public static RandomAccessFile readRandomAccessFile;
	
	public static void mainOld(String[] args) throws IOException {
		
		try( RandomAccessFile randomAccess = new RandomAccessFile("locations_random.dat", "rwd")  ){
			randomAccess.writeInt( locations.size() );//number of locations
			int indexSize = 3 * Integer.BYTES; //size of each index in bytes, it contains 3 integers
											   // First: the location id
											   // Second: the location offset
											   // Third: the location length
			int allIndexesSize = locations.size() * indexSize;//size of bytes needed to store all the indexes
			int locationsDataOffset = (int)randomAccess.getFilePointer() + allIndexesSize + Integer.BYTES;
										//Integer.BYTES is here because we have to sum the number of bytes needed
										//to store the locationsDataOffset that we are calculating here
			randomAccess.writeInt(locationsDataOffset);
			int indexOffset = (int)randomAccess.getFilePointer();//store the indexOffset to use later when
																 //storing the offsets
			//We need to store the locations data first and then store its indexes, because until now,
			//we don't know the details of the locations indexes, we will know as we write the locations,
			//so the indexes will be build during the process of writing data
			
			int nextLocationOffset = locationsDataOffset;
			randomAccess.seek( nextLocationOffset );
			for ( Local local : locations.values() ) {
				randomAccess.writeInt( local.getIdLocal() );
				randomAccess.writeUTF( local.getDescricao() );
				//Construct a String with the possible exits from the location,
				//so we can store them as a single String (only one disk access here)
				StringBuilder builder = new StringBuilder();
				for ( String direcao : local.getSaidas().keySet() ) {
					if ( !direcao.equalsIgnoreCase("Q") ) {
						builder.append( direcao );
						builder.append( "," );
						builder.append( local.getSaidas().get(direcao)  );
						builder.append( "," );
					}
				}
				randomAccess.writeUTF( builder.toString() );
				int curOffset = nextLocationOffset;
				nextLocationOffset = (int) randomAccess.getFilePointer();
				int curTamanho = nextLocationOffset - curOffset;
				indexes.put( local.getIdLocal(), new Index( curOffset, curTamanho ));
				//randomAccess.seek( nextLocationOffset ); //Don't need to seek() again because the pointer is
				//already in the byte next to the last written byte
			}
			
			randomAccess.seek( indexOffset );//move pointer to the offset of the indexes, to the location's indexes
			for ( int localID : indexes.keySet() ) {
				randomAccess.writeInt( localID );
				randomAccess.writeInt( indexes.get( localID ).getOffset() );
				randomAccess.writeInt( indexes.get( localID ).getTamanho() );
			}
		}
	}
	
	
	//1. This first 4Bytes will contain the number of locations (Byte 0-3 )
	//2. The next four bytes will contain the start offset of the locations section (Byte 4-7)
	//3. The next section of the file will contain the index ( the index is 1692 bytes long.
	//   it will start at byte 8 and end at byte 1699)
	//4. The final section of the file will contain the location records (the data).
	//	 it will start at byte 1700
	static {
		try {
			readRandomAccessFile = new RandomAccessFile( "locations_random.dat", "rwd" );
			
			int numberOfLocations = readRandomAccessFile.readInt();
			int locationsDataOffset = readRandomAccessFile.readInt();
			
			int nextIndexOffset = (int) readRandomAccessFile.getFilePointer();
			while ( nextIndexOffset < locationsDataOffset ) {
				//load all indexes to memory, and use them to access locations data in the file as needed
				//in the positions/offset that the application requires.
				int localID = readRandomAccessFile.readInt();
				int localOffset = readRandomAccessFile.readInt();
				int localTamanho = readRandomAccessFile.readInt();
				indexes.put( localID, new Index(localOffset, localTamanho) );
				nextIndexOffset = (int) readRandomAccessFile.getFilePointer();
			}
		} catch ( IOException exception ) {
			exception.printStackTrace();
		}
		
		
		
		/*
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
		*/
	}
	
	public Local getLocal( int localID ) throws IOException {
		Index index = indexes.get( localID );
		if ( index !=null ) {
			//move offset to after the id of the local
			readRandomAccessFile.seek( index.getOffset() + Integer.BYTES );
			String descricao = readRandomAccessFile.readUTF();
			String saidas_str = readRandomAccessFile.readUTF();
			String[] words = saidas_str.split(",");
			Map<String, Integer> saidas = new HashMap<>();
			for ( int i=0; i<words.length-1; i++) {
				saidas.put( words[i] , Integer.parseInt(words[++i]) );
			}
			return new Local( localID, descricao, saidas );
		}
		
		return null;
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
	
	public void close() throws IOException{
		readRandomAccessFile.close();
	}

}

package linkedlists;

import java.util.List;

public class Album {
	SongList list;
	
	public Album() {
		list = new SongList();
	}
	
	public void add( Song song ) {
		list.add(song);
	}
	
	public void remove( Song song ) {
		list.remove(song);
	}
	
	public Song get( int index ) {
		return list.get(index);
	}
	
	public boolean contains( Song song ) {
		return list.contains(song);
	}
	
	private class SongList {
		
		List<Song> songs;
		
		public void add( Song song ) {
			songs.add(song);
		}
		
		public void remove( Song song ) {
			songs.remove(song);
		}
		
		public Song get( int index ) {
			return songs.get(index);
		}
		
		public boolean contains( Song song ) {
			return songs.contains(song);
		}
	}
}

package linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PlayList {
	private static int CURSOR_FRONT = 1;
	private static int CURSOR_BACK = -1;
	
	private List<Album> albuns;
	private List<Song> playlist;
	private ListIterator<Song> list_iterator;
	private int cursor;
	
	public PlayList( List<Album> albuns ) {
		playlist = new LinkedList<Song>();
		this.albuns = albuns;
	}
	
	public void add( Song song ) {
		Iterator<Album> iterator = albuns.iterator();
		while (iterator.hasNext()) {
			if ( iterator.next().contains( song ) ) {
				playlist.add(song);
				list_iterator = playlist.listIterator();
				return;
			}
		}
		System.out.println("Song " +song+ " does not exist in any album");
	}
	
	public void remove( Song song ) {
		playlist.remove(song);
	}
	
	public void next() {
		if ( cursor==CURSOR_BACK ) {
			list_iterator.next();
		}
		if ( list_iterator.hasNext() ) {
			Song song = list_iterator.next();
			System.out.println("Playing song: " +song);
			cursor = CURSOR_FRONT;
		} else {
			System.out.println("This is the last song in the list");
		}
	}
	
	public void previous() {
		if ( cursor==CURSOR_FRONT ) {
			list_iterator.previous();
		}
		if ( list_iterator.hasPrevious() ) {
			Song song = list_iterator.previous();
			System.out.println("Playing song: " +song);
			cursor = CURSOR_BACK;
		} else {
			System.out.println("This is the first song in the list");
		}
	}
	
	public void replay() {
		if ( cursor==CURSOR_FRONT ) {
			Song song = list_iterator.previous();
			System.out.println("Playing song: " +song);
			cursor = CURSOR_BACK;
			
		} else if ( cursor==CURSOR_BACK ) {
			Song song = list_iterator.next();
			System.out.println("Playing song: " +song);
			cursor = CURSOR_FRONT;
		}
		else {
			System.out.println("Can't replay because no song is playing");
		}
	}
	
	
	public void list() {
		System.out.println("Songs in playlist:");
		Iterator<Song> iterator = playlist.iterator();
		while( iterator.hasNext() ) {
			System.out.println("-> " +iterator.next());
		}
	}
	
}

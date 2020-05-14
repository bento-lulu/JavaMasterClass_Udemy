package linkedlists;

public class Song {
	private String tittle;
	private double duration;
	
	
	public Song(String tittle, double duration) {
		super();
		this.tittle = tittle;
		this.duration = duration;
	}
	
	public String getTittle() {
		return tittle;
	}
	public double getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return "[ tittle = " +tittle+ ", duration = " +duration+  "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if ( obj instanceof Song && ((Song)obj).tittle.equals(tittle) ) {
			return true;
		}
		
		return false;
	}
}

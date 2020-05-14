package input_output.random_access;

public class Index {
	
	private int offset;
	private int tamanho;
	
	public Index( int offset, int tamanho ) {
		this.offset = offset;
		this.tamanho = tamanho;
	}

	public int getOffset() {return offset;}

	public int getTamanho() {return tamanho;}
	
}

package ex01_b.exceptions;

@SuppressWarnings("serial")
public class EmptyTreeException  extends RuntimeException{
	
	public EmptyTreeException(String err) {
		super(err);
	}

}

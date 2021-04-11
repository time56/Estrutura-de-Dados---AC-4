package ex01_a.exceptions;

@SuppressWarnings("serial")
public class InvalidKeyException extends RuntimeException{
	
	public InvalidKeyException(String err){
		super(err);		
	}

}

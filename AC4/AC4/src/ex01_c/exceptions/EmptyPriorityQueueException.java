package ex01_c.exceptions;

public class EmptyPriorityQueueException extends RuntimeException {
	
	public EmptyPriorityQueueException(String err) {
		super(err);
	}

}

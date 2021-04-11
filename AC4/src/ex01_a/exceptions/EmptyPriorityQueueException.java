package ex01_a.exceptions;

@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException {
	
	 public EmptyPriorityQueueException(String err) {
	        super(err);
	    }

}

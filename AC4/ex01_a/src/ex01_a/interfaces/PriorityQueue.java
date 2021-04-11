package ex01_a.interfaces;

import java.security.InvalidKeyException;
import ex01_a.exceptions.EmptyPriorityQueueException;

//Interface para o TAD fila de prioridade 
public interface PriorityQueue<K, V> {
	
	// Retorna a quantidade de itens na fila de prioridade 
	public int size( ); 
	
	// Retorna se a fila de prioridade está vazia 
	public boolean isEmpty( ); 
	
	// Retorna mas não remove uma entrada com chave mínima 
	public Entry<K,V> min() throws EmptyPriorityQueueException; 
	
	// Insere um par chave-valor e retorna a entrada criada 
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException; 
	
	// Remove e retorna uma entrada com chave mínima 
	public Entry<K,V> removeMin( ) throws EmptyPriorityQueueException; 

}

package commons;

// Interface para entrada do par de chave
public interface Entry<K, V> {
	// Retorna uma chave armazenada nesta entrada.
	public K getKey();
	
	// Retorna o valor armazenado nesta entrada.
	public V getValue();
}

package ex01_c.interfaces;

import ex01_b.interfaces.Position;

// Uma interface para a árvore binária completa.  Uma árvore binária com altura h
// é completa se os níveis 0,1,2,...,h-1 tiverem o número máximo de nodos possíveis
// (isto é, o nível i tem 2^i nodos, para 0 <= i <= h-1).

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
	
	// Adiciona um elemento à árvore após o último nodo. Retorna a nova posição criada.
	public Position<E> add(E elem);
	
	// Remove e retorna o elemento armazenado no último nodo da árvoere.
	public E remove();
}

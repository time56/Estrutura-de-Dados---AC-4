package ex01_c.interfaces;

import ex01_b.interfaces.Position;

// Uma interface para a �rvore bin�ria completa.  Uma �rvore bin�ria com altura h
// � completa se os n�veis 0,1,2,...,h-1 tiverem o n�mero m�ximo de nodos poss�veis
// (isto �, o n�vel i tem 2^i nodos, para 0 <= i <= h-1).

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
	
	// Adiciona um elemento � �rvore ap�s o �ltimo nodo. Retorna a nova posi��o criada.
	public Position<E> add(E elem);
	
	// Remove e retorna o elemento armazenado no �ltimo nodo da �rvoere.
	public E remove();
}

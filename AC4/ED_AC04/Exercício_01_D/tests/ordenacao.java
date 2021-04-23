package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tad_fila_prioridade_heap.HeapPriorityQueue;

class ordenacao {

	@Test
	void test() {
		HeapPriorityQueue<Integer, Integer> P = new HeapPriorityQueue<Integer, Integer>();
		P.insert(7, 9);
		P.insert(1, 1);
		P.insert(3, 3);
		P.insert(4, 6);
		P.insert(2, 2);
		P.insert(5, 7);
		P.insert(6, 8);
		
		
		assertEquals("[null, [(1,1),1], [(2,2),2], [(3,3),3], [(7,9),4], [(4,6),5], "
				+ "[(5,7),6], [(6,8),7]]", P.toString());
	}
}

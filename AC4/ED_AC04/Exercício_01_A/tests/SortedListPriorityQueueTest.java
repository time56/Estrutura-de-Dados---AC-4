package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import exceptions.EmptyPriorityQueueException;
import pessoa.PessoaComparator;
import pessoa.Pessoa;
import source.Entry;
import source.SortedListPriorityQueue;

class SortedListPriorityQueueTest {
	@Test
	void test_basico() {
		SortedListPriorityQueue<Integer, String> P = new SortedListPriorityQueue<Integer, String>();
		Entry<Integer, String> sa�da;
		
		sa�da = P.insert(5, "A");
		assertEquals("(5,A)", sa�da.toString());
		assertEquals("[(5,A)]", P.toString());
		
		sa�da = P.insert(9, "C");
		assertEquals("(9,C)", sa�da.toString());
		assertEquals("[(5,A), (9,C)]", P.toString());
		
		sa�da = P.insert(3, "B");
		assertEquals("(3,B)", sa�da.toString());
		assertEquals("[(3,B), (5,A), (9,C)]", P.toString());
		
		sa�da = P.insert(7, "D");
		assertEquals("(7,D)", sa�da.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", P.toString());
		
		sa�da = P.min();
		assertEquals("(3,B)", sa�da.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", P.toString());
		
		sa�da = P.removeMin();
		assertEquals("(3,B)", sa�da.toString());
		assertEquals("[(5,A), (7,D), (9,C)]", P.toString());
		assertEquals(3, P.size());
		
		sa�da = P.removeMin();
		assertEquals("(5,A)", sa�da.toString());
		assertEquals("[(7,D), (9,C)]", P.toString());
		
		sa�da = P.removeMin();
		assertEquals("(7,D)", sa�da.toString());
		assertEquals("[(9,C)]", P.toString());
		
		sa�da = P.removeMin();
		assertEquals("(9,C)", sa�da.toString());
		assertEquals("[]", P.toString());
		
		assertThrows(EmptyPriorityQueueException.class, () -> {P.removeMin();});
	}
	
	@Test
	void teste_comparador_de_Pessoa() {
		// ** Usando um comparador Espec�fico de Pessoa (baseado na idade) implementado dentro de Pessoa 
		// No lugar de valor usamos null, pois o objeto Pessoa cont�m todos os atributos necess�rios
		SortedListPriorityQueue<Pessoa, Pessoa> P = new SortedListPriorityQueue<Pessoa, Pessoa>();
		Entry<Pessoa, Pessoa> sa�da;
		Pessoa p1;
		
		p1 = new Pessoa("J", 20);
		sa�da = P.insert(p1, null);
		assertEquals("(Pessoa {nome=J, idade=20},null)", sa�da.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null)]", P.toString());
	
		p1 = new Pessoa("M", 30);
		sa�da = P.insert(p1, null);
		assertEquals("(Pessoa {nome=M, idade=30},null)", sa�da.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=M, idade=30},null)]", P.toString());
		
		p1 = new Pessoa("F", 25);
		sa�da = P.insert(p1, null);
		assertEquals("(Pessoa {nome=F, idade=25},null)", sa�da.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=F, idade=25},null), (Pessoa {nome=M, idade=30},null)]", P.toString());
	}
	
	@Test
	void teste_comparador_externo_de_Pessoa() {
		// **** Usando um Comparador Espec�fico de Pessoa (baseado no nome) implementado externamente *****
		// No lugar de valor usamos null, pois o objeto Pessoa cont�m todos os atributos necess�rios.
		Comparator<Pessoa> compa = new PessoaComparator();
		SortedListPriorityQueue<Pessoa, Pessoa> P = new SortedListPriorityQueue<Pessoa, Pessoa>(compa);
		Entry<Pessoa, Pessoa> saida;
		Pessoa p1;
	
		p1 = new Pessoa("J", 20);
		saida = P.insert(p1, null);
		assertEquals("(Pessoa {nome=J, idade=20},null)", saida.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null)]", P.toString());
		
		p1 = new Pessoa("M", 30);
		saida = P.insert(p1, null);
		assertEquals("(Pessoa {nome=M, idade=30},null)", saida.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=M, idade=30},null)]", P.toString());
	
		p1 = new Pessoa("F", 25);
		saida = P.insert(p1, null);
		assertEquals("(Pessoa {nome=F, idade=25},null)", saida.toString());
		assertEquals("[(Pessoa {nome=F, idade=25},null), (Pessoa {nome=J, idade=20},null), (Pessoa {nome=M, idade=30},null)]",
		P.toString());
	}
}

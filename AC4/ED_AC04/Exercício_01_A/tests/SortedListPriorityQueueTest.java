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
		Entry<Integer, String> saída;
		
		saída = P.insert(5, "A");
		assertEquals("(5,A)", saída.toString());
		assertEquals("[(5,A)]", P.toString());
		
		saída = P.insert(9, "C");
		assertEquals("(9,C)", saída.toString());
		assertEquals("[(5,A), (9,C)]", P.toString());
		
		saída = P.insert(3, "B");
		assertEquals("(3,B)", saída.toString());
		assertEquals("[(3,B), (5,A), (9,C)]", P.toString());
		
		saída = P.insert(7, "D");
		assertEquals("(7,D)", saída.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", P.toString());
		
		saída = P.min();
		assertEquals("(3,B)", saída.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", P.toString());
		
		saída = P.removeMin();
		assertEquals("(3,B)", saída.toString());
		assertEquals("[(5,A), (7,D), (9,C)]", P.toString());
		assertEquals(3, P.size());
		
		saída = P.removeMin();
		assertEquals("(5,A)", saída.toString());
		assertEquals("[(7,D), (9,C)]", P.toString());
		
		saída = P.removeMin();
		assertEquals("(7,D)", saída.toString());
		assertEquals("[(9,C)]", P.toString());
		
		saída = P.removeMin();
		assertEquals("(9,C)", saída.toString());
		assertEquals("[]", P.toString());
		
		assertThrows(EmptyPriorityQueueException.class, () -> {P.removeMin();});
	}
	
	@Test
	void teste_comparador_de_Pessoa() {
		// ** Usando um comparador Específico de Pessoa (baseado na idade) implementado dentro de Pessoa 
		// No lugar de valor usamos null, pois o objeto Pessoa contém todos os atributos necessários
		SortedListPriorityQueue<Pessoa, Pessoa> P = new SortedListPriorityQueue<Pessoa, Pessoa>();
		Entry<Pessoa, Pessoa> saída;
		Pessoa p1;
		
		p1 = new Pessoa("J", 20);
		saída = P.insert(p1, null);
		assertEquals("(Pessoa {nome=J, idade=20},null)", saída.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null)]", P.toString());
	
		p1 = new Pessoa("M", 30);
		saída = P.insert(p1, null);
		assertEquals("(Pessoa {nome=M, idade=30},null)", saída.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=M, idade=30},null)]", P.toString());
		
		p1 = new Pessoa("F", 25);
		saída = P.insert(p1, null);
		assertEquals("(Pessoa {nome=F, idade=25},null)", saída.toString());
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=F, idade=25},null), (Pessoa {nome=M, idade=30},null)]", P.toString());
	}
	
	@Test
	void teste_comparador_externo_de_Pessoa() {
		// **** Usando um Comparador Específico de Pessoa (baseado no nome) implementado externamente *****
		// No lugar de valor usamos null, pois o objeto Pessoa contém todos os atributos necessários.
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

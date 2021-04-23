package pessoa;

public class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private int idade;
	
	public Pessoa(String name, int idade) {
		this.nome = name;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	@Override
	public String toString() {
		return "Pessoa {nome=" + nome + ", idade=" + idade + "}";
	}
	
	public int compareTo(Pessoa pessoa) {
		if (this.idade < pessoa.idade) {
			return -1;
		}
		if (this.idade > pessoa.idade) {
			return 1;
		}
		return 0;
	}
}

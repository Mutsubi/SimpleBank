package Domain.Model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private static final String nome = "BancoX";
	private static List<Conta> contas = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
}

package Domain.Service;

import Domain.Model.Banco;
import Domain.Model.Conta;
import Domain.Service.Interfaces.IServiceBanco;

public class ServiceBanco implements IServiceBanco{

	@Override
	public void listaClientes(Banco banco) {
		
		StringBuilder str = new StringBuilder();
		
		for(Conta conta : banco.getContas()) {
				str.append(conta.getCliente().getNome()).append("\n");
			}
		if(str.toString() != "") {
			System.out.println(str.toString());
		}else {
			System.out.println("Lista de clientes vazia !!!");
		}
	}
	
	public void adicionarContaCliente(Banco banco, Conta conta){
		System.out.println("Novo Cliente: " + conta.getCliente().getNome() + "\n" + "Conta N° " + conta.getNumero());
		banco.getContas().add(conta);
	}
	
}

package Domain.Service;

import java.math.BigDecimal;

import Domain.Model.Conta;
import Domain.Service.Interfaces.IServiceConta;

public class ServiceConta implements IServiceConta{

	

	@Override
	public void transferir(BigDecimal valor, Conta conta1, Conta conta2) {
		System.out.println("===== TRANSFERÊNCIA =====");
		
		if(valor.compareTo(conta1.getSaldo()) < 1) {
			System.out.println("Subtraindo da conta: " + conta1.getCliente().getNome() +  "\nValor: " + valor);
			conta1.setSaldo(conta1.getSaldo().subtract(valor));
			System.out.println("Depositando na conta: " + conta2.getCliente().getNome() +  "\nValor: " + valor);
			conta2.setSaldo(conta2.getSaldo().add(valor));
		}else {
			System.out.println("Saldo insuficiente");
		}
		
		
	}

	@Override
	public void sacar(BigDecimal valor, Conta conta) {
		System.out.println("===== SAQUE =====");
		
		if(valor.compareTo(conta.getSaldo()) < 1) {
		System.out.println("Saque realizado da conta: " + conta.getCliente().getNome() +  "\nValor: " + valor);
		conta.setSaldo(conta.getSaldo().subtract(valor));
		}else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public void depositar(BigDecimal valor, Conta conta) {
		System.out.println("===== DEPÓSITO =====");
		System.out.println("Depositando na conta: " + conta.getCliente().getNome() +  "\nValor: " + valor);
		conta.setSaldo(conta.getSaldo().add(valor));		
	}
	
	public String infoConta(Conta conta) {
		StringBuilder info = new StringBuilder();
		
		info.append("=========== EXTRATO " + conta.getClass().getSimpleName().toString().toUpperCase() + " ===========\n");
		info.append("Agência: " + conta.getAgencia() + "\n");
		info.append("Conta N°: " + conta.getNumero() + "\n");
		info.append("Titular: " + conta.getCliente().getNome() + "\n");
		info.append("Saldo: " + (conta.getSaldo() == null ? 0 : conta.getSaldo()));
		
		return info.toString();
	}

}

package Application;

import java.math.BigDecimal;

import Domain.Model.Banco;
import Domain.Model.Cliente;
import Domain.Model.Conta;
import Domain.Model.ContaCorrente;
import Domain.Model.ContaPoupanca;
import Domain.Service.ServiceBanco;
import Domain.Service.ServiceConta;

public class Main {
	public static void main(String[] args) {
		
		Cliente clienteN1 = new Cliente("Teste1");
		Cliente clienteN2 = new Cliente("Teste2");

		Conta contaCorrenteN1 = new ContaCorrente(clienteN1);		
		Conta contaCorrenteN2 = new ContaCorrente(clienteN2);
		
		ServiceConta serviceConta = new ServiceConta();
		
		System.out.println(serviceConta.infoConta(contaCorrenteN1));
		System.out.println(serviceConta.infoConta(contaCorrenteN2));
		
		Conta contaPoupanca1 = new ContaPoupanca(clienteN1);
		Conta contaPoupanca2 = new ContaPoupanca(clienteN2);
		
		System.out.println(serviceConta.infoConta(contaPoupanca1));
		System.out.println(serviceConta.infoConta(contaPoupanca2));
		
		System.out.println("TESTE ADICIONAR SALDO\n");
		
		serviceConta.depositar(BigDecimal.valueOf(100.0), contaCorrenteN1);
		
		System.out.println(contaCorrenteN1.getSaldo());
		
		System.out.println("TESTE TRANSFERÊNCIA SALDO\n");
		
		serviceConta.transferir(BigDecimal.valueOf(100.0), contaCorrenteN1, contaCorrenteN2);
		
		System.out.println("TESTE TRANSFERÊNCIA INSUFICIENTE SALDO\n");
		
		serviceConta.transferir(BigDecimal.valueOf(100.0), contaCorrenteN1, contaCorrenteN2);
		
		System.out.println("TESTE SAQUE SALDO\n");
		
		serviceConta.sacar(BigDecimal.valueOf(100.0), contaCorrenteN2);

		System.out.println("Adicionando a lista de contas no banco:\n");
		
		Banco banco = new Banco();
				
		ServiceBanco serviceBanco = new ServiceBanco();
		
		serviceBanco.adicionarContaCliente(banco, contaCorrenteN1);
		serviceBanco.adicionarContaCliente(banco, contaCorrenteN2);
		serviceBanco.adicionarContaCliente(banco, contaPoupanca1);
		serviceBanco.adicionarContaCliente(banco, contaPoupanca2);

		System.out.println("\nImprimindo Clientes:\n");
		
		serviceBanco.listaClientes(banco);
		
	}
}

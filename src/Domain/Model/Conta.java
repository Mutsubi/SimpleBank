package Domain.Model;

import java.math.BigDecimal;


public class Conta {
	
	private static final int AGENCIA_APROVAÇÃO = 1;
	
	private static Long SEQUENCIAL = 1L;
	
	private Integer agencia;
	private Long numero;
	private BigDecimal saldo = BigDecimal.valueOf(0);
	private Cliente cliente;
	
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_APROVAÇÃO;
		this.numero = Conta.SEQUENCIAL++;
		this.cliente = cliente;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Long getNumero() {
		return numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	
}

package Domain.Service.Interfaces;

import java.math.BigDecimal;
import Domain.Model.Conta;

public interface IServiceConta {
	public void sacar(BigDecimal valor, Conta conta);
	public void depositar(BigDecimal valor, Conta conta);
	public void transferir(BigDecimal valor, Conta conta1, Conta conta2);
}

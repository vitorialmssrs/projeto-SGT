package controle;

import modelo.AlteracaoInformacoesEspacos;

public interface IAlteracaoInformacoesEspaco {

	public int inserirAlteracao (AlteracaoInformacoesEspacos end) ;
	public boolean atualizarAlteracao(AlteracaoInformacoesEspacos end);
	public boolean removerAlteracao(AlteracaoInformacoesEspacos end);
}

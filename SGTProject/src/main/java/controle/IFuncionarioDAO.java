package controle;

import java.util.ArrayList;
	
	
	public interface IFuncionarioDAO {

	
		public int inserirIDFuncionario(Funcionario end);
		
		public ArrayList <Funcionario> listarFuncionario();
		
		public boolean atualizarFuncionario(Funcionario end);
		
		public boolean removerFuncionario(Funcionario end);
		
	

}

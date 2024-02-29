package controle;

import java.util.ArrayList;

public class ControleFuncionario {
	
	
	public interface IFuncionarioDAO {

	
		public int inserirIDFuncionario(Funcionario end);
		
		public ArrayList <Funcionario> listarFuncionario();
		
		public boolean atualizarFuncionario(Funcionario end);
		
		public boolean removerFuncionario(Funcionario end);
		
		public Funcionario buscarFuncionarioPorCPF(int CPF);
		
		public Funcionario buscarFuncionarioPorID(int ID);
		
		
		
		

	}


}

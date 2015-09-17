package br.com.calceus.DAO;

import br.com.calceus.modelo.Funcionario;

public class FuncionarioDAO {
   private boolean sucesso;
   public boolean adicionarFuncionario(Funcionario funcionario){
	   //implementação
	   if(sucesso){
		   return true; 
	   }
	   else{
		   return false;
	   }
   }
   public boolean consultarFuncionario(int id){
	   // implementação
	   if(sucesso){
		   return true;
	   }
	   else{
		   return false; 
	   }
   }
   public void alterarFuncionario(){}
   
   
   public boolean excluirFuncionario(Funcionario funcionario){
	  //implementação
	   if(sucesso){
		   return true;
	   }
	   else{
		   return false;
	   }
   }
   
}

package br.com.calceus.programa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * PARA ACESSAR O BANCO COMO LOCALHOST EXECUTE O PASSO 4 SOMENTE E MUDE AS CONFIGURAÇÕES NO CÓDIGO

PARA DAR ACESSO AO BANCO DE DADOS EXTERNO

1-Editar o arquivo de configuração do mysql

	nano /etc/mysql/my.cnf

2 - Editar a linha onde esta assim:
	
	bind-address = 127.0.0.1

	para
	
		bind-address = ip-servidor-mysql (ex:192.168.2.21)

3 - Reiniciar o banco

	service mysql restart

	ou

	/etc/init.d/mysql restart


4 - RODAR O SCRIPT DO BANCO (Script Calceus.sql)

5 - LOGAR NO SHELL DO MYSQL 
	
	mysql -u root -p 
	
	
5 - CREATE USER 'calceus'@'192.168.2.21' IDENTIFIED BY 'calceusdb';

6 - GRANT ALL PRIVILEGES ON calceus.* TO 'calceus'@'192.168.2.21' WITH GRANT OPTION;

FLUSH PRIVILEGES;

 */
import br.com.calceus.banco.GerenciadorDeConexoes;

public class TestaConexao {

	// mudar para localhost onde está o IP e mudar o usuario e para root a senha do root
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = GerenciadorDeConexoes.getConnection("mysql", "192.168.2.27", "calceus", "calceus", "calceusdb");
		
		Statement st  = conn.createStatement();
		boolean resultado = st.execute("select * from Cargo"); //boolean para ser tratado depois
		ResultSet rs = st.getResultSet();
		
		while(rs.next()){
			String id = rs.getString("idCargo");
			System.out.println(id);
			String nome = rs.getString("nomeCargo");
			System.out.println(nome);
			String obs = rs.getString("obs");
			System.out.println(obs);
		}
		
		rs.close();
		st.close();
		conn.close();
		
	}
}

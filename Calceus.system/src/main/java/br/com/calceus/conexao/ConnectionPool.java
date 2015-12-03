package br.com.calceus.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {

	private DataSource dataSource;
	
	public ConnectionPool() {
		MysqlDataSource pool = new MysqlDataSource();
		pool.setURL("jdbc:mysql://localhost/calceus");
		pool.setUser("root");
		pool.setPassword("");
		this.dataSource = pool;
	}
	public Connection getConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
}

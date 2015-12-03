package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Statement;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Funcionario;

public class FuncionarioDAO {


	public boolean adicionarFuncionario(Funcionario funcionario) throws SQLException {
		String sql = "insert into funcionario (idCargo, nomeFuncionario, dataAdmissao, salario) values(?,?,?,?)";
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setInt(1, funcionario.getIdCargo());
				stmt.setString(2, funcionario.getNomeFuncionario());
				stmt.setDate(3, new Date(funcionario.getDataAdmissao().getTimeInMillis()));
				stmt.setDouble(4, funcionario.getSalario());
				stmt.execute();
				
				try (ResultSet resultado = stmt.getGeneratedKeys()) {
					while (resultado.next()) {
						System.out.println(resultado.getInt(1));
					}
				}
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao adicionar funcionario " + ex.getMessage());
			return false;
		}

	}

	public Funcionario consultarFuncionario(int id) throws SQLException {
		Funcionario funcionario = null;
		String sql = "select * from funcionario where idFuncionario = ? ";
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, id);
				try (ResultSet resultado = stmt.executeQuery()) {
					while (resultado.next()) {
						int idCargo = resultado.getInt("idCargo");
						String nome = resultado.getString("nomeFuncionario");
						Calendar data = new GregorianCalendar();
						data.setTime(resultado.getDate("dataAdmissao"));
						double salario = resultado.getDouble("salario");

						funcionario = new Funcionario(idCargo, nome, data, salario);

					}

				}

			}

		} catch (SQLException e) {
			System.out.println("Erro ao fazer busca de funcionario " + e.getMessage());

		}

		return funcionario;
	}

	public boolean alterarFuncionario(Funcionario funcionario) throws SQLException {
		String sql = "update funcionario set idCargo = ?, nomeFuncionario = ? where idFuncionario = ?";
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

				stmt.setInt(1, funcionario.getIdCargo());
				stmt.setString(2, funcionario.getNomeFuncionario());
				stmt.setInt(3, funcionario.getIdFuncionario());
				stmt.executeQuery();
				return true;
			} catch (SQLException e) {
				System.out.println("Erro ao alterar dados " + e.getMessage());
				return false;
			}
		}
	}

	public boolean excluirFuncionario(int idFuncionario) throws SQLException {
		String sql = "delete from funcionario where idFuncionario = ?";

		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, idFuncionario);
				stmt.executeQuery();
				return true;

			}

		} catch (SQLException e) {
			System.out.println("Erro ao exclur funcionario");
			return false;
		}

	}

	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario f = new Funcionario(1, "Romerito", Calendar.getInstance(), 3000.0);
		try {
			if(dao.adicionarFuncionario(f)){
				System.out.println("OK");
			}else{
				System.out.println("Erro");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Pedido;

public class PedidoDAO {

	public List<Pedido> consultarPedidos(int idCliente){
		List<Pedido> listaPedidos = null;
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "SELECT * FROM pedido WHERE idCliente = ";
			try(PreparedStatement pps = conexao.prepareStatement(sql)){
				pps.setInt(1, idCliente);
				ResultSet rs = pps.executeQuery();
				listaPedidos = new ArrayList<Pedido>();
				while(rs.next()){
					Pedido p = new Pedido();
					p.setIdPedido(rs.getInt("idPedido"));
					
					Calendar dataPedido = Calendar.getInstance();
					dataPedido.setTime(rs.getDate("dataPedido"));
					
					p.setDataPedido(dataPedido);
					p.setValorTotal(rs.getDouble("valorTotal"));
					p.getCliente().setIdCliente(rs.getInt("idCliente"));
					p.setIdPagamento(rs.getInt("idPagamento"));
					p.setPrazoEntrega(rs.getInt("prazoEntrega"));
					p.setDataEntrega(rs.getDate("dataEntrega"));
					p.setFrete(rs.getDouble("frete"));
					
					listaPedidos.add(p);
				}
				return listaPedidos;
			}catch (SQLException e) {
				System.out.println("Erro listar pedidos: "+ e.getMessage());
				return listaPedidos;
			}
			
		}catch (SQLException e) {
			System.out.println("Erro listar pedidos: "+ e.getMessage());
			return listaPedidos;
		}
	}

	public boolean confirmarPedido(Pedido pedido) {
		boolean resultado = false;
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "INSERT INTO pedido (";
			//TODO TERMINAR A QUERY
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, pedido.getIdPedido());
			return resultado;
		}catch (SQLException e) {
			e.printStackTrace();
			return resultado;
		}
		
	}

	
}

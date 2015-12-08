package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.ItemPedido;

public class ItemPedidoDAO {

	public List<ItemPedido> listaItensPedido(int numeroPedido) {
		List<ItemPedido> itens = null;
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "SELECT * FROM itempedido WHERE idPedido = ?";
			try(PreparedStatement pps = conexao.prepareStatement(sql)){
				pps.setInt(1, numeroPedido);
				ResultSet rs = pps.executeQuery();
				itens = new ArrayList<ItemPedido>();
				
				while(rs.next()){
					ItemPedido item = new ItemPedido();
					item.setIdItemProduto(rs.getInt("idItemPedido"));
					item.setIdProduto(rs.getInt("idProduto"));
					item.setIdPedido(rs.getInt("idPedido"));
					item.setQuantidade(rs.getInt("quantidade"));
					itens.add(item);
				}
				return itens;
			}catch (SQLException e) {
				e.printStackTrace();
				return itens;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return itens;
		}
		
	}

	
}

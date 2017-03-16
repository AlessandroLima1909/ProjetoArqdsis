package br.usjt.arqdsis.ProjetoArqdsis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdsis.ProjetoArqdsis.model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(nome, cpf, email, usuario, senha, horarioTrabalho, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getCpf());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getUsuario());
			stm.setString(5, usuario.getSenha());
			stm.setString(6, usuario.getHorarioTrabalho());
			stm.setInt(7, usuario.getTipoUsuario());

			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, cpf=?, email=?, usuario=?, senha=?, horarioTrabalho=?, tipoUsuario=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getCpf());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getUsuario());
			stm.setString(5, usuario.getSenha());
			stm.setString(6, usuario.getHorarioTrabalho());
			stm.setInt(7, usuario.getTipoUsuario());
			stm.setInt(8, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT nome, cpf, email, usuario, senha, horarioTrabalho, tipoUsuario FROM usuario WHERE usuario.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setEmail(rs.getString("email"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setHorarioTrabalho(rs.getString("horarioTrabalho"));
					usuario.setTipoUsuario(rs.getInt("tipoUsuario"));

				} else {
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setCpf(null);
					usuario.setEmail(null);
					usuario.setUsuario(null);
					usuario.setSenha(null);
					usuario.setHorarioTrabalho(null);
					usuario.setTipoUsuario(-1); // (verificar)

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

}

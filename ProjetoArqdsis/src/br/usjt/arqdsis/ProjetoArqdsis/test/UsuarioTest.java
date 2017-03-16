package br.usjt.arqdsis.ProjetoArqdsis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.usjt.arqdsis.ProjetoArqdsis.model.Usuario;
import br.usjt.arqdsis.ProjetoArqdsis.service.UsuarioService;

public class UsuarioTest {
	Usuario usuario, copia;
	UsuarioService usuarioService;
	static int id = 0;
		
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setCpf("Batista Cepelos");
		usuario.setEmail("09:00 as 19:00");
		usuario.setNome("09:00 as 19:00");
		//usuario.setPermissao("9");
		usuario.setSenha("23");
		usuario.setUsuario("23");
		copia = new Usuario();
		copia.setId(id);
		copia.setCpf("Batista Cepelos");
		copia.setEmail("09:00 as 19:00");
		copia.setNome("09:00 as 19:00");
		//copia.setPermissao("9");
		copia.setSenha("23");
		copia.setUsuario("23");
		usuarioService = new UsuarioService();
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o usuario 1 deve ter sido carregado no banco por fora
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setCpf("Batista Cepelos");
		usuario.setEmail("09:00 as 19:00");
		usuario.setNome("09:00 as 19:00");
		//usuario.setPermissao("9");
		usuario.setSenha("23");
		usuario.setUsuario("23");
		UsuarioService novoService = new UsuarioService();
		Usuario novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, usuario);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = usuarioService.criar(usuario);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		usuario.setNome("999999");
		copia.setNome("999999");		
		usuarioService.atualizar(usuario);
		usuario = usuarioService.carregar(usuario.getId());
		assertEquals("testa atualizacao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setCpf("Batista Cepelos");
		copia.setEmail("09:00 as 19:00");
		copia.setNome("09:00 as 19:00");
		//copia.setPermissao("9");
		copia.setSenha("23");
		copia.setUsuario("23");
		usuarioService.excluir(id);
		usuario = usuarioService.carregar(id);
		assertEquals("testa exclusao", usuario, copia);
	}

}

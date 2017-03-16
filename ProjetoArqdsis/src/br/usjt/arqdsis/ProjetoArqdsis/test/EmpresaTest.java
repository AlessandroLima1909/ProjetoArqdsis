package br.usjt.arqdsis.ProjetoArqdsis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.usjt.arqdsis.ProjetoArqdsis.model.Empresa;
import br.usjt.arqdsis.ProjetoArqdsis.service.EmpresaService;

public class EmpresaTest {
	Empresa empresa, copia;
	EmpresaService empresaService;
	static int id = 0;
		
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		empresa = new Empresa();
		empresa.setId(id);
		empresa.setRasaoSocial("Batista Cepelos");
		empresa.setHorarioFuncionamento("09:00 as 19:00");
		empresa.setHorarioAr("09:00 as 19:00");
		empresa.setConjuntos(9);
		empresa.setTemperaturaPadrao(23);
		copia = new Empresa();
		copia.setId(id);
		copia.setRasaoSocial("Batista Cepelos");
		copia.setHorarioFuncionamento("09:00 as 19:00");
		copia.setHorarioAr("09:00 as 19:00");
		copia.setConjuntos(9);
		copia.setTemperaturaPadrao(23);
		empresaService = new EmpresaService();
		System.out.println(empresa);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o empresa 1 deve ter sido carregado no banco por fora
		empresa = new Empresa();
		empresa.setId(id);
		empresa.setRasaoSocial("Batista Cepelos");
		empresa.setHorarioFuncionamento("09:00 as 19:00");
		empresa.setHorarioAr("09:00 as 19:00");
		empresa.setConjuntos(9);
		empresa.setTemperaturaPadrao(23);
		EmpresaService novoService = new EmpresaService();
		Empresa novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, empresa);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = empresaService.criar(empresa);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", empresa, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		empresa.setRasaoSocial("999999");
		copia.setRasaoSocial("999999");		
		empresaService.atualizar(empresa);
		empresa = empresaService.carregar(empresa.getId());
		assertEquals("testa atualizacao", empresa, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setRasaoSocial(null);
		copia.setHorarioFuncionamento(null);
		copia.setHorarioAr(null);
		copia.setConjuntos((Integer) null);
		copia.setTemperaturaPadrao((Integer) null);
		empresaService.excluir(id);
		empresa = empresaService.carregar(id);
		assertEquals("testa exclusao", empresa, copia);
	}
}

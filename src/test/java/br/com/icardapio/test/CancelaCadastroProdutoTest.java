package br.com.icardapio.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Assert;

import br.com.icardapio.test.page.LoginPage;
import br.com.icardapio.test.page.NovoProdutoPage;
import br.com.icardapio.test.page.TenantExistentePage;
import br.com.icardapio.test.util.AbstractCenario;
import br.com.icardapio.test.util.Paralelismo;

@RunWith(Paralelismo.class)
public class CancelaCadastroProdutoTest extends AbstractCenario{
	
	public CancelaCadastroProdutoTest(String sistemaOperacional, String navegador, String versaoNavegador) {
		super(sistemaOperacional, navegador, versaoNavegador);
	}

	private LoginPage loginPage = new LoginPage(getDriver());
	private NovoProdutoPage novoProdutoPage = new NovoProdutoPage(getDriver());
	
	@Before
	public void inicializa(){
		loginPage.acessarLogin();
		loginPage.efetuarLogin("admin", "admin");
		loginPage.clicaLogin();
	}
	
	@Test
	public void cadastraProdCancela(){
		novoProdutoPage.cadastrarProduto("Nome", "descricao", "32", "Pizza", false);
		Assert.assertEquals(false, novoProdutoPage.existeNaListagem("Nome", "32"));
	}
	
}

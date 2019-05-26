package br.com.icardapio.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.icardapio.test.page.LoginPage;
import br.com.icardapio.test.page.NovoProdutoPage;
import br.com.icardapio.test.page.TenantExistentePage;
import br.com.icardapio.test.util.AbstractCenario;
import br.com.icardapio.test.util.Paralelismo;

@RunWith(Paralelismo.class)
public class CadastraProdutoTest extends AbstractCenario{
	
	public CadastraProdutoTest(String sistemaOperacional, String navegador, String versaoNavegador) {
		super(sistemaOperacional, navegador, versaoNavegador);
	}

	private LoginPage loginPage = new LoginPage(getDriver());
	private NovoProdutoPage novoProdutoPage = new NovoProdutoPage(getDriver());
	private TenantExistentePage tenantExistente = new TenantExistentePage(getDriver());
	
	@Before
	public void inicializa(){
		loginPage.acessarLogin();
		loginPage.efetuarLogin("admin", "admin");
		loginPage.clicaLogin();
	}
	
	@Test
	public void cadastraProdOK(){
		novoProdutoPage.cadastrarProduto("Nome", "descricao", "32", "Pizza", true);
	}
	
	@After
	public void verificaExiteProd(){
		Assert.assertEquals(true, novoProdutoPage.existeNaListagem("Nome", "32"));
		Assert.assertEquals(true, novoProdutoPage.verificaMsgCadastroSucesso());
		tenantExistente.efetuarLogoff();
	}
}

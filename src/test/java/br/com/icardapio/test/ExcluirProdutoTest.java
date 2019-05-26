package br.com.icardapio.test;

import br.com.icardapio.test.page.LoginPage;
import br.com.icardapio.test.util.AbstractCenario;
import br.com.icardapio.test.util.Paralelismo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.icardapio.test.page.ExcluirProdutoPage;

@RunWith(Paralelismo.class)
public class ExcluirProdutoTest extends AbstractCenario{

	public ExcluirProdutoTest(String sistemaOperacional, String navegador, String versaoNavegador) {
		super(sistemaOperacional, navegador, versaoNavegador);
	}

	private LoginPage loginPage = new LoginPage(getDriver());
	private ExcluirProdutoPage excluirProdutoPage = new ExcluirProdutoPage(getDriver());
	
	@Before
	public void inicializa(){
		loginPage.acessarLogin();
		loginPage.efetuarLogin("admin", "admin");
		loginPage.clicaLogin();
	}
	
	@Test
	public void excluirProduto(){
		boolean apaga = true;
		excluirProdutoPage.excluirProduto("piraca", "456", apaga);
		
		if(apaga){
			Assert.assertEquals(true, excluirProdutoPage.verificaMsgRemocaoSucesso());
		}
	}

}

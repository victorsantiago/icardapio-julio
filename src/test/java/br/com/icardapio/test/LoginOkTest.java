package br.com.icardapio.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.Assert;

import br.com.icardapio.test.page.LoginPage;
import br.com.icardapio.test.page.TenantExistentePage;
import br.com.icardapio.test.util.AbstractCenario;
import br.com.icardapio.test.util.Constantes;
import br.com.icardapio.test.util.Paralelismo;

@RunWith(Paralelismo.class)
public class LoginOkTest extends AbstractCenario{
	
	public LoginOkTest(String sistemaOperacional, String navegador, String versaoNavegador) {
		super(sistemaOperacional, navegador, versaoNavegador);
	}

	private LoginPage loginPage = new LoginPage(getDriver());
	private TenantExistentePage tenantExistente = new TenantExistentePage(getDriver());
	
	@Test
	public void efetuarLoginSucesso(){
		loginPage.acessarLogin();
		loginPage.efetuarLogin("admin", "admin");
		loginPage.clicaLogin();
		Assert.assertEquals(Constantes.URL_BASEHEROKU+"victor", loginPage.getCurrentUrl());
	}
	
	@After
	public void validaLogoff(){
		tenantExistente.efetuarLogoff();
		Assert.assertEquals(Constantes.URL_BASEHEROKU+"victor", loginPage.getCurrentUrl());
	}
}

package br.com.icardapio.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.Assert;

import br.com.icardapio.test.page.LoginPage;
import br.com.icardapio.test.util.AbstractCenario;
import br.com.icardapio.test.util.Constantes;
import br.com.icardapio.test.util.Paralelismo;

@RunWith(Paralelismo.class)
public class LoginErrorTest extends AbstractCenario{
	
	public LoginErrorTest(String sistemaOperacional, String navegador, String versaoNavegador) {
		super(sistemaOperacional, navegador, versaoNavegador);
	}

	private LoginPage loginPage = new LoginPage(getDriver());
	
	@Test
	public void efetuarLoginError(){
		loginPage.acessarLogin();
		loginPage.efetuarLogin("admin", "w");
		loginPage.clicaLogin();
		Assert.assertEquals(true, loginPage.verificaMsgLoginError());
		Assert.assertEquals(loginPage.getCurrentUrl(), Constantes.URL_BASEHEROKU+"victor/loginError");
	}


}

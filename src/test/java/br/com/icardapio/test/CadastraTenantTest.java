package br.com.icardapio.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.Assert;

import br.com.icardapio.test.page.NovoTenantPage;
import br.com.icardapio.test.page.TenantExistentePage;
import br.com.icardapio.test.util.AbstractCenario;
import br.com.icardapio.test.util.Constantes;
import br.com.icardapio.test.util.Paralelismo;

@RunWith(Paralelismo.class)
public class CadastraTenantTest extends AbstractCenario{
	
	public CadastraTenantTest(String sistemaOperacional, String navegador, String versaoNavegador) {
		super(sistemaOperacional, navegador, versaoNavegador);
	}

	private NovoTenantPage cadastroTenantPage = new NovoTenantPage(getDriver());
	private TenantExistentePage tenantExistentePage = new TenantExistentePage(getDriver());
	
	@Before
	public void acessarInicio(){
		cadastroTenantPage.acessarPageInicial();
	}
	
	@Test
	public void cadastroTenant(){
		cadastroTenantPage.cadastrarTenant("Restaurante pekka", 
				"tudo muito caro", "pekka", "16-981692987", "Av. Algum lugar", "Cidade/UF");
	}
	
	@After
	public void verificaDados(){
		tenantExistentePage.verificaDadosTenant("Restaurante pekka", 
				"tudo muito caro", "16-981692987", "Av. Algum lugar", "Cidade/UF");
	}
	
	@After
	public void verificaURL(){
		Assert.assertEquals(cadastroTenantPage.getCurrentUrl(), Constantes.URL_BASEHEROKU+"pekka");
	}
}

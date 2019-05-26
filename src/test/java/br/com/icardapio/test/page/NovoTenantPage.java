package br.com.icardapio.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.icardapio.test.util.AbstractPage;
import br.com.icardapio.test.util.Constantes;
import br.com.icardapio.test.util.WebDriverSingleton;

public class NovoTenantPage extends AbstractPage {

	private WebDriver driver;

	public NovoTenantPage(WebDriver driver) {
		super(driver);
	}

	public void acessarPageInicial() {
		driver.get(Constantes.URL_BASEHEROKU);
	}

	public void cadastrarTenant(String nome, String slogan, String subdominio, String telefone, String endereco,
			String cidade) {

		WebElement txtNome = driver.findElement(By.name("name"));
		WebElement txtSlogan = driver.findElement(By.name("slogan"));
		WebElement txtSubdominio = driver.findElement(By.name("subdomain"));
		WebElement txtTelefone = driver.findElement(By.name("phone"));
		WebElement txtEndereco = driver.findElement(By.name("address"));
		WebElement txtCidade = driver.findElement(By.name("city"));

		txtNome.sendKeys(nome);
		txtSlogan.sendKeys(slogan);
		txtSubdominio.sendKeys(subdominio);
		txtTelefone.sendKeys(telefone);
		txtEndereco.sendKeys(endereco);
		txtCidade.sendKeys(cidade);

		driver.findElement(By.xpath("//button[@value='Submit']")).click();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
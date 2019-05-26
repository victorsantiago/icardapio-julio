package br.com.icardapio.test.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.icardapio.test.util.AbstractPage;
import br.com.icardapio.test.util.WebDriverSingleton;

public class TenantExistentePage extends AbstractPage {

	private WebDriver driver;

	public TenantExistentePage(WebDriver driver) {
		super(driver);
	}

	public void deletaProduto() {		
		driver.findElement(By.cssSelector("i.icon-trash.icon-white")).click();		
	}

	public boolean verificaDadosTenant(String nome, String slogan, String telefone, String endereco, String cidade) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(slogan)
				&& driver.getPageSource().contains(telefone) && driver.getPageSource().contains(endereco)
				&& driver.getPageSource().contains(cidade);
	}

	public void efetuarLogoff() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Ação")).click();
		driver.findElement(By.linkText("Sair")).click();
	}

}

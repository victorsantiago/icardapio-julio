package br.com.icardapio.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.icardapio.test.util.AbstractPage;
import br.com.icardapio.test.util.Constantes;

public class LoginPage extends AbstractPage {

	private WebDriver driver;

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void acessarLogin() {
		driver.get(Constantes.URL_BASEHEROKU + "victor");
		driver.findElement(By.linkText("Entrar")).click();
	}

	public void efetuarLogin(String nome, String pass) {

		WebElement txtNome = driver.findElement(By.name("j_username"));
		WebElement txtPass = driver.findElement(By.name("j_password"));

		txtNome.sendKeys(nome);
		txtPass.sendKeys(pass);
	}

	public void clicaLogin() {
		driver.findElement(By.name("submit")).click();
	}

	public boolean verificaMsgLoginError() {
		WebElement campoMensagem = driver.findElement(By.className("alert-danger"));
		return campoMensagem.getText().contains("Invalid username or password.");
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
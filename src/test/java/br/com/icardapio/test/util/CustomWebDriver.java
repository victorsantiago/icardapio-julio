package br.com.icardapio.test.util;

import org.openqa.selenium.WebDriver;

public class CustomWebDriver {

	private WebDriver webDriver;

	private String navegador;

	private String sistemaOperacional;

	private String versaoNavegador;

	public CustomWebDriver(String sistemaOperacional, String navegador, String versaoNavegador, WebDriver webDriver) {
		this.sistemaOperacional = sistemaOperacional;
		this.navegador = navegador;
		this.versaoNavegador = versaoNavegador;
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String getNavegador() {
		return navegador;
	}

	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getVersaoNavegador() {
		return versaoNavegador;
	}

	public void setVersaoNavegador(String versaoNavegador) {
		this.versaoNavegador = versaoNavegador;
	}

}

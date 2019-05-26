package br.com.icardapio.test.util;

import java.util.LinkedList;

import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

public abstract class AbstractCenario {

	protected String sistemaOperacional;
	protected String navegador;
	protected String versaoNavegador;

	// Executa o teste de uma aplicação em todos os navegadores ao mesmo
	// tempo.
	// Se eu efetuar um cadastro em uma aplica��o, esses testes efetuaram 4
	// cadastros ao mesmo tempo na minha aplicação?

	@Parameterized.Parameters
	public static LinkedList<String[]> getEnvironments() throws Exception {
		LinkedList<String[]> env = new LinkedList<String[]>();
		env.add(new String[] { "Windows 10", "chrome", "55.0" });
		env.add(new String[] { "Windows 10", "firefox", "49.0" });
		env.add(new String[] { "Windows 10", "internet explorer", "9" });
		env.add(new String[] { "Linux", "operablink", "12.15" });
		return env;
	}

	public AbstractCenario(String sistemaOperacional, String navegador, String versaoNavegador) {
		this.sistemaOperacional = sistemaOperacional;
		this.navegador = navegador;
		this.versaoNavegador = versaoNavegador;
	}

	protected WebDriver getDriver() {
		return WebDriverSingleton.getDriver(sistemaOperacional, navegador, versaoNavegador);
	}

}

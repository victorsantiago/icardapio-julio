package br.com.icardapio.test.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	private WebDriver driver;

	private WebDriverWait wait;

	protected WebDriverWait getWait() {
		return wait;
	}

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}

	protected WebDriver getDriver() {
		return driver;
	}

}

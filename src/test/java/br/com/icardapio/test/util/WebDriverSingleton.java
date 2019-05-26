package br.com.icardapio.test.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class WebDriverSingleton {

	private static List<CustomWebDriver> drivers = new ArrayList<CustomWebDriver>();

	public static WebDriver getDriver(String sistemaOperacional, String navegador, String versaoNavegador) {
		WebDriver driver = null;
		for (CustomWebDriver webDriver : drivers) {
			if (webDriver.getNavegador().equals(navegador)
					&& webDriver.getSistemaOperacional().equals(sistemaOperacional)
					&& webDriver.getVersaoNavegador().equals(versaoNavegador)) {
				driver = webDriver.getWebDriver();
				break;
			}
		}
		if (driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability("platform", sistemaOperacional);
			capabilities.setCapability("browserName", navegador);
			capabilities.setCapability("version", versaoNavegador);
			try {
				driver = new RemoteWebDriver(
						new URL("http://victorsantiago:a12fdd18-a8ed-4200-8b7b-cc58fd85d550@ondemand.saucelabs.com:80/wd/hub"),
						capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			CustomWebDriver customWebDriver = new CustomWebDriver(sistemaOperacional, navegador, versaoNavegador,
					driver);
			drivers.add(customWebDriver);
		}

		return driver;
	}

}

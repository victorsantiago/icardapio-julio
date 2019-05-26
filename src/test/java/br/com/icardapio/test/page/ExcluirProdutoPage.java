package br.com.icardapio.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.com.icardapio.test.util.AbstractCenario;
import br.com.icardapio.test.util.AbstractPage;
import br.com.icardapio.test.util.WebDriverSingleton;

public class ExcluirProdutoPage extends AbstractPage{

	private WebDriver driver;

	public ExcluirProdutoPage(WebDriver driver) {
		super(driver);
	}

	public void excluirProduto(String produto, String preco, boolean confirma) {
		WebElement elemento = null;
		elemento = driver
				.findElement(By.xpath("//h3[text()='" + produto + "']/../span[contains(text(), '" + preco + "')]/a"));
		elemento.click();
		if (confirma) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}

	public boolean verificaMsgRemocaoSucesso() {
		WebElement campoMensagem = driver.findElement(By.className("alert-success"));
		return campoMensagem.getText().contains("Produto removido com sucesso");
	}

}

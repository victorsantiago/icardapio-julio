package br.com.icardapio.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.icardapio.test.util.AbstractPage;
import br.com.icardapio.test.util.WebDriverSingleton;

public class NovoProdutoPage extends AbstractPage{
	
	private WebDriver driver;
	
	public NovoProdutoPage(WebDriver driver) {
		super(driver);
	}

	public void cadastrarProduto(String nome, String descricao, 
			String preco, String categoria, boolean cadastra){
		
		//driver.findElement(By.xpath("//a[contains(text(),'Ação')]")).click();
		driver.findElement(By.linkText("Ação")).click();
		driver.findElement(By.xpath("//a[@href='#addProductModal']")).click();
		
		Select cbCategoria = new Select (driver.findElement(By.id("category.id")));
		cbCategoria.selectByVisibleText(categoria);
		
		WebElement txtNome = driver.findElement(By.id("name"));
		WebElement txtDescricao = driver.findElement(By.id("description"));
		WebElement txtPreco = driver.findElement(By.id("price"));
		
		txtNome.sendKeys(nome);
		txtDescricao.sendKeys(descricao);
		txtPreco.sendKeys(preco);
		
		if(cadastra == true){
			driver.findElement(By.linkText("Adicionar")).click();
		} else{
			driver.findElement(By.linkText("Cancelar")).click();
		}
	}
	
	public boolean verificaMsgCadastroSucesso(){
		WebElement campoMensagem = driver.findElement(By.className("alert-success"));
		return campoMensagem.getText().contains("Produto adicionado com sucesso");
	}
	
	public boolean existeNaListagem(String nome, String preco) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(preco);
	}
	
}
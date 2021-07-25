package desafio_base2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;	
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void escrever(String tipo, String texto) {
		driver.findElement(By.name(tipo)).sendKeys(texto);
	}

	public String obterValor(String texto) {		
		return driver.findElement(By.className(texto)).getText();

	}

	public void clicar(String tipo) {
		driver.findElement(By.className(tipo)).click();
	}
	
	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	public String usarXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public void clicarBotaoXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void selecionarCombo(String nome, int valor) {
		WebElement element = driver.findElement(By.name(nome));
		Select combo = new Select(element);
		combo.selectByIndex(valor);
	}

}

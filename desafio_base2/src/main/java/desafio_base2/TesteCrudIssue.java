package desafio_base2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCrudIssue {

	private WebDriver driver;
	private CrudPage pageCrud;
	private LoginPage pageLogin;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\ARQUIVOS\\TESTES AUTOMATIZADOS CUCUMBER\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.get("http://mantis-prova.base2.com.br");
		pageLogin = new LoginPage(driver);
		pageCrud = new CrudPage(driver);
		pageLogin.login();
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void cadastrarIssue() {
		pageCrud.clicarLink("Report Issue");
		pageCrud.clicarBotao("button");
		pageCrud.opcaoCombo(1);
		pageCrud.setSumario("Sumário");
		pageCrud.setDescricao("Descrição");
		pageCrud.clicarBotao("button");
		Assert.assertTrue(pageCrud.obterMsgValidacao("//div[@align='center']").contains("Operation successful."));
	}
	
	@Test
	public void validaCategoria() {
		pageCrud.clicarLink("Report Issue");
		pageCrud.clicarBotao("button");
		pageCrud.setSumario("Sumário");
		pageCrud.setDescricao("Descrição");
		pageCrud.clicarBotao("button");
		Assert.assertEquals(pageCrud.obterMsgValidacao("//p"), "A necessary field \"Category\" was empty. Please recheck your inputs.");
	}
	
	@Test
	public void validaSumario() {
		pageCrud.clicarLink("Report Issue");
		pageCrud.clicarBotao("button");
		pageCrud.opcaoCombo(1);
		pageCrud.setDescricao("Descrição");
		pageCrud.clicarBotao("button");
		Assert.assertEquals(pageCrud.obterMsgValidacao("//p"), "A necessary field \"Summary\" was empty. Please recheck your inputs.");
	}
	
	@Test
	public void validaDescricao() {
		pageCrud.clicarLink("Report Issue");
		pageCrud.clicarBotao("button");
		pageCrud.opcaoCombo(1);
		pageCrud.setSumario("Sumário");
		pageCrud.clicarBotao("button");
		Assert.assertEquals(pageCrud.obterMsgValidacao("//p"), "A necessary field \"Description\" was empty. Please recheck your inputs.");
	}
	
	@Test
	public void adicionarNotas() {
		pageCrud.clicarLink("0007030");
		pageCrud.setarNota("Nova nota");
		pageCrud.clicarComXpath("//input[@value='Add Note']");
	}
	
	@Test
	public void validarNota() {
		pageCrud.clicarLink("0007030");
		pageCrud.clicarComXpath("//input[@value='Add Note']");
		Assert.assertEquals(pageCrud.obterMsgValidacao("//p"), "A necessary field \"Note\" was empty. Please recheck your inputs.");
	}
}

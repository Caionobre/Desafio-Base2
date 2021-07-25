package desafio_base2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteLogin {
	
	private LoginPage pageLogin;
	private WebDriver driver;	
	
	@Before
	public void inicializa() {		
		System.setProperty("webdriver.chrome.driver","F:\\ARQUIVOS\\TESTES AUTOMATIZADOS CUCUMBER\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.get("http://mantis-prova.base2.com.br");	
		pageLogin = new LoginPage(driver);
	}
	
	@After
	public void encerrar() {
		driver.quit();
	}	
	
	@Test
	public void Login() {
		pageLogin.setUsuario("caio.nobre");
		pageLogin.setSenha("teste1234");
		pageLogin.submit();
		Assert.assertEquals(pageLogin.obterResultado(), "Logged in as: caio.nobre (Caio Nobre - reporter)");
	}
	
	@Test
	public void usernameIncorreto() {
		pageLogin.setSenha("1234");
		pageLogin.submit();
		Assert.assertEquals(pageLogin.obterValidacao(), "Your account may be disabled or blocked or the username/password you entered is incorrect.");
	}

	@Test
	public void passwordIncorreto() {
		pageLogin.setUsuario("caiocesar");
		pageLogin.submit();
		Assert.assertEquals(pageLogin.obterValidacao(), "Your account may be disabled or blocked or the username/password you entered is incorrect.");
	}
	
	@Test
	public void usernameVazio() {
		pageLogin.setSenha("teste1234");
		pageLogin.submit();
		Assert.assertEquals(pageLogin.obterValidacao(), "Your account may be disabled or blocked or the username/password you entered is incorrect.");
	}
	
	@Test
	public void passwordVazio() {
		pageLogin.setUsuario("caio.nobre");
		pageLogin.submit();
		Assert.assertEquals(pageLogin.obterValidacao(), "Your account may be disabled or blocked or the username/password you entered is incorrect.");
	}
	
}

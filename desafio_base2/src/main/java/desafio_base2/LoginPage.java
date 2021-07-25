package desafio_base2;

import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private DSL dsl;

	public LoginPage(WebDriver driver) {		
		dsl = new DSL(driver);
	}	

	public void setUsuario(String usuario) {
		dsl.escrever("username", usuario);
	}
	
	public void setSenha(String senha) {
		dsl.escrever("password", senha);
	}
	
	public void submit() {
		dsl.clicar("button");
	}
	
	public String obterResultado() {
		return dsl.obterValor("login-info-left");
	}
	
	public String obterValidacao() {
		return dsl.usarXpath("//font");
	}
	
	public void login() {
		dsl.escrever("username", "caio.nobre");
		dsl.escrever("password", "teste1234");
		dsl.clicar("button");
	}

}

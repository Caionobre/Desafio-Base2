package desafio_base2;

import org.openqa.selenium.WebDriver;

public class CrudPage {
	
	private DSL dsl;
	
	public CrudPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void clicarLink(String texto) {
		dsl.clicarLink(texto);
	}
	
	public void opcaoCombo(int opcao) {
		dsl.selecionarCombo("category_id", opcao);
	}
	
	public void setSumario(String texto) {
		dsl.escrever("summary", texto);
	}
	
	public void setDescricao(String texto) {
		dsl.escrever("description", texto);
	}
	
	public String obterMsgValidacao(String xpath) {
		return dsl.usarXpath(xpath);
	}
	
	public void setarNota(String texto) {
		dsl.escrever("bugnote_text", texto);
	}
	
	public void clicarBotao(String tipo) {
		dsl.clicar(tipo);
	}
	
	public void clicarComXpath(String texto) {
		dsl.clicarBotaoXpath(texto);
	}

}

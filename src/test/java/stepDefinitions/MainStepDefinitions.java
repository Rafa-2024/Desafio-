package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainStepDefinitions {

    WebDriver driver = DriverManager.getDriver();
    MainPage mainPage = new MainPage();

    @When("clicar no menu de opções referente a caixa de texto 'Pesquisa Amazon.com.br'")
    public void clicarNoMenuDeOpcoesReferenteACaixaDeTexto() {
      //  mainPage.clickNameOnOptionButton("url", 20);
        mainPage.clickAtOffsetPage();

    }
    @Then("a lista de opções deve estar em ordem alfabética")
    public void aListaDeOpcoesDeveEstarEmOrdemAlfabetica() {
        assertThat("A lista de elementos não está em ordem alfabética", mainPage.validatePageOrderTextFromSearchList(), is(true));
    }

    @Given("clicado no menu de opções da caixa de pesquisa")
    public void clicadoNoMenuDeOpcoesDaCaixaDePesquisa() {
       // mainPage.clickNameOnOptionButton("url", 20);

        mainPage.clickAtOffsetPage();
    }
    @Given("for selecionada a opção {string} no menu de opções da caixa de pesquisa")
    public void forSelecionadaAOpcaoNoMenuDeOpcoesDaCaixaDePesquisa(String departament) {

        mainPage.clickOnElementUsingJS(departament);
    }
    @When("preencher {string} na caixa de pesquisa")
    public void preencherNaCaixaDePesquisa(String text) {
        mainPage.setTextOnField(text);
    }
    @Then("a lista de opções de autocomplete deve aparecer {string}")
    public void aListaDeOpcoesDeAutocompleteDeveAparecer(String option) {
        assertThat("O texto "+option+" não foi encontrado na lista de autocomplete", mainPage.verifyAutoCompletedListFromSearcher(option), is(true));
    }

    @Then("o autocomplete não deve ser apresentar a opção {string}")
    public void oAutocompleteNãoDeveSerApresentarAOpção(String option) throws InterruptedException {
        Thread.sleep(3000);
        assertThat("O texto "+option+" não foi encontrado na lista de autocomplete", mainPage.verifyAutoCompletedListFromSearcher(option), is(false)); ;
    }
    
    @Then("validar que a palavra {string} está vísivel na lista do menu {string}")
    public void validarQueAPalavraEstáVísivelNaListaDoMenu(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("clicar em link {string}")
    public void clicarEm(String link) {
        mainPage.clickOnLinkInMenuHeader(link);
    }

    @Then("validar que a página {string} carregou corretamente")
    public void validarQueAPágina(String title) {


        assert mainPage.validateElement(title):"A página não carregou corretamente";

    }

    @Given("o site {string} foi acessado")
    public void oSiteFoiAcessado(String url) {
        driver.get(url);
        driver.navigate().refresh();
    }

    @When("teste")
    public void teste() {
    }
}

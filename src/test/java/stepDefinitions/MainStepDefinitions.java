package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainStepDefinitions {

    @Given("o site da Amazon foi acessado")
    public void oSiteDaAmazonFoiAcessado() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("clicar no menu de opções referente a caixa de texto {string}")
    public void clicarNoMenuDeOpcoesReferenteACaixaDeTexto(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("a lista de opções deve estar em ordem alfabética")
    public void aListaDeOpcoesDeveEstarEmOrdemAlfabetica() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("clicado no menu de opções da caixa de pesquisa")
    public void clicadoNoMenuDeOpcoesDaCaixaDePesquisa() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Given("for selecionada a opção {string} no menu de opções da caixa de pesquisa")
    public void forSelecionadaAOpcaoNoMenuDeOpcoesDaCaixaDePesquisa(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("preencher {string} na caixa de pesquisa")
    public void preencherNaCaixaDePesquisa(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("a lista de opções de autocomplete deve aparecer {string}")
    public void aListaDeOpcoesDeAutocompleteDeveAparecer(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("o autocomplete não deve ser apresentar a opção {string}")
    public void oAutocompleteNãoDeveSerApresentarAOpção(String arg0) {

    }
    
    @Then("validar que a palavra {string} está vísivel na lista do menu {string}")
    public void validarQueAPalavraEstáVísivelNaListaDoMenu(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("clicar em {string}")
    public void clicarEm(String arg0) {
        
    }

    @Then("validar que a página {string}")
    public void validarQueAPágina(String arg0) {
    }
}

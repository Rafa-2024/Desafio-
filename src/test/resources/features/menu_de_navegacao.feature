@All
Feature: Menu de navegação
  da página principal do site da Amazon

  Background: Acessar o site da Amazon
    Given o site "https://www.amazon.com.br" foi acessado

  @teste1
  Scenario: Desativar captcha
    When teste

    @teste2
    Scenario Outline: Validar que a página "<link>" é aberta ao clicar na opção correspondente
      When clicar em link "<link>"
      Then validar que a página "<title>" carregou corretamente
      Examples:
        | link            | title         |
        | Venda na Amazon | Vender         |
        | Prime           | Prime         |
        | Mais Vendidos   | Mais Vendidos |
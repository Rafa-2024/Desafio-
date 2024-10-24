@All
Feature: Menu de navegação da página principal do site da Amazon

  Background: Acessar o site da Amazon
    Given o site da Amazon foi acessado

    Scenario Outline: Validar que a página "<link>" é aberta ao clicar na opção correspondente
      When clicar em "<link>"
      Then validar que a página "<link>"
      Examples:
        | link           |
        | Mais vendidos  |
        | Prime          |
        | Mais vendidos  |

    Scenario: Validar que o menu de opções é aberto quando a opção "Todos" é clicada no menu de navegação
      When clicar em "Todos"
      Then validar que a palavra "Destaque" está vísivel na lista do menu 'Todos'




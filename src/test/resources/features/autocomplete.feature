@All2
Feature: Autocomplete da caixa de texto de pesquisa

  Rule: A caixa de texto deve ser auto completada conforme for preenchida e conforme o departamento selecionado

    Background: Acessar o site da Amazon
      Given o site "https://www.amazon.com.br" foi acessado

       @Desconsiderado
    Scenario: Após clicar no menu de opções referente a caixa de texto "Pesquisa Amazon.com.br", deve aparecer a lista de opções de filtragem em ordem alfabética
      When clicar no menu de opções referente a caixa de texto 'Pesquisa Amazon.com.br'
      Then a lista de opções deve estar em ordem alfabética


         #O primeiro cenário abaixo foi criado apenas no intuito de desativar o capatcha, deve ser desconsiderado do resultado da automação
         #O captcha da Amazon está afetando em algumas execuções o primeiro cenário da fila de testes, por tanto, como esse projeto é basicamente
         #apenas para passar no desafio e fins academicos, sera mantido dessa forma.

    @teste1
    Scenario: Desativar captcha
         When teste

    @teste1
    Scenario Outline: Com a opção no menu de opções da caixa de texto "Pesquisa Amazon.com.br" selecionada, ao preencher o parte do produto desejado, deve aparecer a opção desejada na caixa de texto
      Given clicado no menu de opções da caixa de pesquisa
      And for selecionada a opção "<departamento>" no menu de opções da caixa de pesquisa
      When preencher "<parte_da_palavra>" na caixa de pesquisa
      Then a lista de opções de autocomplete deve aparecer "<produto>"
      Examples:
        | departamento           | produto | parte_da_palavra |
        | Games                  | zelda   | z                |
        | Todos os departamentos | colher  | colh             |

      Scenario: Com a opção "Todos" selecionada, após digitar a letra "z", não deve ser apresentada a opção "Zelda" na lista de opções
        Given clicado no menu de opções da caixa de pesquisa
        And for selecionada a opção "Todos os departamentos" no menu de opções da caixa de pesquisa
        When preencher "z" na caixa de pesquisa
        Then o autocomplete não deve ser apresentar a opção "zelda"







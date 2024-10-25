@All
Feature: Autocomplete da caixa de texto de pesquisa

  Rule: A caixa de texto deve ser auto completada conforme for preenchida e conforme o departamento selecionado

    Background: Acessar o site da Amazon
      Given o site "https://www.amazon.com.br" foi acessado

         #O primeiro cenário abaixo foi criado apenas no intuito de desativar o capatcha, deve ser desconsiderado do resultado da automação
         #O captcha da Amazon está afetando em algumas execuções o primeiro cenário da fila de testes, por tanto, como esse projeto é basicamente
         #apenas para passar no desafio e fins academicos, sera mantido dessa forma.

    @retiraCaptcha
    Scenario: Desativar captcha
         When teste

    @teste1
    Scenario Outline: Com a opção "<departamento>" da caixa de texto "Pesquisa Amazon.com.br" selecionada, ao preencher "<parte_da_palavra>", deve aparecer "<produto>" na lista de opções de autocomplete
      Given clicado no menu de opções da caixa de pesquisa
      And for selecionada a opção "<departamento>" no menu de opções da caixa de pesquisa
      When preencher "<parte_da_palavra>" na caixa de pesquisa
      Then a lista de opções de autocomplete deve aparecer "<produto>"
      Examples:
        | departamento                          | produto                      | parte_da_palavra               |
        | Games                                 | zelda                        | z                              |
        | Todos os departamentos                | colher                       | colh                           |
        | Alexa Skills                          | amazon kids                  | amazon                         |
        | Alimentos e Bebidas                   | chocolate                    | choco                          |
        | Amazon Quase Novo                     | alexa quase novo             | alexa                          |
        | Apps e Jogos                          | jogos gratis                 | jogos                          |
        | Audiolivros Audible                   | audiobook                    | audio                          |
        | Automotivo                            | cera automotiva              | cera                           |
        | Bebês                                 | carrinho de bebe             | carr                           |
        | Beleza                                | secador de cabelo            | seca                           |
        | Beleza de Luxo                        | secador de cabelo dyson      | seca                           |
        | Bolsas, Malas e Mochilas              | mochila masculina            | moch                           |
        | Brinquedos e Jogos                    | hot wheels                   | hot                            |
        | Casa                                  | cadeira ergonomica           | cade                           |
        | CD e Vinil                            | aerosmith                    | aero                           |
        | Cozinha                               | escorredor de louça          | esco                           |
        | Dispositivos Amazon                   | alexa                        | alex                           |
        | DVD e Blu-Ray                         | matrix                       | matr                           |
        | Eletrodomésticos                      | maquina de lavar             | maqu                           |
        | Eletrônicos                           | placa de vídeo               | placa                          |
        | Esportes e Aventuras                  | bola de volei                | bola                           |
        | Ferramentas e Materiais de Construção | martelo                      | mart                           |
        | Instrumentos Musicais                 | sintetizador                 | sint                           |
        | Livros                                | ficção científica            | ficção                         |
        | Material para Escritório e Papelaria  | caneta esferográfica         | caneta                         |
        | Móveis e Decoração                    | mesa de jantar               | mesa                           |
        | Roupas Calçados e Joias               | sapato feminino              | sapato                         |

    @teste2
      Scenario: Com a opção "Todos" selecionada, após digitar a letra "z", não deve ser apresentada a opção "Zelda" na lista de opções
        Given clicado no menu de opções da caixa de pesquisa
        And for selecionada a opção "Automotivo" no menu de opções da caixa de pesquisa
        When preencher "z" na caixa de pesquisa
        Then o autocomplete não deve ser apresentar a opção "zelda"







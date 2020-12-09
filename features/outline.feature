@outline
Feature: Feature Outline

  Scenario Outline: Testing on multiples sites

    Given que seja acessado a lista de sites "<site>"
    When for verificado os titulos "<title>"
    Then uma pagina qualquer dentro do site e acessado

    Examples:
      | site                             | title                                                                    |
      | https://www.uol.com.br/          | UOL - O melhor conteúdo                                                  |
      | https://www.microsoft.com/pt-br/ | Microsoft - Official Home Page                                           |
      | https://www.globo.com/           | globo.com - Absolutamente tudo sobre notícias, esportes e entretenimento |
@google
Feature: Acessando Google

  Scenario: Acessar google efetuar pesquisa

    Given que seja acessado o site "https://www.google.com/"
    When for efetuado pesquisa sobre "Java FrontEnd"
    Then o primeiro link deve ser acessado
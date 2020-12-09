@globo
Feature: Acessando site da Globo.com

  Scenario: Acesso ao site e verificação do Título

    Given que seja acessado o endereço "https://www.globo.com"
    When quando for verificado o título
    Then  criar reporte ou clicar em qualquer link
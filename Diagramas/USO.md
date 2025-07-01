%% Diagrama de Casos de Uso

%% Salve como .md para renderizar no GitHub

graph TD

`    `Usuario((Usuário))



`    `subgraph Sistema

`        `CadastrarLixo[ "Cadastrar dados do lixo" ]

`        `CalcularEnergia[ "Calcular energia gerada" ]

`        `GerarRelatorio[ "Gerar relatório HTML" ]

`    `end

`    `Usuario --> CadastrarLixo

`    `Usuario --> CalcularEnergia

`    `Usuario --> GerarRelatorio

`    `CalcularEnergia -->|Usa| ProcessarOrganico

`    `CalcularEnergia -->|Usa| ProcessarSeco

`    `ProcessarOrganico[ "Processar lixo orgânico" ]

`    `ProcessarSeco[ "Processar lixo seco" ]


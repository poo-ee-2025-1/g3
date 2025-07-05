````mermaid

sequenceDiagram
    participant Usuario
    participant DadosRepository
    participant Dados
    participant LixoSeco
    participant LixoOrganico
    participant CriadorHTML
    
    Usuario->>DadosRepository: create(dados)
    DadosRepository->>Dados: save dados
    DadosRepository-->>Usuario: dados criado
    
    Usuario->>LixoSeco: ProcessoMadeira/Papel/Tecidos(area)
    LixoSeco-->>Usuario: energia calculada
    
    Usuario->>LixoOrganico: Processo(lixo, area, volume)
    LixoOrganico-->>Usuario: energia calculada
    
    Usuario->>CriadorHTML: CriarHTML(dados)
    CriadorHTML-->>Usuario: arquivo HTML criado
    
    Usuario->>CriadorHTML: AbrirHTML()
    CriadorHTML-->>Usuario: relatório aberto no navegador

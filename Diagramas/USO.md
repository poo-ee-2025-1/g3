````mermaid
usecaseDiagram
    actor Usuario
    
    Usuario --> (Criar/Editar Dados)
    Usuario --> (Excluir Dados)
    Usuario --> (Gerar Relatório HTML)
    Usuario --> (Abrir Relatório HTML)
    
    (Criar/Editar Dados) --> (Salvar no Banco de Dados)
    (Excluir Dados) --> (Remover do Banco de Dados)
    
    (Salvar no Banco de Dados) --> (Dados Repository)
    (Remover do Banco de Dados) --> (Dados Repository)
    
    (Gerar Relatório HTML) --> (Lixo Seco: Calcular Energia)
    (Gerar Relatório HTML) --> (Lixo Orgânico: Calcular Energia)
    (Gerar Relatório HTML) --> (Criar HTML)
    (Abrir Relatório HTML) --> (Visualizar HTML)

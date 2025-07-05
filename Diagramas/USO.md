flowchart TD
    Usuario["Usuário"]
    
    Usuario -->|Criar/Editar Dados| CriarEditarDados["Salvar no Banco de Dados"]
    Usuario -->|Excluir Dados| ExcluirDados["Remover do Banco de Dados"]
    Usuario -->|Gerar Relatório HTML| GerarRelatorio["Calcular Energia (Lixo Seco/Orgânico)"]
    Usuario -->|Abrir Relatório HTML| AbrirRelatorio["Visualizar HTML"]
    
    CriarEditarDados --> DadosRepository["Dados Repository"]
    ExcluirDados --> DadosRepository
    GerarRelatorio --> CriarHTML["Criar HTML"]

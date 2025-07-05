`````mermaid

flowchart TD
    Usuario([Usuário])
    CriarEditar([Criar/Editar Dados])
    Excluir([Excluir Dados])
    GerarHTML([Gerar Relatório HTML])
    AbrirHTML([Abrir Relatório HTML])
    SalvarDB([Salvar no Banco de Dados])
    RemoverDB([Remover do Banco de Dados])
    CalculoSeco([Lixo Seco: Calcular Energia])
    CalculoOrganico([Lixo Orgânico: Calcular Energia])
    Criador([Criar HTML])
    Visualizar([Visualizar HTML])
    Repositorio([DadosRepository])

    Usuario --> CriarEditar
    Usuario --> Excluir
    Usuario --> GerarHTML
    Usuario --> AbrirHTML

    CriarEditar --> SalvarDB
    Excluir --> RemoverDB

    SalvarDB --> Repositorio
    RemoverDB --> Repositorio

    GerarHTML --> CalculoSeco
    GerarHTML --> CalculoOrganico
    GerarHTML --> Criador
    AbrirHTML --> Visualizar

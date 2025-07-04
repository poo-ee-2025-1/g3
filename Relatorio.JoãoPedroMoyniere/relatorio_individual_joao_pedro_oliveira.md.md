# Relatório Individual - João Pedro Oliveira

### Segue um relatório individual relatando a minha contribuição para o projeto de tema "Geração de Energia Elétrica a partir de Lixo".

## Cargo Atribuído
 - Fui responsável pelo **Lixo Orgânico e classes relacionadas, Database, CriadorHTML**.

## Tarefas Realizadas
- Desenvolvi a estrutura de cálculo relacionado ao processo de geração de energia a partir do lixo orgânico. Fiz um PDF mostrando a origem dos cálculos.
- Implementei estruturas do processo de geração de energia do lixo orgânico com o processo de geração de energia do lixo seco realizado pelo **Pablo Henrique**.
- Implementei alguns dos códigos realizados pelos colegas na branch "main".
- Criei um diagrama no PlantUML mostrando as váriaveis e processos. Este diagrama foi então aprimorado pelo **Pablo Henrique**, que escreveu com **Mermaid**.
- Organizei todo a parte "model" do projeto, em um pacote chamado "model".
 
## Ferramentas
- BlueJ, para escrever o  código
- EclipseIDE, para escrever o código
- LibreOffice Writer para escrever o PDF sobre a geração de gás metano produzido pelo lixo orgânico e o PDF de relações entre o lixo seco e o lixo orgânico.

### Sobre o BlueJ e o EclipseIDE
Para realizar o projeto, eu usei o **BlueJ e o EclipseIDE** para poder realizar os códigos. No começo eu estava usando o BlueJ, mas como foi aumentando o projeto e mais classes eram criadas, **eu comecei a usar o Eclipse, que era mais fácil de navegar**, já que para navegar entre classes no BlueJ de diferentes pacotes, **ele criava muitas janelas, o que dificultava a navegação.**

## Commits Mais Relevantes da branch "main"
### Commit # e13792c - Criação de HTML e dados, e organização em pacotes:
Além de deixar a parte "model" dentro de pacotes, eu tinha criado as classes "CriadorHTML" e "Dados", que permitiu **a criação dos relatórios contendo as informações sobre o lixo e do gerador**, e que permitiu **salvar e carregar as variáveis em arquivos ".DAT" usando o "implements Serializable"**. Essa maneira de salvar e carregar as variáveis foi antes da aula do banco de dados, e foi um método bem básico de como salvar e carregar os objetos.

### Commit # 4023cf9 - Adicionado arquivos da branch "code-test":
Adicionei os arquivos da branch "code-test" em que **eu e o Pablo** estavamos testando e alterando os códigos relacionados ao "model" do projeto. Foi nesse commit em que foi adicionado o **Banco de Dados** com a parte do **CRUD** (Create, Read, Update, Delete) além de diversas **atualizações para as classes "model"**.

## Dificuldades Enfrentadas
As dificuldades enfrentadas em relação a programação do projeto foram:
- **Criar uma forma de salvar e carregar as variáveis.** Como não tinha visto sobre o banco de dados, eu tava indo atrás sobre **salvar e carregar os objetos e suas variáveis**, tanto é que foi por isso que a primeira versão da classe "Dados" usava o **"Serializable"**, que permitia salvar um objeto como um arquivo. <br><br>
- **Trabalhar com o Banco de Dados.** Como eu não tinha visto sobre banco de dados, eu olhei o tutorial que o professor fez em que usava como exemplo a classe "Student", e copiei o código mas **realizando as alterações necessárias para acomodar a classe "Dados"**. <br><br>
- **Implementar as bibliotecas no EclipseIDE.** Como eu tinha mudado do BlueJ para o Eclipse, eu tive que ver como que era implementado as bibliotecas do JavaFX e do Database, enfrentando problemas **devido a forma de como eu estava implementando as bibliotecas** (eu não estava prestando atenção no "module-info.java") e também a um **conflito entre o "ormlite.jdbc" e "ormlite.core"** que impedia o uso das classes desses pacotes. <br><br>
- **Corrigir Problemas da Interface.** Como ninguém tinha visto tanto sobre como funciona as interações da interface com o "model" do projeto, **todos os membros** ajudaram a fazer com que a interface interagisse com o banco de dados.

## Considerações Finais

Os códigos do projeto funcionam usando a interface **JavaFX** feita no SceneBuilder além de usar métodos **CRUD** no Banco de Dados. Os códigos conseguem **criar uma previsão da energia total que uma terméletrica pode gerar.** usando o lixo como fonte de combústivel e informações sobre a caldeira da terméletrica.
<br>
Na realização do projeto eu aprendi sobre como usar um **Database**, sobre como funciona as **interações entre o back-end com o front-end (dos códigos com as interfaces)** e também sobre o **EclipseIDE** e de como importar **pacotes e bibliotecas** usando o "module-info" do java.
<br>




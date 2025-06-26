----------------------------------------------------------------------------
Este é o arquivo README do projeto. Você deve descrever aqui o seu projeto.
Informe ao usuário (alguém que não sabe nada sobre este projeto!) tudo que
ele/ela precisa saber. Os comentários devem incluir, pelo menos:
----------------------------------------------------------------------------

TÍTULO DO PROJETO: Geração de Energia a partir de Lixo Seco e Molhado

OBJETIVO DO PROJETO: 
Este projeto tem como objetivo simular o aproveitamento energético de resíduos sólidos,
dividindo a análise entre dois tipos de lixo: o lixo seco (madeira, tecidos e papéis)
e o lixo molhado (resíduos orgânicos que produzem metano). O sistema calcula a energia
gerada por cada tipo, exibe relatórios no terminal e salva arquivos com os resultados.

VERSÃO: 4.0

COMO INICIAR O PROJETO:  
1. Compile todos os arquivos do projeto em sua IDE (recomenda-se o uso do BlueJ).
2. Execute a classe `Main` que está localizada no pacote `app`.
3. Siga as instruções no terminal para inserir os dados de entrada referentes
   à quantidade de lixo molhado e seco.
4. Após a execução, o programa exibirá os relatórios de energia gerada e salvará
   um arquivo `.html` com os dados do lixo molhado e um `.DAT` com os dados serializados.

AUTORES: Pablo Henrique Rodrigues Gomes (responsável pela parte de Lixo Seco)
         [Nomes dos colegas, se desejar adicionar aqui também]

INSTRUÇÕES PARA O USUÁRIO:
- Insira os valores conforme solicitado no terminal. Utilize ponto (.) como separador decimal.
- Informe:
  - A quantidade de lixo molhado (em toneladas)
  - A área da turbina (em m²)
  - A massa de madeira, tecidos e papéis (em kg)
  - A eficiência da queima dos materiais secos (valor entre 0 e 1)

- O relatório completo será exibido no terminal ao final da execução.
- Um arquivo HTML com os dados do lixo molhado será salvo no diretório do projeto.
- Um arquivo `.DAT` será criado para armazenar os dados serializados da simulação.

Observação: o projeto faz uso de princípios de Programação Orientada a Objetos,
com separação de responsabilidades entre pacotes, e integração de módulos de cálculo
físico-químico.

----------------------------------------------------------------------------


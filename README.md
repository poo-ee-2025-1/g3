🗂️ Relatório Final do Projeto: Geração de Energia a partir de Lixo Seco e Molhado

🎯 1. Objetivo Geral

O projeto visa simular o reaproveitamento energético de materiais descartados pela sociedade, focando em duas categorias de lixo:

Lixo Molhado → convertido em metano para geração de energia via turbinas.

Lixo Seco → convertido diretamente por meio da queima de materiais (madeira, tecidos, papéis).

A proposta simula cenários reais de reaproveitamento e avalia as perdas e eficiências térmicas no processo.

🧱 2. Estrutura do Projeto

O projeto foi dividido em módulos principais, utilizando os princípios da programação orientada a objetos (POO):

♻️ Módulo Lixo Molhado:

Calcula a quantidade de metano gerado a partir da massa de lixo.

Converte a massa em energia utilizando dados reais de entalpia.

Simula o uso dessa energia em turbinas, estimando a potência gerada.

Salva relatórios automáticos em HTML e arquivos serializados.

🔥 Módulo Lixo Seco:

Recebe massas de madeira, tecidos e papéis.

Calcula a energia aparente, útil e perdida com base em eficiência fornecida pelo usuário.

Exibe relatórios no terminal com dados convertidos para Joules, Wh e kWh.

🔗 Integração Geral:

Os módulos foram integrados em um projeto coeso.

Foi criado um ponto de entrada com interface terminal para que o usuário simule ambos os sistemas.

📊 3. Tabela de Participantes

Nome do Participante

Responsabilidades

Pablo Henrique

Lixo Seco; Integração de códigos

João Moiniere

Lixo Molhado; Banco de dados

Ítalo & Arthur

Interface e apresentação visual

🧰 4. Tecnologias e Ferramentas Utilizadas

Ferramenta / Plataforma

Função Utilizada no Projeto

Java

Linguagem principal do projeto

BlueJ

Ambiente de desenvolvimento

GitHub

Versionamento de código e integração de equipe

SQL (conceitual)

Modelagem para futura expansão com banco

Mermaid.js

Diagrama de classes

HTML

Geração automática de relatórios visuais

🧠 5. Conceitos Acadêmicos Envolvidos

Conversão de unidades de energia (J, Wh, kWh)

Eficiência térmica e perdas por calor

Massa molar, densidade, entalpia

Serialização de objetos e arquivos

Geração dinâmica de arquivos HTML

Diagramas UML (com Mermaid.js)

🖥️ 6. Execução do Projeto

Compile o projeto completo em sua IDE Java (recomendado: BlueJ).

Execute a classe Main no pacote app.

Forneça os valores solicitados:

Massa de lixo molhado (toneladas)

Massa de materiais secos (kg)

Eficiência da queima

Área da turbina (m²)

Os resultados serão exibidos no terminal e salvos automaticamente.

🧾 7. Códigos-Fonte e Diagrama de Classes

A seguir está o diagrama de classes do projeto, criado com Mermaid.js, representando a estrutura dos pacotes e relações entre as classes principais:

classDiagram

class Main {
  +main(String[]): void
}

class LixoSeco {
  - mMadeira: double
  - mTecidos: double
  - mPapeis: double
  - eficiencia: double
  - jAparente: double
  - jUtil: double
  - jPerda: double
  + calcularEnergias(): void
  + getJAparente(): double
  + getJUtil(): double
  + getJPerda(): double
}

class ConEnSec {
  + aparenteParaWh(ls): double
  + utilParaWh(ls): double
  + perdaParaWh(ls): double
}

class ReEnSec {
  - ls: LixoSeco
  - ces: ConEnSec
  + relatorio(): void
}

class Conversoes {
  + energia_met(double): double
  + massa_met(double): double
  + mol_met(double): double
}

class Turbina {
  - area_turbina: double
  + set_area_turbina(double): void
  + energia_paraVelocidade(double): void
  + potencia_maxima(double): double
}

class EficienciaBiometano {
  + eficiencia: double
  + entalpia_metano: double
}

class Dados {
  + local: String
  + toneladas_lixo: double
  + metano_produzido: double
  + energia_lixo: double
  + area_turbina: double
  + SalvarDados(Dados): void
}

class CriadorHTML {
  + CriarHTML(Dados): void
}

Main --> LixoSeco
Main --> ConEnSec
Main --> ReEnSec
Main --> Conversoes
Main --> Turbina
Main --> Dados
Main --> CriadorHTML

ReEnSec --> LixoSeco
ReEnSec --> ConEnSec
ConEnSec --> LixoSeco
Conversoes --> EficienciaBiometano
Turbina --> Conversoes

📌 8. Considerações Finais

Este projeto buscou aliar conceitos de física, sustentabilidade e programação orientada a objetos, fornecendo uma simulação educacional do potencial de reaproveitamento de lixo para geração de energia.

O uso de arquivos e interfaces simples permite que o código seja expandido futuramente para interface gráfica, banco de dados real e aplicações web.

Obrigado pela atenção! 😊


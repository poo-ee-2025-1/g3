Relatório de Desenvolvimento – Projeto de Geração de Energia a partir do Lixo
Aluno: Pablo Henrique Rodrigues Gomes
Disciplina: Programação Orientada a Objetos
IDE utilizada: BlueJ
Linguagem: Java
Data de alteração: 26/06/2025

Objetivo do Projeto
O projeto tem como objetivo simular a geração de energia a partir da decomposição e queima de diferentes tipos de lixo, dividindo o sistema em duas frentes principais:

Lixo molhado (biomassa orgânica, como restos de comida e resíduos biodegradáveis)

Lixo seco (materiais como madeira, tecidos e papéis)

A proposta é modelar o comportamento físico-químico de ambos os tipos de resíduos e calcular a energia que pode ser gerada a partir deles.

Divisão de Tarefas
O projeto foi desenvolvido em equipe, sendo minha responsabilidade a implementação do módulo de lixo seco. A parte de lixo molhado ficou a cargo dos colegas, sendo posteriormente integrada em um sistema unificado.

Parte do Lixo Seco
Implementei a parte de simulação energética do lixo seco com as seguintes características:

Entrada das massas (em kg) de madeira, tecidos e papéis

Cálculo da energia aparente, útil (após eficiência da queima) e perdida

Conversões de energia para Wh e kWh

Exibição formatada dos dados em forma de tabela (relatório no terminal)

Principais classes desenvolvidas:

LixoSeco (modelo)

ConEnSec (conversor de energia)

ReEnSec (relatório formatado)

Integração dos Módulos
A etapa final do projeto consistiu na integração dos dois módulos em um único sistema executável. Essa integração foi feita na classe Main, localizada no pacote app. Os principais pontos da integração foram:

Reorganização dos pacotes para manter a modularidade:

util → classes gerais e compartilhadas

modelo → estrutura de dados do lixo seco

servicos → lógica de cálculo e conversão de energia do lixo seco

app → ponto de entrada da aplicação

Unificação da entrada de dados com Scanner

Exibição conjunta dos relatórios de lixo seco e molhado

Manutenção da geração automática de arquivos .html e .DAT com os dados do lixo molhado

Resultados
O programa foi capaz de:

Simular de forma precisa a produção de energia a partir de lixo seco e molhado

Exibir de forma clara os dados no terminal

Salvar automaticamente os resultados da simulação

Reforçar o uso de princípios de POO, como encapsulamento, separação de responsabilidades e modularidade

Conclusão
O projeto contribuiu significativamente para o aprofundamento do entendimento de Programação Orientada a Objetos, especialmente em relação à organização de pacotes, reaproveitamento de código, serialização de objetos e manipulação de entrada/saída em Java. Além disso, integrou conceitos interdisciplinares envolvendo física, química e sustentabilidade.

```mermaid
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

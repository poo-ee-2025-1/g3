\documentclass[12pt]{article}
\usepackage[brazil]{babel}
\usepackage[utf8]{inputenc}
\usepackage{graphicx}
\usepackage{amsmath, amssymb}
\usepackage{hyperref}
\usepackage{geometry}
\geometry{a4paper, margin=2.5cm}
\usepackage{longtable}

\title{\textbf{Relatório Final do Projeto: Geração de Energia a partir de Lixo Seco e Molhado}}
\author{Grupo de Alunos de Programação Orientada a Objetos}
\date{\today}

\begin{document}

\maketitle

\section*{1. Objetivo Geral}
O projeto visa simular o reaproveitamento energético de materiais descartados pela sociedade, focando em duas categorias principais de lixo:

\begin{itemize}
\item \textbf{Lixo Molhado}: convertido em metano para geração de energia via turbinas.
\item \textbf{Lixo Seco}: convertido diretamente por meio da queima de materiais como madeira, tecidos e papéis.
\end{itemize}

O projeto simula cenários reais de reaproveitamento e avalia as perdas e eficiências térmicas nos processos de conversão.

\section*{2. Estrutura do Projeto}
O projeto foi dividido em módulos, utilizando os princípios da Programação Orientada a Objetos (POO):

\subsection*{Módulo Lixo Molhado}
\begin{itemize}
\item Cálculo da quantidade de metano gerado.
\item Conversão da massa de metano em energia.
\item Simulação do uso da energia em turbinas.
\item Geração automática de relatórios HTML e arquivos serializados.
\end{itemize}

\subsection*{Módulo Lixo Seco}
\begin{itemize}
\item Entrada de massas de madeira, tecidos e papéis.
\item Cálculo de energia aparente, útil e perdida com base em eficiência.
\item Relatório completo no terminal com conversões para J, Wh e kWh.
\end{itemize}

\subsection*{Integração Geral}
\begin{itemize}
\item Os módulos foram integrados em um único sistema funcional.
\item O ponto de entrada permite simular ambas as abordagens.
\end{itemize}

\section*{3. Participantes do Projeto}
\begin{longtable}{|l|p{10cm}|}
\hline
\textbf{Nome} & \textbf{Responsabilidades} \
\hline
Pablo Henrique & Lixo Seco; Integração de códigos. \
\hline
João Moiniere & Lixo Molhado; Banco de dados. \
\hline
Ítalo e Arthur & Interface gráfica e apresentação. \
\hline
\end{longtable}

\section*{4. Tecnologias Utilizadas}
\begin{longtable}{|l|p{10cm}|}
\hline
\textbf{Tecnologia} & \textbf{Função no Projeto} \
\hline
Java & Linguagem principal do projeto. \
\hline
BlueJ & IDE utilizada para desenvolvimento. \
\hline
GitHub & Controle de versão e repositório. \
\hline
SQL (conceitual) & Modelagem de banco de dados para expansão futura. \
\hline
HTML & Geração automática de relatórios visuais. \
\hline
Mermaid.js & Geração de diagramas UML. \
\hline
\end{longtable}

\section*{5. Conceitos Acadêmicos Envolvidos}
\begin{itemize}
\item Conversão de unidades de energia (J, Wh, kWh).
\item Eficiência térmica e perdas energéticas.
\item Cálculo de massa molar, densidade e entalpia.
\item Serialização de objetos Java.
\item Geração automática de arquivos HTML.
\item Diagramação de classes com Mermaid.js.
\end{itemize}

\section*{6. Execução do Projeto}
\begin{enumerate}
\item Compile o projeto em sua IDE (preferencialmente BlueJ).
\item Execute a classe \texttt{Main} no pacote \texttt{app}.
\item Insira os seguintes valores:
\begin{itemize}
\item Massa de lixo molhado (em toneladas);
\item Massa dos materiais secos (em kg);
\item Eficiência da queima (entre 0 e 1);
\item Área da turbina (em $m^2$).
\end{itemize}
\item O sistema apresentará os resultados no terminal e salvará os relatórios.
\end{enumerate}

\section*{7. Códigos-Fonte e Diagrama de Classes (Mermaid)}

Abaixo está o diagrama de classes no padrão Mermaid.js, que pode ser visualizado diretamente no GitHub com suporte a Mermaid:

\begin{verbatim}

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

\end{verbatim}

\section*{8. Considerações Finais}
Este projeto buscou aliar conceitos de \textbf{física}, \textbf{sustentabilidade} e \textbf{programação orientada a objetos}, fornecendo uma simulação educacional do potencial de reaproveitamento do lixo para geração de energia.

A arquitetura modular e orientada a objetos permite futuras expansões com interface gráfica, banco de dados reais e aplicações web.

\vspace{1em}
\textbf{Obrigado pela atenção! 😊}

\end{document}


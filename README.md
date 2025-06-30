# 🗂️ Relatório Final do Projeto: Geração de Energia a partir de Lixo Seco e Molhado

---

## 🎯 1. Objetivo Geral

O projeto visa **simular o reaproveitamento energético** de materiais descartados pela sociedade, focando em duas categorias principais de lixo:

- 🔄 **Lixo Molhado**: convertido em metano para geração de energia via turbinas.
- 🔥 **Lixo Seco**: convertido diretamente por meio da queima de materiais (madeira, tecidos, papéis).

A proposta simula cenários reais de reaproveitamento e avalia as perdas e eficiências térmicas no processo.

---

## 🧱 2. Estrutura do Projeto

O projeto foi dividido em **módulos principais**, utilizando os princípios da **programação orientada a objetos (POO)**:

### ♻️ Módulo Lixo Molhado

- Calcula a quantidade de metano gerado a partir da massa de lixo.
- Converte a massa em energia utilizando dados reais de entalpia.
- Simula o uso dessa energia em turbinas, estimando a potência gerada.
- Salva relatórios automáticos em HTML e arquivos serializados.

### 🔥 Módulo Lixo Seco

- Recebe massas de madeira, tecidos e papéis.
- Calcula a energia aparente, útil e perdida com base em eficiência fornecida pelo usuário.
- Exibe relatórios no terminal com dados convertidos para Joules, Wh e kWh.

### 🔗 Integração Geral

- Os módulos foram integrados em um projeto coeso.
- Foi criado um ponto de entrada com interface terminal para que o usuário simule ambos os sistemas.

---

## 👥 3. Tabela de Participantes

| 👤 Participante     | 🛠️ Responsabilidades                   |
|---------------------|----------------------------------------|
| Pablo Henrique       | Lixo Seco; Integração de códigos        |
| João Moynier         | Lixo Molhado; Banco de dados            |
| Ítalo e Arthur       | Interface e apresentação visual         |

---

## 🧰 4. Tecnologias e Ferramentas Utilizadas

| 🧪 Plataforma/Ferramenta | 💼 Uso no Projeto                          |
|--------------------------|-------------------------------------------|
| Java                     | Linguagem principal                       |
| BlueJ                    | Ambiente de desenvolvimento               |
| GitHub                   | Versionamento de código                   |
| SQL (conceitual)         | Planejamento de banco de dados futuro     |
| Mermaid.js               | Diagramas de classes                      |
| HTML                     | Geração automática de relatórios visuais  |

---

## 📘 5. Conceitos Acadêmicos Envolvidos

- 📐 Conversão de unidades de energia (J, Wh, kWh)
- 🔥 Eficiência térmica e perdas por calor
- ⚖️ Massa molar, densidade, entalpia
- 💾 Serialização de objetos e arquivos
- 🌐 Geração dinâmica de arquivos HTML
- 🧩 Diagramas UML (com Mermaid.js)

---

## 🖥️ 6. Execução do Projeto

1. ✅ Compile o projeto completo em sua IDE Java (recomendado: BlueJ).
2. ▶️ Execute a classe `Main` no pacote `app`.
3. 🧮 Forneça os valores solicitados:
   - Massa de lixo molhado (toneladas)
   - Massa de materiais secos (kg)
   - Eficiência da queima (valor entre 0 e 1)
   - Área da turbina (m²)
4. 📊 Os resultados serão exibidos no terminal e salvos automaticamente.

---

## 🧾 7. Códigos-Fonte e Diagrama de Classes (Mermaid)

Abaixo está o diagrama de classes que representa a estrutura dos pacotes e relações entre as classes principais. O GitHub irá renderizá-lo automaticamente:

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
``````

## 📌 8. Considerações Finais
Este projeto buscou aliar conceitos de física, sustentabilidade e programação orientada a objetos, fornecendo uma simulação educacional do potencial de reaproveitamento de lixo para geração de energia.

A estrutura modular e bem documentada permite expansões futuras com interface gráfica, banco de dados real e até aplicações web.

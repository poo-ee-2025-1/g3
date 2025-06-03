# Diagrama de Sequencia
<p>
  http://www.plantuml.com/plantuml/png/hPD1ReCm44NtdC9B8fKBT16b4hr0UeA9xTAHZ0UDnrMlKtNHWt2n6YeCH7MKHRVscyUV3vo204liNGLQYDMpxwn_iyXK3Ua2DGxWHRrW4Dl3xkniktHw1JuD3ZLeeAfQLQevBWRrg1nrwEiOulZ9I0yg90eErG8q2Lv74w_9loBtC7wFNwIC_HMK_O5I11JW5WJgZVYO8oVg4eC6Fbi7GemKQWEIKcIYsMV6830zc_D0ER3zm0lo5YrdjSvg9Bz9KX_kDvV5cd7hD60ebAheBF_1Ba22yrlDT3inAUbwqLmv8x1PkDbOx3PlCwiDbTTVIJ0ursPkL01EzejvUgVGtce298B3K1Ywfv8L_vzovjly2vZYPxUWUOK9FLblOkz-0000
  Diagrama feito por Italo Pires

  ## Sintaxe desse Diagrama
  
  @startuml actor Engenheiro participant Sistema participant Registro participant Aplicacao

Engenheiro -> Sistema : login(usuário, senha) Sistema --> Engenheiro : confirmação de login

Engenheiro -> Sistema : solicitarData() Sistema -> Registro : buscarRelatorios(data) Registro --> Sistema : lista de relatorios Sistema --> Engenheiro : exibir relatorios

Engenheiro -> Sistema : selecionarRelatorio() Sistema --> Engenheiro : exibir relatorio

Engenheiro -> Sistema : criarRelatorio(dados) Sistema -> Registro : gerarRelatorio(dados) Registro -> Aplicacao : gerarDados() Aplicacao --> Registro : guardarDados(dados) Registro --> Sistema : relatorio gerado Sistema --> Engenheiro : relatorio adicionado

Engenheiro -> Sistema : alterarRelatorio(novosDados) Sistema -> Registro : atualisarRelatorio(novosDados) Registro -> Aplicacao : gerarDados(novosDados) Aplicacao --> Registro : guardarDados(dados) Registro --> Sistema : dados confirmados Sistema --> Engenheiro : dados atualisados @enduml
</p>


<p>///////////////////////////////////////////////////////////////////////////#\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\</p>


# Lixo=energia


## O objetivo do projeto é criar uma plataforma, site/aplicativo, de monitoramento de um ambiente controlado para geração de energia apartir de lixo


### Versão 0.1.8 - 02/06/2025

# 

### Italo Píres, Pablo Henrique, João Pedro Moynier & Arthur Jardim



# Preencha os dados para formulação do relátorio

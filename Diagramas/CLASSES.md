````mermaid

classDiagram
    class Dados {
        - id: int
        - lote: String
        - tipo: TipoLixo
        - toneladas_lixo_organico: double
        - toneladas_lixo_madeira: double
        - toneladas_lixo_papel: double
        - toneladas_lixo_tecido: double
        - energia_gerador: double
        - energia_lixo: double
        - energia_perdida: double
        - area_vazao: double
        - volume_agua: double
        - comentario: String
        - dia_relatorio: Date
        + getId()
        + getLote()
        + getTipo()
        + getToneladas()
        + getToneladasMadeira()
        + getToneladasPapel()
        + getToneladasTecido()
        + getEnergiaGerada()
        + getEnergiaLixo()
        + getEnergiaPerdida()
        + getArea()
        + getVolume()
        + getComentario()
        + getData()
        + setId(int)
        + setLote(String)
        + setTipo(TipoLixo)
        + setToneladas(double)
        + setToneladasMadeira(double)
        + setToneladasPapel(double)
        + setToneladasTecido(double)
        + setEnergiaGerada(double)
        + setEnergiaLixo(double)
        + setEnergiaPerdida(double)
        + setArea(double)
        + setVolume(double)
        + setComentario(String)
        + setData(Date)
    }

    class DadosRepository {
        - database: Database
        - dao: Dao<Dados, int>
        - lista_dados_carregados: List<Dados>
        - dado_carregado: Dados
        + create(Dados)
        + update(Dados)
        + delete(Dados)
        + loadFromId(int): Dados
        + loadAll(): List<Dados>
    }

    class Database {
        - databaseName: String
        - connection: JdbcConnectionSource
        + getConnection(): JdbcConnectionSource
        + close()
    }

    class LixoSeco {
        - mMadeira: double
        - mTecidos: double
        - mPapeis: double
        - jMadeira: double
        - jTecidos: double
        - jPapeis: double
        - energia_total: double
        - energia_produzida_gerador: double
        - vazao_energica_total: double
        + ProcessoMadeira(double)
        + ProcessoPapel(double)
        + ProcessoTecidos(double)
        + Processo(String, double, double)
    }

    class LixoOrganico {
        - toneladas_lixo: double
        - metano_produzido: double
        - energia_lixo: double
        - vazao_metano: double
        - vazao_energica: double
        - tempo_aquecimento: double
        - tempo_vaporizacao: double
        - energia_perdida: double
        - energia_usavel: double
        - energia_produzida_gerador: double
        + Processo(String, double, double, double)
    }

    class Conversoes {
        + kg_para_ton(double): double
        + massa_met(double): double
        + mol_met(double): double
        + energia_met(double): double
    }

    class Turbina {
        + vazao_massica(double, double, double): double
        + vazao_energica(double, double, double): double
        + variacao_temperatura(double): double
        + tempo_aquecimento(double): double
        + tempo_vaporizacao(double): double
        + energia_perda(double, double): double
        + velocidade_vapor(): double
        + potencia_turbina(double): double
        - volume: double
        - CALOR_ESPECIFICO_AGUA: double
        - DENSIDADE: double
        - massa_agua: double
        - temperatura_inicial: double
        - COEFICIENTE_LATENCIA_VAPOR_AGUA: double
        - PRESSAO_AGUA: double
        - DENSIDADE_VAPOR: double
    }

    class EficienciaBiometano {
        + densidade_bio(): double
        + massa_met(): double
        + velocidade_queima(): double
        - EFICIENCIA: double
        - MET_ENTALPIA: double
        - MET_MASS_MOLAR: double
        - MET_DENSIDADE: double
        - VOLUME: double
        - VEL_QUEIMA: double
    }

    class TipoLixo {
    + SECO
    + ORGANICO
    }


    Dados --> TipoLixo
    DadosRepository --> Database
    DadosRepository --> Dados
    LixoSeco ..> Turbina
    LixoSeco ..> EficienciaBiometano
    LixoOrganico ..> Turbina
    LixoOrganico ..> EficienciaBiometano
    Conversoes ..> EficienciaBiometano

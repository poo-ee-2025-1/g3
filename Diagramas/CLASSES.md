````mermaid
classDiagram
    class Dados {
        +int id
        +String lote
        +TipoLixo tipo
        +double toneladas_lixo_organico
        +double toneladas_lixo_madeira
        +double toneladas_lixo_papel
        +double toneladas_lixo_tecido
        +double energia_gerador
        +double energia_lixo
        +double energia_perdida
        +double area_vazao
        +double volume_agua
        +String comentario
        +Date dia_relatorio
        +getId()
        +getLote()
        +getTipo()
        +getToneladas()
        +getToneladasMadeira()
        +getToneladasPapel()
        +getToneladasTecido()
        +getEnergiaGerada()
        +getEnergiaLixo()
        +getEnergiaPerdida()
        +getArea()
        +getVolume()
        +getComentario()
        +getData()
        +setLote(String)
        +setTipo(TipoLixo)
        +setToneladas(double)
        +setToneladasMadeira(double)
        +setToneladasPapel(double)
        +setToneladasTecido(double)
        +setEnergiaGerada(double)
        +setEnergiaLixo(double)
        +setEnergiaPerdida(double)
        +setArea(double)
        +setVolume(double)
        +setComentario(String)
        +setData(Date)
    }
    
    class DadosRepository {
        -Database database
        -Dao dao
        -List~Dados~ lista_dados_carregados
        -Dados dado_carregado
        +create(Dados) Dados
        +update(Dados)
        +delete(Dados)
        +loadFromId(int) Dados
        +loadAll() List~Dados~
    }
    
    class Database {
        -String databaseName
        -JdbcConnectionSource connection
        +getConnection() JdbcConnectionSource
        +close()
    }
    
    class LixoSeco {
        -double mMadeira
        -double mTecidos
        -double mPapeis
        -double jMadeira
        -double jTecidos
        -double jPapeis
        +energia_total
        +energia_produzida_gerador
        +vazao_energica_total
        +ProcessoMadeira(double)
        +ProcessoPapel(double)
        +ProcessoTecidos(double)
        +Processo(String, double, double)
    }
    
    class LixoOrganico {
        +double toneladas_lixo
        +double metano_produzido
        +double energia_lixo
        +double vazao_metano
        +double vazao_energica
        +double tempo_aquecimento
        +double tempo_vaporizacao
        +double energia_perdida
        +double energia_usavel
        +double energia_produzida_gerador
        +Processo(String, double, double, double)
    }
    
    class Turbina {
        +static vazao_massica(double, double, double)
        +static vazao_energica(double, double, double)
        +static variacao_temperatura(double)
        +static tempo_aquecimento(double)
        +static tempo_vaporizacao(double)
        +static energia_perda(double, double)
        +static velocidade_vapor()
        +static potencia_turbina(double)
    }
    
    class EficienciaBiometano {
        +static EFICIENCIA
        +static MET_ENTALPIA
        +static MET_MASS_MOLAR
        +static MET_DENSIDADE
        +static VOLUME
        +static VEL_QUEIMA
        +static densidade_bio()
        +static massa_met()
        +static velocidade_queima()
    }
    
    class Conversoes {
        +static kg_para_ton(double)
        +static massa_met(double)
        +static mol_met(double)
        +static energia_met(double)
    }
    
    class CriadorHTML {
        +static CriarHTML(Dados)
        +static AbrirHTML()
    }
    
    DadosRepository --> Database
    DadosRepository --> Dados
    CriadorHTML --> Dados
    LixoSeco --> Turbina
    LixoOrganico --> Conversoes
    LixoOrganico --> Turbina
    LixoOrganico --> EficienciaBiometano
    LixoSeco --> Conversoes
    LixoSeco --> EficienciaBiometano
    Turbina --> EficienciaBiometano
}

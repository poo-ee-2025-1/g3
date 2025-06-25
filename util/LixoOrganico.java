package util;
import java.sql.Date;
import java.time.LocalDate;

import banco_de_dados.*;

public class LixoOrganico {
    public void Processo(String local, double lixo_gerado, double area_de_vazao, double volume_de_agua)
    {
        double toneladas_lixo = lixo_gerado; //1
        //toneladas de lixo produzido
        
        double metano_produzido = Conversoes.massa_met(toneladas_lixo);
        //metano produzido nesse lixo
        
        double energia_lixo = Conversoes.energia_met(toneladas_lixo);
        //energia do metano desse lixo
        
        double area_vazao = area_de_vazao; //0.6; //cm^2
        //area de vazao da queima. Onde o calor sai (como se fosse a boca de um fogao).
        
        double vazao_metano = Turbina.vazao_massica(EficienciaBiometano.velocidade_queima(), area_vazao, EficienciaBiometano.MET_DENSIDADE / 1000000); //cm/s, cm^2, kg/cm^3 * 10^4
    
        double vazao_energica = Turbina.vazao_energica(EficienciaBiometano.MET_MASS_MOLAR,vazao_metano, EficienciaBiometano.MET_ENTALPIA);
        
        double variacao_temperatura = Turbina.variacao_temperatura(vazao_energica);
        
        double tempo_aquecimento = Turbina.tempo_aquecimento(variacao_temperatura);
        
        double tempo_vaporizacao = Turbina.tempo_vaporizacao(vazao_energica);
        
        double energia_perdida = Turbina.energia_perda(vazao_energica, tempo_aquecimento + tempo_vaporizacao);
        
        double energia_usavel = Math.abs(energia_lixo) - Math.abs(energia_perdida);
        
        double energia_produzida_gerador = Turbina.potencia_turbina(energia_usavel);
        
        double volume_agua = volume_de_agua;//0.001;
        //Quanto de agua tem na caldeira. Essa agua vai ser aquecida e virar vapor, e nesse processo, a energia total do sistema vai ser perdida
        
        Turbina.volume = volume_agua;
        
        double velocidade_vapor = Turbina.velocidade_vapor();
        
        System.out.println("Toneladas de lixo "+ toneladas_lixo);
        System.out.println("Metano produzido "+ metano_produzido);
        System.out.println("Energia total do lixo " +energia_lixo);
        System.out.println("Area vazao met "+ area_vazao);
        System.out.println("Vazao met "+ vazao_metano);
        System.out.println("Vazao_energica " + vazao_energica);
        System.out.println("Variacao temperatura " + variacao_temperatura);
        System.out.println("Tempo aquecimento " + tempo_aquecimento);
        System.out.println("Tempo vaporizacao " + tempo_vaporizacao);
        System.out.println("Energia perdida " + energia_perdida);
        System.out.println("Volume de agua " + Turbina.volume);
        System.out.println("Massa de agua " + Turbina.massa_agua);
        System.out.println("Velocidade vapor " + velocidade_vapor);
        //System.out.println("potencia " + Caldeira.potencia_turbina(1, velocidade_vapor));
        System.out.println("Energia Gerada pela terméletrica: "+ energia_produzida_gerador);
        if (energia_produzida_gerador >= Math.abs(energia_lixo))
        {
            System.out.println("ERRO! A energia produzida na turbina é maior do que a energia do metano.");
        }
        
        
        
        //CRIAR UM DADO CONTENDO AS INFORMAÇÕES:
        Dados dado = new Dados();
        dado.set_area(area_vazao);
        dado.set_energia_gerada(energia_produzida_gerador);
        dado.set_energia_metano(energia_lixo);
        dado.set_lixo(toneladas_lixo);
        dado.set_metano(metano_produzido);
        dado.set_local(local);
        dado.set_dia(Date.valueOf(LocalDate.now()));
    }
}

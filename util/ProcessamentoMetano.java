package util;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;

import util.*;
public class ProcessamentoMetano implements Serializable
{
    public static void Processo()
    {
        //EnergiaLixao energia_lixo = new EnergiaLixao();
        Conversoes cl = new Conversoes();
        
        Turbina turbina = new Turbina();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quantas toneladas de lixo vao para o aterro/lixao: ");
        double toneladas_lixo = sc.nextDouble();
        
        double energia_lixo = cl.energia_met(toneladas_lixo);
        double metano_produzido = cl.massa_met(toneladas_lixo);
        
        
        System.out.println("Qual a area da tubrina em m^2: ");
        double area = sc.nextDouble();
        turbina.set_area_turbina(area);
        
        sc.close();
        
        //Processamento
        turbina.energia_paraVelocidade(energia_lixo);//energia_lixo.energia_gerada(toneladas_lixo));
        System.out.println("Lixo: " + toneladas_lixo + " Toneladas");
        System.out.println("Metano produzido: " + metano_produzido + " Toneladas");
        System.out.println("Energia do Metano: " + Math.abs((energia_lixo / Math.pow(10, 6)))+ " MW");
        System.out.println("Energia do Gerador: " + (turbina.potencia_maxima(energia_lixo) / Math.pow(10, 6))+ " MW\n");
        
        if (Math.abs(energia_lixo) < turbina.potencia_maxima(energia_lixo))
        {
            System.out.println("Erro. Energia do lixo nao pode ser menor que a energia maxima da turbina.");
        }
        
        Dados dados = new Dados("Goias", toneladas_lixo, metano_produzido, energia_lixo, area);
        Dados.SalvarDados(dados);
        CriadorHTML.CriarHTML(dados);
    }
}
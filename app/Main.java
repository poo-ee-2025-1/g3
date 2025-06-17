package app;

import modelo.LixoSeco;
import servicos.ConEnSec;
import servicos.ReEnSec;
import util.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada - Lixo Molhado
        System.out.println("===== Entrada de Dados: Lixo Molhado =====");
        System.out.print("Quantas toneladas de lixo vao para o aterro/lixao: ");
        double toneladas_lixo = sc.nextDouble();

        Conversoes conversoes = new Conversoes();
        double energia_lixo_molhado = conversoes.energia_met(toneladas_lixo);
        double metano_produzido = conversoes.massa_met(toneladas_lixo);

        System.out.print("Qual a area da turbina em m^2: ");
        double area_turbina = sc.nextDouble();

        Turbina turbina = new Turbina();
        turbina.set_area_turbina(area_turbina);
        turbina.energia_paraVelocidade(energia_lixo_molhado);

        // Entrada - Lixo Seco
        System.out.println("\n===== Entrada de Dados: Lixo Seco =====");
        sc.nextLine(); // limpa o buffer

        double madeira = obterEntradaValida(sc, "Massa de Madeira (kg): ");
        double tecidos = obterEntradaValida(sc, "Massa de Tecidos (kg): ");
        double papeis = obterEntradaValida(sc, "Massa de Papeis (kg): ");
        double eficiencia = obterEntradaValida(sc, "Eficiência da queima (0 a 1): ");

        LixoSeco lixoSeco = new LixoSeco(madeira, tecidos, papeis, eficiencia);
        lixoSeco.calcularEnergias();
        ConEnSec ces = new ConEnSec();
        ReEnSec res = new ReEnSec(lixoSeco, ces);

        // Relatórios
        System.out.println("\n===== Relatório Lixo Molhado =====");
        System.out.printf("Lixo: %.2f Toneladas\n", toneladas_lixo);
        System.out.printf("Metano produzido: %.4f Toneladas\n", metano_produzido);
        System.out.printf("Energia do Metano: %.4f MW\n", energia_lixo_molhado / Math.pow(10, 6));
        System.out.printf("Energia do Gerador: %.4f MW\n", turbina.potencia_maxima(energia_lixo_molhado) / Math.pow(10, 6));

        System.out.println("\n===== Relatório Lixo Seco =====");
        res.relatorio();

        // Armazenar dados
        Dados dados = new Dados("Goias", toneladas_lixo, metano_produzido, energia_lixo_molhado, area_turbina);
        Dados.SalvarDados(dados);
        CriadorHTML.CriarHTML(dados);

        sc.close();
    }

    private static double obterEntradaValida(Scanner sc, String mensagem) {
        double valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print(mensagem);
                String input = sc.nextLine().replace(',', '.');
                valor = Double.parseDouble(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
        return valor;
    }
}

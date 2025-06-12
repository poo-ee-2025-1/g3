package app;

import util.*;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escreva 1 para criar dados; 2 para ler dados");
        int teste = sc.nextInt();
        
        
        switch(teste)
        {
            case 1:
                ProcessamentoMetano.Processo();
            break;
            case 2:
                String dir = System.getProperty("user.dir") + File.separator + "dados";
                File arquivo = new File(dir + File.separator + "2025-05-31T15:42:01.973720180.DAT");
                Dados dado = Dados.LerDados(arquivo);
                System.out.println(dado.local);
            break;
        }
    }
}

package util; 

import java.io.*;
import java.time.LocalDateTime;

public class Dados implements Serializable
{
    public String local;
    public double toneladas_lixo;
    public double metano_produzido;
    public double energia_lixo;
    public double area_turbina;
    
    /*
     * Metodo Construtor para Dados
     */
    public Dados(String local, double toneladas_lixo, double metano_prod, double energia_lixo, double area_turbina)
    {
        this.local = local;
        this.toneladas_lixo = toneladas_lixo;
        this.metano_produzido = metano_prod;
        this.energia_lixo = energia_lixo;
        this.area_turbina = area_turbina;
    }
    
    public static void SalvarDados(Dados dado)
    {
        try
        {
            LocalDateTime data = LocalDateTime.now();
            
            FileOutputStream fis = new FileOutputStream(data + ".DAT");
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(dado);
            
            ois.close();
            fis.close();
        }
        
        catch(Exception E)
        {
            
        }
    }
    
    /*
     * Metodo de Leitura
     */
    public static Dados LerDados(File arquivo)
    {
        try
        {
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dados dado_in = (Dados)ois.readObject();
            
            ois.close();
            fis.close();
            return (Dados)ois.readObject();
        }
        
        catch(Exception E)
        {
            return null;   
        }
    }
}

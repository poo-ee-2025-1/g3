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
            
            String dir = System.getProperty("user.dir") + File.separator + "dados";
            //Cria uma string mostrando o caminho da pasta a ser criada
            File pasta = new File(dir);
            //Cria um arquvio com o caminho da pasta
            
            boolean dirCreated = pasta.mkdir();
            //mkdir cria a pasta
            if (dirCreated)
            {
                System.out.println("Pasta \"dados\" criada com sucesso em: " + System.getProperty("user.dir") + File.separator + "dados");
            }
            else
            {
                System.out.println("Erro ao criar a pasta \"dados\". Talvez ela ja tenha sido criada.");
            }
            
            FileOutputStream fis = new FileOutputStream(dir + File.separator + data + ".DAT");
            //Cria uma saida de arquivo .dat no caminho do diretorio dir
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            //Cria uma saida de objeto para a saida de arquivo
            ois.writeObject(dado);
            //Escreve os dados de objeto no arquivo.
            
            ois.close();
            fis.close();
            //Fecho as duas saidas
            
            System.out.println("Dados salvo em: " + dir + File.separator + data + ".DAT");
        }
        
        catch(Exception E)
        {
            String dir = System.getProperty("user.dir") + File.separator + "dados";
            System.out.println("Erro ao salvar em: " + dir + File.separator);
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
            //Cria uma entrada de arquivos
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Cria uma entrada de objetos para a entrada de arquivos
            Dados dado_in = (Dados)ois.readObject();
            //Le um objeto e converte para a classe "Dados"
            
            ois.close();
            fis.close();
            //Fecho as entradas
            return dado_in;
            //Retorno os dados
        }
        
        catch(Exception E)
        {
            String dir = System.getProperty("user.dir") + File.separator + "dados";
            System.out.println("Erro ao ler arquivos em: " + dir + File.separator);
            return null;
        }
    }
}

package util;

import java.io.*;
import java.time.LocalDateTime;
//import util.Dados;

public class CriadorHTML
{
    public static void CriarHTML(Dados dado)
    {
            //String para HTML
        //StringBuilder htmlBuilder = new StringBuilder();
        //htmlBuilder.append("<html>");
        //htmlBuilder.append("<head> <title>Hello World</title> </head>");
        //htmlBuilder.append("<body> <h1>Nicola And Bart <p>Here is to you</p> </body>");
        //htmlBuilder.append("</html>");
        //String html = htmlBuilder.toString();
        
        
        String HTML =
        """
            <html>
                <body>
                    <h1>
                        Relatorio de Lixo
                    </h1>
                    <p>
                        O local foi: %s <br>
                        A Geraçao de lixo foi: %s <br>
                        O metano produzido foi: %s <br>
                        Energia do metano do lixo: %s <br>
                        Area da turbina do gerador: %s <br>
                    </p>
                </body>
            </html>
        """;
        
        HTML = String.format(HTML,dado.local, dado.toneladas_lixo, dado.metano_produzido, dado.energia_lixo, dado.area_turbina);
        //Criaçao de arquivo
        try
        {
            LocalDateTime data = LocalDateTime.now();
            
            String dir = System.getProperty("user.dir") + File.separator + "html";
            //Cria uma string mostrando o caminho da pasta a ser criada
            
            File pasta = new File(dir);
            //Cria um arquivo que vai ser o caminho da pasta
            
            boolean dirCreated = pasta.mkdir();
            //mkdir cria a pasta
            if (dirCreated)
            {
                System.out.println("Pasta \"html\" criada com sucesso em: " + System.getProperty("user.dir") + File.separator + "html");
            }
            else
            {
                System.out.println("Erro ao criar a pasta \"html\". Talvez ela ja tenha sido criada.");
            }
            
            
            File arquivo = new File(dir + File.separator + data + ".html");
            //Crio um arquivo com o caminho da pasta onde vai ser criado e com a extensao .html
            
            if(arquivo.createNewFile())
            {
                System.out.println("Arquivo Criado: " + arquivo.getAbsolutePath());
            }
            else
            {
                System.out.println("Erro ao criar o arquivo de html.");
            }
            FileWriter fwriter = new FileWriter(arquivo);
            fwriter.write(HTML);
            //Uso fwriter para escrever a string HTML, no arquivo
            fwriter.close();
            //Fecho fwriter
        }
        catch(Exception e)
        {
            System.out.println("Erro ao escrever o arquivo de html.");
        }
    }
}
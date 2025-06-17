package util;

import java.io.*;
import java.time.LocalDateTime;
import util.Dados;

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
            File arquivo = new File(data + ".html");
            if(arquivo.createNewFile())
            {
                System.out.println("Arquivo Criado: " + arquivo.getName());
            }
            
            FileWriter fwriter = new FileWriter(arquivo);
            fwriter.write(HTML);
            fwriter.close();
        }
        catch(Exception e)
        {
        
        }
    }
}
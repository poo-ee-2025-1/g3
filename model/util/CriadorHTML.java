package model.util;

import java.io.*;
import java.time.LocalDateTime;

import model.database.Dados;

public class CriadorHTML
{
    public static void CriarHTML(Dados dado)
    {
    	String HTML = "";
        /*
         * CRIAR DIFERENTES RELATORIOS PARA DIFERENTES TIPOS DE LIXO
         */
        
    	switch(dado.get_tipo())
    	{
    	
    	/*
    	 * DO LIXO ORGANICO
    	 */
    	case Dados.TipoLixo.ORGANICO:
   			HTML =
  					"""
   					    <html>
   					        <body>
   					            <h1>
   					                Relatorio de Lixo Orgânico:
   					            </h1>
   					            <p>
   					                O local foi: %s <br>
   					                O Rejeito Orgânico enviado para o local foi: %s toneladas. <br>
   					                <br>
   					                A Energia total do rejeito foi: %s kJ<br>
   					                A Água para ser aquecida dentro da caldeira é: %s m^3 <br>
   					                A Área de vazão do calor da caldeira foi: %s cm^2 <br>
   					                A Energia que pode ser produzida pelo gerador é: %s kJ<br>
   					               	<br>
   					                Relatório gerado no dia: %s
   					                <br>
   					                Comentário: %s
   					            </p>
   					        </body>
   					    </html>
   					""";
   			
   			HTML = String.format(HTML,dado.get_local(), dado.get_toneladas_organico(), dado.get_energia_lixo(), dado.get_volume(), dado.get_area(), dado.get_energia_gerada(), dado.get_dia(), dado.get_comentario());
        
    		break;
        
    	/*
    	 * DO LIXO SECO	
    	 */
    	case Dados.TipoLixo.SECO:
    		HTML =
				"""
				    <html>
				        <body>
				            <h1>
				                Relatorio de Lixo Seco:
				            </h1>
				            <p>
				                O local foi: %s <br>
				                A quantidade de madeira presente no lixo enviado para o local foi: %s toneladas. <br>
				                A quantidade de tecidos presente no lixo enviado para o local foi: %s toneladas. <br>
				                A quantidade de papeis presente no lixo enviado para o local foi: %s toneladas. <br>
				                <br>
				                A Energia total do lixo foi: %s kJ<br>
				                A Água para ser aquecida dentro da caldeira é: %s m^3 <br>
				                A Área de vazão do calor da caldeira foi: %s cm^2 <br>
				                A Energia que pode ser produzida pelo gerador é: %s kJ<br>
    							<br>
				                Relatório gerado no dia: %s
				                <br>
				                Comentário: %s
				            </p>
				        </body>
				    </html>
				""";
		
		HTML = String.format(HTML,dado.get_local(), dado.get_toneladas_madeira(), dado.get_toneladas_tecido(),dado.get_toneladas_papel(), dado.get_energia_lixo(), dado.get_volume(), dado.get_area(), dado.get_energia_gerada(), dado.get_dia(), dado.get_comentario());
    		break;
    	}
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
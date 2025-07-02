package model.app;

import model.database.Dados;
import model.database.DadosRepository;
import model.database.Database;
import model.util.CriadorHTML;
import model.util.LixoOrganico;
import model.util.LixoSeco;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;
import java.time.ZoneId;
import java.io.File;

public class Main {
	/*
	 * Essa classe vai testar: 
	 * Criar um objeto dados usando a classe Dados;	X
	 * Diferenciar o tipo de lixo que entra na terméletrica;	X
	 * Calcular a energia de lixo seco usando a classe LixoSeco;	X
	 * Calcular a energia de lixo organico usando a classe LixoOrganico;	X
	 * Criar um relátorio em HTML usando a classe CriadorHTML;	X
	 * 
	 * Criar um banco de dados	X
	 * 
	 */
	
	
	
	public static void main(String[] args)
	//public void test()
	{
		Dados dado = new Dados();
		
		/*
		 * ONDE ESTAMOS FAZENDO A ANALISE
		 */
		
		dado.set_local("GOIANIA");
		
		/*
		 * QUAL A AREA DE VAZAO DE CALOR DA CALDEIRA, EM CM^2
		 */
		
		dado.set_area(1);
		
		/*
		 * QUAL O VOLUME DE AGUA DENTRO DA CALDEIRA, EM M^2
		 */
		
		dado.set_volume(1);
		
		/*
		 * QUAL TIPO DE LIXO VAMOS FAZER A ANALISE
		 */
		
		dado.set_tipo(Dados.TipoLixo.ORGANICO);
		
		
		switch(dado.get_tipo())
		{
		
			/*
		 	* SE O LIXO FOR ORGANICO, QUANTAS TONELADAS DE LIXO ORGANICO ESTAMOS FAZENDO ANALISE
		 	*/
		
			case Dados.TipoLixo.ORGANICO:
			
				LixoOrganico org = new LixoOrganico();
		
				dado.set_toneladas_organico(2);
		
				/*
				 * QUAL A ENERGIA TOTAL DESSE TIPO DE LIXO
				 */
		
				org.Processo(dado.get_local(), dado.get_toneladas_organico(), dado.get_area(), dado.get_volume());
		
				dado.set_energia_lixo(org.energia_lixo);
		
				/*
				 * QUAL A ENERGIA GERADA NA TERMELETRICA DESSE LIXO
				 */
		
				dado.set_energia_gerada(org.energia_produzida_gerador);
			
			
			
				break;
		
		
			/*
			 * SE O LIXO FOR SECO, QUANTAS TONELADAS DE MADEIRA, TECIDO E PAPEL ESTAMOS FAZENDO ANALISE
			 */
			case Dados.TipoLixo.SECO:
				
				dado.set_toneladas_madeira(0);
				
				dado.set_toneladas_tecido(0);
				
				dado.set_toneladas_papel(0);
				
				LixoSeco sec = new LixoSeco(dado.get_toneladas_madeira(), dado.get_toneladas_tecido(), dado.get_toneladas_papel());
				
				
				
				/*
				 * QUAL A ENERGIA TOTAL DESSE TIPO DE LIXO
				 */
				
				sec.Processo(dado.get_local(), dado.get_area(), dado.get_volume());
				
				dado.set_energia_lixo(sec.energia_total);
				
				/*
				 * QUAL A ENERGIA GERADA NA TERMELETRICA DESSE LIXO
				 */
				dado.set_energia_gerada(sec.energia_produzida_gerador);
		}
		
		/*
		 * QUAL A ENERGIA PERDIDA DURANTE A GERAÇÃO DE ENERGIA DO LIXO
		 */
		
		dado.set_energia_perdida(Math.abs(dado.get_energia_lixo()) - dado.get_energia_gerada());
		
		/*
		 * QUAL O COMENTARIO SOBRE ESSE LIXO
		 */
		
		dado.set_comentario("A Analise da produção de energia do lixo foi feita com sucesso");
		
		/*
		 * QUAL O DIA DA PRODUÇÃO DO RELATORIO
		 */
		
		LocalDate localDate = LocalDate.now();
	
		java.util.Date dia_util = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		//Como nos vamos trabalhar com um banco de dados, converto dia_util para o tipo java.sql.Date
		java.sql.Date dia_sql = new java.sql.Date(dia_util.getTime());
		
		dado.set_dia(dia_sql);
		
		
		/*
		 * GERAR RELATORIO A PARTIR DOS DADOS
		 */
		CriadorHTML.CriarHTML(dado);
		
		/*
		 * CRIAR UM BANCO DE DADOS
		 */
		
		Database database1 = new Database("DADOS_DB");
		
		/*
		 * CRIAR UM REPOSITORIO
		 */
		
		DadosRepository repositorio = new DadosRepository(database1);
		
		/*
		 * SALVAR O DADO NO BANCO
		 */
		
		repositorio.create(dado);
		
		/*
		 * LOCALIZAR O DADO NO REPOSITORIO
		 */
		
		repositorio.loadFromId(1);
		//Ele usa o id para achar o objeto
		
		/*
		 * ATUALIZAR O DADO NO REPOSITORIO
		 */
		
		dado.set_local("BRASÍLIA");
		//Modifico o dado
		
		repositorio.update(dado);
		//Atualizo o repositorio
		
		/*
		 * DELETAR O DADO NO REPOSITORIO
		 */
		
		repositorio.delete(1);
	}
}

package banco_de_dados;

import com.j256.ormlite.dao.*;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class DadosRepository {
	private static Database database;
	private static Dao<Dados, Integer> dao;
	private List<Dados> lista_dados_carregados;
	private Dados dado_carregado;
	
	public DadosRepository(Database database)
	{
		DadosRepository.setDatabase(database);
		lista_dados_carregados = new ArrayList<Dados>();
	}
	
	public static void setDatabase(Database database) {
        DadosRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Dados.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Dados.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
	
	public Dados create(Dados dados) {
        int nrows = 0;
        try {
            nrows = dao.create(dados);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.dado_carregado = dados;
            lista_dados_carregados.add(dados);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return dados;
    }    
	
	//Este metodo de "atualizar" na verdade substitui um dado antigo por um novo.
	public void update(Dados dado, int id) {
		//Pego um dado do banco usando o id dele
		try 
		{
			this.dado_carregado = dao.queryForId(id);
			//carrego o dado que quero mudar
			
			if (this.dado_carregado != null)
			//Se o dado carregado nao for nulo...
			{
				this.dado_carregado = dado;
				//troco o dado carregado por outro dado.
			}
			//Caso tenha algum erro, joga um SQLException
		}	catch (SQLException e)
		{
			System.out.println(e);
		}

	    }

	    public void delete(int id) {
	    	try {
	    		//this.lista_dados_carregados = dao.queryForAll();
	    		////Atualizo a lista dos dados carregados para mostrar antes dela ser deletada
	    		//System.out.println("Lista Original: " + Arrays.toString(this.lista_dados_carregados.toArray()));
	    		////Printo a lista antes da deleção
	    		
	    		//Nao precisa carregar a lista. Deixa isso pro metodo "loadAll"
	    		
	    		System.out.println(dao.queryForId(id));
	    		//Printo o objeto que vais ser deletado
	    		dao.deleteById(id);
	    		//Deleto o objeto
	    		
	    		//this.lista_dados_carregados = dao.queryForAll();
	    		////Atualizo a lista dos dados_carregados para mostrar depois da deleção
	    		//System.out.println("Lista Atualizada: " + Arrays.toString(this.lista_dados_carregados.toArray()));
	    		////Printo a lista depois da deleção
	    		
	    		//Nao precisa carregar a lista. Deixa isso pro metodo "loadAll"
	    		
	    		
	    	} catch(SQLException e) 
	    	{
	    		System.out.println(e);
	    	}
	    }
	    
	    public Dados loadFromId(int id) {
	        try {
	            this.dado_carregado = dao.queryForId(id);
	            if (this.dado_carregado != null)
	                this.lista_dados_carregados.add(this.dado_carregado);
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return this.dado_carregado;
	    }    
	    
	    public List<Dados> loadAll() {
	        try {
	            this.lista_dados_carregados =  dao.queryForAll();
	            if (this.lista_dados_carregados.size() != 0)
	                this.dado_carregado = this.lista_dados_carregados.get(0);
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return this.lista_dados_carregados;
	    }
}

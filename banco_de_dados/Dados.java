package banco_de_dados;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

import java.util.Date;
import java.text.SimpleDateFormat;

@DatabaseTable(tableName = "Dados")
public class Dados {
	@DatabaseField(generatedId = true)
	private int id;
	//id para identificar o objeto no banco de dados (DB)
	
	@DatabaseField
	private String local;
	//Qual o estado/município em que estamos fazendo a analise
	
	@DatabaseField
	private double toneladas_lixo;
	//Toneladas de lixo indo para o aterro/Lixao
	
	private double metano_produzido;
	//Toneladas de lixo indo para o aterro/Lixao
	
	private double energia_gerador;
	//Energia gerada pelo gerador
	
	private double energia_metano;
	//Energia gerada pelo metano
	
	@DatabaseField
	private double area_vazao;
	//Area de vazao de queima. Como se fosse a boca de um fogão onde sai a chama
	
	@DatabaseField(dataType = DataType.DATE)
	private Date dia_relatorio;
	//Dia em que o relatorio foi feito
	
	
	
	//METODOS GETS
	public int get_id()
	{
		return this.id;
	}
	
	public String get_local()
	{
		return this.local;
	}
	
	public double get_lixo()
	{
		return this.toneladas_lixo;
	}
	
	public double get_metano()
	{
		return this.metano_produzido;
	}
	
	public double get_energia_gerada()
	{
		return this.energia_gerador;
	}
	
	public double get_energia_metano()
	{
		return this.energia_metano;
	}
	
	public double get_area()
	{
		return this.area_vazao;
	}
	
	public Date get_dia()
	{
		return this.dia_relatorio;
	}
	
	
	
	//METODOS SET
	public void set_id(int id)
	{
		this.id = id;
	}
	
	public void set_local(String local)
	{
		this.local = local;
	}
	
	public void set_lixo(double lixo)
	{
		this.toneladas_lixo = lixo;
	}
	
	public void set_metano(double metano)
	{
		this.metano_produzido = metano;
	}
	
	public void set_energia_gerada(double energia)
	{
		this.energia_gerador = energia;
	}
	
	public void set_energia_metano(double energia)
	{
		this.energia_metano = energia;
	}
	
	public void set_area(double area)
	{
		this.area_vazao = area;
	}
	
	public void set_dia(Date dia)
	{
		this.dia_relatorio = dia;
	}
}

package application;

import java.util.Date;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

//CLASSE PARA TESTAR A TABLEVIEW
public class Dados {
	
	public double tonelada;
	public String variavelNaoUsadaTeste = null;
	public int variavelNaoUsadaTeste2;
	public String lote;
	public String tipo;
	public Date data;
	
	public void set_local(String lote) {
		this.lote = lote;
	}
	public void set_toneladas_organico(double ton) {
		this.tonelada = ton;
	}
}

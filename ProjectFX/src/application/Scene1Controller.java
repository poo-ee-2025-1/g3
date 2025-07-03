package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.*;
import model.util.CriadorHTML;


public class Scene1Controller implements Initializable{
	
	@FXML
	TabPane tabPane;
	
	//nodes da primeira aba
	@FXML
	Label labelNomeUsuario;
	@FXML
	Label labelUsername;
	@FXML
	Label labelQualificacao;
	@FXML
	Button logoutButton;
	
	//nodes da segunda aba
	@FXML
	TextField textFieldLote;
	@FXML
	TextField textFieldLixoGerado;
	@FXML
	TextField textFieldVolumeDeAgua;
	@FXML 
	TextField textFieldAreaDeVazao;
	@FXML
	TextArea textAreaComentario;
	@FXML
	Button buttonGerar;
	@FXML
	Button buttonAtualizar;
	@FXML
	Button buttonDeletar;
	@FXML
	Button buttonVisualizar;
	
	//nodes da tableView
	@FXML
	TableView<Dados> dados;
	@FXML
	TableColumn<Dados, Integer> idColumn;
	@FXML
	TableColumn<Dados, Date> dia_relatorioColumn;
	@FXML
	TableColumn<Dados, String> loteColumn;
	@FXML
	TableColumn<Dados, String> tipoColumn;
	@FXML
	TableColumn<Dados, Double> toneladas_lixo_organicoColumn;
	
	//declaracao do stage
	Stage stage;
	
	//metodo de dados do usuario
	public void displayData(String nome, String username, String qualificacao) {
		labelNomeUsuario.setText("Bem Vindo, "+nome+".");
		labelUsername.setText("Username: "+username+".");
		labelQualificacao.setText("Qualificação: "+qualificacao+".");
	}
	
	//tratamento para quando o usuario fechar o programa 
    public void logout(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("Você está preste a SAIR!");
		alert.setContentText("Você quer salvar antes de FECHAR o programa?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) tabPane.getScene().getWindow();
			System.out.println("Você DESCONECTOU com SUCESSO!");
			stage.close();
		}
	}
    
    //inicializacao da tableView
    @Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		idColumn.setCellValueFactory(new PropertyValueFactory<Dados, Integer>("id"));
		dia_relatorioColumn.setCellValueFactory(new PropertyValueFactory<Dados, Date>("data"));
		loteColumn.setCellValueFactory(new PropertyValueFactory<Dados, String>("lote"));
		tipoColumn.setCellValueFactory(new PropertyValueFactory<Dados, String>("tipoLixo"));
		toneladas_lixo_organicoColumn.setCellValueFactory(new PropertyValueFactory<Dados, Double>("toneladas"));
	}
    
    // COLOQUE METODOS PARA DESABILITAR BOTOES E CAMPOS AQUI
    
    //metodo para criar relatórios
    public void gerar() {
    	
    	//os textos nos TextFields sao salvos dentro de variaveis
    	String lote = textFieldLote.getText();
    	double lixoGerado = Double.parseDouble(textFieldLixoGerado.getText());
    	double areaDeVazao = Double.parseDouble(textFieldAreaDeVazao.getText());
    	double volumeDeAgua = Double.parseDouble(textFieldVolumeDeAgua.getText());
    	String comentario = textAreaComentario.getText();
    	
    	//inicializacao de um novo dado a ser salvo
    	Dados dado = new Dados();
    	
    	//sets do novo dado
    	dado.set_local(lote);
    	dado.set_toneladas_organico(lixoGerado);
    	dado.set_area(areaDeVazao);
    	dado.set_volume(volumeDeAgua);
    	
    	//criacao do novo dado na tableView
    	ObservableList<Dados> list = dados.getItems();
    	list.add(dado);
    	dados.setItems(list);
    	
    	dado.set_comentario(comentario);
    	
    	//sets de calculos complexos do novo dado
    	LixoOrganico lixoOrg = new LixoOrganico();
    	lixoOrg.Processo(lote, lixoGerado, areaDeVazao, volumeDeAgua);
    	dado.set_energia_lixo(lixoOrg.energia_lixo);
    	dado.set_energia_gerada(lixoOrg.energia_produzida_gerador);
    	dado.set_energia_perdida(Math.abs(dado.get_energia_lixo()) - dado.get_energia_gerada);
    	
    	//sets complexos de data de geracao do novo dado
    	LocalDate ld = LocalDate.now();
    	java.util.Date dia_util = Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    	java.sql.Date dia_sql = new java.sql.Date(dia_util.getTime());
    	dado.set_dia(dia_sql);
    	
    	//instanciacao do banco de dados
    	// POSSO TIRAR ESSAS DUAS LINHAS PARA FORA DO METODO?
    	Database database = new Database("db");
    	DadosRepository repositorio = new DadosRepository(database);
    	
    	//salvamento do novo dado em um banco de dados
    	repositorio.create(dado);
    	
    	System.out.println("Relatório Gerado!");	
    }
    
    //metodo para alterar os valores de um dado ja existente
    public void atualizar() {
    	
    	//selecao do objeto na tableView
    	int idSelecionado = dados.getSelectionModel().getSelectedIndex();
    	
    	// COLOQUE TRATAMENTO DE ACESSIBILIDADE A BOTOES AQUI DENTRO
    	
    	String lote = textFieldLote.getText();
    	double lixoGerado = Double.parseDouble(textFieldLixoGerado.getText());
    	double areaDeVazao = Double.parseDouble(textFieldAreaDeVazao.getText());
    	double volumeDeAgua = Double.parseDouble(textFieldVolumeDeAgua.getText());
    	String comentario = textAreaComentario.getText();
    	
    	// PRECISA AQUI AINDA COLOCANDO PARA FORA DO METODO?
    	Database database = new Database("db");
    	DadosRepository repositorio = new DadosRepository(database);
    	
    	//geracao de uma copia do dado a partir do seu id no banco de dados
    	Dados dado = repositorio.loadFromId(idSelecionado);
    	
    	//sets do dado copiado com os novos parametros
    	dado.set_local(lote);
    	dado.set_toneladas_organico(lixoGerado);
    	dado.set_area(areaDeVazao);
    	dado.set_volume(volumeDeAgua);
    	
    	// ATUALIZAR O DADO NA TABLEVIEW
    	
    	dado.set_comentario(comentario);
    	
    	//chamamento do metodo update() para atualizar o dado verdadeiro no banco de dados
    	repositorio.update(dado);
    	
    	System.out.println("Relatório Atualizado!");
    }
    
    public void deletar() {
    	
    	//selecao do objeto na tableView
    	int idSelecionado = dados.getSelectionModel().getSelectedIndex();
    	
    	//remocao da tableView
    	dados.getItems().remove(idSelecionado);
    	
    	// TIRAR DE DENTRO DO METODO?
    	Database database = new Database("db");
    	DadosRepository repositorio = new DadosRepository(database);
    	
    	//exclui o dado real do banco de dados
    	repositorio.delete(idSelecionado);
    	
    	System.out.println("Relatório Deletado!");
    }
    
    //metodo para mostrar html
    public void visualizar() {
    	//selecao do objeto na tableView
    	int idSelecionado = dados.getSelectionModel().getSelectedIndex();
    	
    	// ESCREVER METODOS CORRETOS
    	CriadorHTML.CriarHTML(dado);
    	CriadorHTML.abriHTML(dado);
    	System.out.println("Relatório HTML Gerado!!");
    }
}
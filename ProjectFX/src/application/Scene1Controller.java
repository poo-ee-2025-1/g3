package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class Scene1Controller {
	@FXML
	Label labelNomeUsuario;
	@FXML
	Label labelUsername;
	@FXML
	Label labelQualificacao;
	@FXML
	Button logoutButton;
	@FXML
	TabPane tabPane;
	@FXML
	TextField textFieldLote;
	@FXML
	TextField textFieldLixoGerado;
	@FXML
	TextField textFieldVolumeDeAgua;
	@FXML
	TextField textFieldAreaDeVazao;
	@FXML
	TableView myTableView;
	@FXML
	Button buttonGerar;
	@FXML
	Button buttonAtualizar;
	@FXML
	Button buttonDeletar;
	@FXML
	Button buttonVisualizar;
	
	
	Stage stage;
	
	public void displayData(String nome, String username, String qualificacao) {
		labelNomeUsuario.setText("Bem Vindo, "+nome+".");
		labelUsername.setText("Username: "+username+".");
		labelQualificacao.setText("Qualificação: "+qualificacao+".");
	}
	
    public void logout(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) tabPane.getScene().getWindow();
			System.out.println("You successfully logged out!");
			stage.close();
		}
	}
    
    public void gerar() {
    	String lote = textFieldLote.getText();
    	double lixoGerado = Double.parseDouble(textFieldLixoGerado.getText());
    	double areaDeVazao = Double.parseDouble(textFieldAreaDeVazao.getText());
    	double volumeDeAgua = Double.parseDouble(textFieldVolumeDeAgua.getText());
    	//TESTE:
    	System.out.println(lote + lixoGerado + areaDeVazao + volumeDeAgua);
    	
    }
    
    public void atualizar() {
    	String lote = textFieldLote.getText();
    	double lixoGerado = Double.parseDouble(textFieldLixoGerado.getText());
    	double areaDeVazao = Double.parseDouble(textFieldAreaDeVazao.getText());
    	double volumeDeAgua = Double.parseDouble(textFieldVolumeDeAgua.getText());
    	//TESTE:
    	System.out.println(lote + lixoGerado + areaDeVazao + volumeDeAgua);
    	
    }
    
    public void deletar() {
    	//deletar um objeto clicado
    	//TESTE:
    	System.out.println("DELETADO!");
    }
    public void visualizar() {
    	//selecionar para aparecer HTML
    	//TESTE:
    	System.out.println("RELATÓRIO A MOSTRA!");
    }
}

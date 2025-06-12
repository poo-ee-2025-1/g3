package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
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
}

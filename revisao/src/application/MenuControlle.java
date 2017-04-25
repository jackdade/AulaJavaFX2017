package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuControlle {

	@FXML
	private BorderPane bpPrincipal;

	@FXML
	private MenuItem miAgencia;

	@FXML
	private MenuItem miConta;
	@FXML
	private MenuItem miCliente;

	@FXML
	void onAgencia(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("clienteForm2.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}

	@FXML
	void onCliente(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("clienteForm.fxml"));
		try {
			AnchorPane clienteView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(clienteView);
		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}

	
	@FXML
	void onConta(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("clienteForm3.fxml"));
		try {
			AnchorPane contaView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(contaView);
		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}
	
	@FXML
	void onMovimento(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("clienteForm4.fxml"));
		try {
			AnchorPane movimentoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(movimentoView);
		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}
	
	
	
}



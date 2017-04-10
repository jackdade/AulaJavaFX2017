package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * Classe principal do sistema, onde tem qual é o Stage principal e a Scene
 * inicial
 * 
 * Possui herança da classe Application
 * 
 * @author jacson trindade
 *
 */
public class MainAgencia extends Application {

	/**
	 * Método que o javafx chama por primeiro para saber qual é o conteudo da
	 * primeira tela
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			//elemento principal do meu layout,elemento inicial do meu xml.
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("clienteForm2.fxml"));
			//responsável por mostrar os elemetnos do meu layout.
			Scene scene = new Scene(root);
			//folha de estilo css para formatação dos elementos na tela
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//preparação do Stage para mostrar o conteudo da Scene.
			primaryStage.setScene(scene);
			//Mostra a tela para o usuário
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

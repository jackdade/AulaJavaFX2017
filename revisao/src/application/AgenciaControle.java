package application;



import java.util.Optional;

import br.edu.unoesc.revisaoOO.modelo.Agencia;
import br.edu.unoesc.revisaoOO.modelo.SimuladorBD;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AgenciaControle {

	
	
	
	  @FXML
	    private TextField tfNome;
	  @FXML
	    private TextField tfNumero;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private TableView<Agencia> tbvAgencia;
	    
	    @FXML
	    private TableColumn<Agencia, Number>tbvNumero;

	    @FXML
	    private TableColumn<Agencia, String>tbvNome;
	    
	    @FXML
	    private Button btnNovo;

	    	
	    @FXML
	    private Button btnExcluir;
	    
	    private boolean editando;
	    private Agencia agencia;

	    
	    @FXML
	    public void initialize(){
	    	
	    	tbvNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
	    	tbvNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	    	tbvAgencia.setItems(FXCollections.observableArrayList(SimuladorBD.getAgencias()));
	    	novo();
	    }
	    
	    @FXML
	    void onNovo(ActionEvent event){
	 	   novo();
	    }
	    
	    private void novo(){
	    	editando=false;
	    	agencia = new Agencia();
	    	limparCampos();
	    }
	    
	    private void limparCampos(){
	    	tfNome.setText("");
	    	tfNumero.setText("");
	    	
	    }
	  
	    
	    @FXML
	    void onEditar(MouseEvent mouseEvent) {
	    	if(mouseEvent.getEventType()
	    			.equals(MouseEvent.MOUSE_CLICKED)){
	    	agencia = (Agencia) tbvAgencia.getSelectionModel().getSelectedItem();
	    	tfNome.setText(agencia.getNome());
	    	tfNumero.setText(agencia.getNumero());
	    	
	    	editando = true;
	    }
	    }
	    
	    @FXML
	     void onSalvar(ActionEvent event){
	    	
	    	
	    	agencia.setNome(tfNome.getText());
	    	agencia.setNumero(tfNumero.getText());
	    	
	    	if(editando){
	    		SimuladorBD.atualizarAgencias();
	    		tbvAgencia.refresh();
	    	}
	    	else{
	    		SimuladorBD.insert(agencia);	
	    		tbvAgencia.getItems().add(agencia);
	    	}
	    	
	    	novo();
	    }
	    
	    @FXML
	    void onExcluir(ActionEvent event){
	    	//alerta do java
	    	Alert alerta = new Alert(AlertType.CONFIRMATION,"Deseja realmente excluir",ButtonType.CANCEL,
	     ButtonType.OK);
	    	
	    	Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
	    	
	    	okButton.setDefaultButton(false);
	    	
	    	final Optional<ButtonType>result =alerta.showAndWait();
	    	
	    if(result.get()==ButtonType.OK){
	    	tbvAgencia.getItems().remove(agencia);
	    	SimuladorBD.remover(agencia);
	    	limparCampos();
	    	
	    }
	    	
	    	//
	    	
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    


	   
	
	
	
	
	
	
	
}

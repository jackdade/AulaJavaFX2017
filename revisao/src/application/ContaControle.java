package application;


import br.edu.unoesc.revisaoOO.modelo.Conta;
import br.edu.unoesc.revisaoOO.modelo.SimuladorBD;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ContaControle {
	 @FXML
	    private Button btnsalvar;

	    @FXML
	    private Button btnNovo;

	    @FXML
	    private ComboBox<Conta> cbxCliente;

	    @FXML
	    private ComboBox<Conta> cbxAgencia;

	    @FXML
	    private TextField tfNumero;

	    @FXML
	    private TableView<Conta> tbvConta;

	    @FXML
	    private TableColumn<Conta, Number> tbvNumero;

	    @FXML
	    private TableColumn<Conta, String> tbvCliente;

	    
	    @FXML    
	    private boolean editando;
	    private Conta conta;
	    
	    @FXML
	    public void initialize(){
	    	
	    	tbvNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
	    	tbvConta.setItems(FXCollections.observableArrayList(SimuladorBD.getContas()));
	    	novo();
	    }
	    
	    
	    @FXML
	    void onNovo(ActionEvent event) {

	    	   novo();
	    }
	    
	    private void novo(){
	    	editando=false;
	    	conta = new Conta();
	    	limparCampos();
	    }
	    private void limparCampos(){
	    	tfNumero.setText("");
	    	
	    }
	    

	    @FXML
 void onSalvar(ActionEvent event){
	    	
	    	
	    	
	    	conta.setNumero(tfNumero.getText());
	    	
	    	if(editando){
	    		tbvConta.refresh();
	    	}
	    	else{
	    		SimuladorBD.insert(conta);	
	    		tbvConta.getItems().add(conta);
	    	}
	    	
	    	novo();
	    }
	    
	    @FXML
	    void onEditar(MouseEvent mouseEvent) {
	    	if(mouseEvent.getEventType()
	    			.equals(MouseEvent.MOUSE_CLICKED)){
	    	conta = (Conta) tbvConta.getSelectionModel().getSelectedItem();
	    	tfNumero.setText(conta.getNumero());
	    	
	    	editando = true;
	    }
	    }
}

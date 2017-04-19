package application;



import br.edu.unoesc.revisaoOO.modelo.Agencia;
import br.edu.unoesc.revisaoOO.modelo.Cliente;
import br.edu.unoesc.revisaoOO.modelo.SimuladorBD;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClienteControle {
	
	@FXML
    private TextField tfnome;

    @FXML
    private TextField tfcpf;

    @FXML
    private DatePicker dtdatadenascimento;

    @FXML
    private Button btnsalvar;

    @FXML
    private ListView<Cliente> lcCliente;

    private Cliente cliente;
    private boolean editando;
    
    @FXML
    private Button btnNovo;
    
    @FXML
    private ComboBox<Agencia>cbxAgencia;
    
    @FXML
    public void initialize(){
		lcCliente.setItems(FXCollections.observableArrayList());
		cbxAgencia.setItems(FXCollections.observableArrayList(SimuladorBD.getAgencias()));
    	novo();
    }
    
    
    
    @FXML
     void onSalvar(ActionEvent event){
    	
    	
    	cliente.setNome(tfnome.getText());
    	cliente.setCpf(tfcpf.getText());
    	cliente.setDataNascimento(dtdatadenascimento.getValue());
    	cliente.setAgenciaPreferencial(cbxAgencia.getValue());
    	if(editando){
    		lcCliente.refresh();
    	}
    	else{
    			lcCliente.getItems().add(cliente);
    			SimuladorBD.insert(cliente);
    	}
    	
    	novo();
    }
    
    @FXML
   void onNovo(ActionEvent event){
	   novo();
   }
    
    private void novo(){
    	editando=false;
    	cliente= new Cliente();
    	limparCampos();
    }
    
    private void limparCampos(){
    	tfnome.setText("");
    	tfcpf.setText("");
    	dtdatadenascimento.setValue(null);
    	
    }
    
    @FXML
    
    
    void onEditar(MouseEvent mouseEvent) {
    	if(mouseEvent.getEventType()
    			.equals(MouseEvent.MOUSE_CLICKED)){
    	cliente =lcCliente.getSelectionModel().getSelectedItem();
    	tfnome.setText(cliente.getNome());
    	tfcpf.setText(cliente.getCpf());
    	dtdatadenascimento.setValue(cliente.getDataNascimento());

    	cbxAgencia.setValue(cliente.getAgenciaPreferencial());
    	editando = true;
    }
    }
    

}

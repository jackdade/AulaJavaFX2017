package application;



import br.edu.unoesc.revisaoOO.modelo.Agencia;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgenciaControle {

	
	
	
	  @FXML
	    private TextField tfNome;
	  @FXML
	    private TextField tfNumero;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private ListView<Agencia> lvAgencia;

	    @FXML
	    private Button btnNovo;

	    	
	    @FXML
	    private Button btnExcluir;
	    
	    private boolean editando;
	    private Agencia agencia;

	    
	    @FXML
	    public void initialize(){
	    	lvAgencia.setItems(FXCollections.observableArrayList());
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
	  
	    }
	    @FXML
	    void onEditar(MouseEvent mouseEvent) {
	    	if(mouseEvent.getEventType()
	    			.equals(MouseEvent.MOUSE_CLICKED)){
	    	agencia = (Agencia) lvAgencia.getSelectionModel().getSelectedItem();
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
	    		lvAgencia.refresh();
	    	}
	    	else{
	    			lvAgencia.getItems().add(agencia);
	    	}
	    	
	    	novo();
	    }
	    
	    @FXML
	    void onExcluir(ActionEvent event){
	    	lvAgencia.getItems().remove(agencia);
	    	limparCampos();
	    }
	    
	    
	    
	    
	    
	    


	   
	
	
	
	
	
	
	
}

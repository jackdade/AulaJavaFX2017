package application;

import br.edu.unoesc.revisaoOO.modelo.Conta;
import br.edu.unoesc.revisaoOO.modelo.Movimento;
import br.edu.unoesc.revisaoOO.modelo.SimuladorBD;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MovimentoControle {
	
	
	@FXML
    private TextField tfValor;

    @FXML
    private Button btnNovo;

    @FXML
    private ComboBox<Conta> cbxConta;

    @FXML
    private TableView<Movimento> tbvMovimento;

    @FXML
    private TableColumn<Movimento, String> tbvTipo;

    @FXML
    private TableColumn<Movimento, String> tbvValor;

    @FXML
    private RadioButton rbDeposito;

    @FXML
    private RadioButton rbSaque;

    @FXML
    private TextField tfSaldo;
	
	

    
    private boolean sacando;
    
    private boolean depositando;
    
    
    



    
    
    
    
    
    
    private boolean editando;
    private Movimento movimento;
    
    @FXML
    public void initialize(){
		tbvTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tbvValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	
    	
    	
    	cbxConta.setItems(FXCollections.observableArrayList(SimuladorBD.getContas()));
		
		//tfValor.setText(Double.toString(movimento.getSaldo()));
    //    tfSaldo.setText(Double.toString(movimento.getSaldo()));
		tbvMovimento.setItems(FXCollections.observableArrayList(SimuladorBD.getMovimentos()));
    	novo();
    
    }
    

  

    @FXML
    void onNovo(ActionEvent event){
 	   novo();
    }
    
    private void novo(){
    	editando=false;
    	sacando=false;
    	depositando=false;
    	movimento = new Movimento();
    	limparCampos();
    }
    
    private void limparCampos(){
    	tfValor.setText("");
    	tfSaldo.setText("");
    	cbxConta.setValue(null);
    	
    }

    @FXML
    void onRadion(ActionEvent event){
  	  	movimento.setTipo("saque");
    	sacando=true;
    	
    	
 	selecionado();
    }
    private void selecionado(){
    	
    		rbDeposito.setSelected(false);
    		rbSaque.setSelected(true);
    		
    }
    
    @FXML
    void onRadion1(ActionEvent event){
    	movimento.setTipo("deposito");
    	depositando=true;
    	selecionado1();
    }
    private void selecionado1(){
    	
    		rbDeposito.setSelected(true);
    		rbSaque.setSelected(false);
    		
    }
    @FXML
    void onEditar(MouseEvent event) {
    	if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED));
		movimento = tbvMovimento.getSelectionModel().getSelectedItem(); // carregou
																			// pra
																			// variavel
																			// agencia

		tfValor.setText(Double.toString(movimento.getValor()));

		cbxConta.setValue(movimento.getConta());

		tfSaldo.setText(Double.toString(movimento.getConta().getSaldo()));

		editando = true;
		
		rbDeposito.setSelected(false);
		rbSaque.setSelected(false);
    }

    @FXML
	void onSalvar(ActionEvent event) {
//    	if (editando == true) {
//			novo();
//
//		} else {
			

			movimento.setConta(cbxConta.getValue());

			if (depositando == true) {
				// conta.depositar(Double.parseDouble(tfValor.getText()));
				movimento.getConta().depositar(Double.parseDouble(tfValor.getText()));
			} else {
				// sacando = conta.sacar(Double.parseDouble(tfValor.getText()));
				sacando = movimento.getConta().sacar(Double.parseDouble(tfValor.getText()));
			}

			movimento.setValor(Double.parseDouble(tfValor.getText()));

	//		if (depositando || sacando) {

				if (editando) {
					tbvMovimento.refresh(); // atualiza

				} else {
					SimuladorBD.insert(movimento);
					tbvMovimento.getItems().add(movimento); // adiciona na
																// lista
			//	}
			}

			novo();
		}
	
	}
    
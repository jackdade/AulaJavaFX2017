package application;

import br.edu.unoesc.revisaoOO.modelo.Agencia;
import br.edu.unoesc.revisaoOO.modelo.Cliente;
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

public class Controleconta {
	 @FXML
	    private Button btnsalvar;

	    @FXML
	    private Button btnNovo;

	    @FXML
	    private ComboBox<Cliente> cbxCliente;

	    @FXML
	    private ComboBox<Agencia> cbxAgencia;

	    @FXML
	    private TableView<Conta> tbvConta;
	    @FXML
	    private TextField tfNumero;

	    @FXML
	    private TableColumn<Conta, Number> tbvNumero;

	    @FXML
	    private TableColumn<Cliente, String> tbvCliente;

	    @FXML
		private boolean editando;
		private Conta conta;

		@FXML
		public void initialize() {
			tbvNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
			tbvCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
			// tbvCliente.getNome(FXCollections.observableArrayList(SimuladorBD.getClientes()));

			cbxAgencia.setItems(FXCollections.observableArrayList(SimuladorBD.getAgencias()));
			cbxCliente.setItems(FXCollections.observableArrayList(SimuladorBD.getClientes()));
			novo();
		}

		@FXML
		void onNovo(ActionEvent event) {

			novo();
		}

		private void novo() {
			editando = false;
			conta = new Conta();
			limparCampos();
		}

		   private void limparCampos(){
		    	
		    	tfNumero.setText("");
		    	
		    }

		@FXML
		void onSalvar(ActionEvent event) {

			conta.setNumero(tfNumero.getText());
			conta.setAgenciaPreferencial(cbxAgencia.getValue());
			conta.setClientePreferencial(cbxCliente.getValue());

			if (editando) {
				tbvConta.refresh();
			} else {
				SimuladorBD.insert(conta);
				tbvConta.getItems().add(conta);
			}

			novo();
		}

		@FXML
		void onEditar(MouseEvent mouseEvent) {
			if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
				conta = (Conta) tbvConta.getSelectionModel().getSelectedItem();
				tfNumero.setText(conta.getNumero());
				cbxAgencia.setValue(conta.getAgenciaPreferencial());
				cbxAgencia.setValue(conta.getAgenciaPreferencial());
				editando = true;
			}
		}
}
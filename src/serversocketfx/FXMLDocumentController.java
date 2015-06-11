/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocketfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author wagner
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnIniciarServidor;
    @FXML
    private Label lblStatus;

    Thread trd;
    Server serv = new Server();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void iniciarServidor(ActionEvent event) {
        trd = new Thread(serv);
        trd.start();
        lblStatus.setText("Servidor Operando...");
        lblStatus.setTextFill(Color.GREEN);
    }
}

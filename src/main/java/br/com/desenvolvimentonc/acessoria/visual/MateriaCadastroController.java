/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desenvolvimentonc.acessoria.visual;

import br.com.desenvolvimentonc.acessoria.bd.entities.Materia;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jose_Augusto
 */
public class MateriaCadastroController implements Initializable {
  @FXML
    private Label label;
    @FXML
    private TableView tableMateria;
    @FXML
    private TextField editTitle;
    @FXML
    private TextField editUrl;
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private ComboBox comboJ;
    
    
    
    ObservableList<Materia> materiaList;

    
    
     private void initializeTableMateria(){
          ((TableColumn)(tableMateria.getColumns().get(0))).setCellValueFactory(new PropertyValueFactory<Materia,Long>("id"));
          ((TableColumn)(tableMateria.getColumns().get(1))).setCellValueFactory(new PropertyValueFactory<Materia,String>("title"));
           ((TableColumn)(tableMateria.getColumns().get(2))).setCellValueFactory(new PropertyValueFactory<Materia,String>("url"));
   
          ((TableColumn)(tableMateria.getColumns().get(3))).setCellValueFactory(new PropertyValueFactory<Materia,String>("nameJornalista1"));
              ((TableColumn)(tableMateria.getColumns().get(4))).setCellValueFactory(new PropertyValueFactory<Materia,String>("nameJornalista2"));
          
               ((TableColumn)(tableMateria.getColumns().get(5))).setCellValueFactory(new PropertyValueFactory<Materia,String>("nameFotografo"));
                ((TableColumn)(tableMateria.getColumns().get(6))).setCellValueFactory(new PropertyValueFactory<Materia,Integer>("qtdFotos"));
               ((TableColumn)(tableMateria.getColumns().get(7))).setCellValueFactory(new PropertyValueFactory<Materia,String>("nameCategoria"));
              ((TableColumn)(tableMateria.getColumns().get(8))).setCellValueFactory(new PropertyValueFactory<Materia,String>("nameAssuntos"));
              ((TableColumn)(tableMateria.getColumns().get(9))).setCellValueFactory(new PropertyValueFactory<Materia,Calendar>("date"));

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       initializeTableMateria();
        materiaList= FXCollections.observableArrayList();
        tableMateria.setItems(materiaList);
    }    
    
}

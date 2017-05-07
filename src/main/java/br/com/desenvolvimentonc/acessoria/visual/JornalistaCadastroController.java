/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desenvolvimentonc.acessoria.visual;

import br.com.desenvolvimentonc.acessoria.bd.dao.JornalistaDao;
import br.com.desenvolvimentonc.acessoria.bd.entities.Jornalista;
import br.com.desenvolvimentonc.acessoria.bd.entities.Materia;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jabra
 */
public class JornalistaCadastroController implements Initializable {

    
    @FXML
    Button btNew;
    
    @FXML
    Button btSave;
    
    @FXML
    TextField editName;
    
    @FXML
    TableView tableView;
    
    ObservableList<Jornalista> jornalistaList;
    
    private void initializeTableView(){
          ((TableColumn)(tableView.getColumns().get(0))).setCellValueFactory(new PropertyValueFactory<Jornalista,Long>("id"));
          ((TableColumn)(tableView.getColumns().get(1))).setCellValueFactory(new PropertyValueFactory<Jornalista,String>("name"));
        
  
    }
    
    Jornalista jornalistaSelected= new Jornalista();
    
    @FXML
   private void  saveClicked(){
       jornalistaSelected.setName(editName.getText());
       if(jornalistaSelected.getId()==null){
           jornalistaDao.save(jornalistaSelected);
           jornalistaList.add(jornalistaSelected);
       } else{
            jornalistaDao.update(jornalistaSelected);
            tableView.refresh();
       }
       
   
   }
   
   private void refreshFilds(){
        editName.setText(jornalistaSelected.getName());
   }
   
   @FXML
   private void  createClicked(){
       jornalistaSelected= new Jornalista();
       refreshFilds();
   }
    
    JornalistaDao jornalistaDao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jornalistaList= FXCollections.observableArrayList();
        initializeTableView();
        tableView.setItems(jornalistaList);
        jornalistaDao= new JornalistaDao();
        jornalistaList.addAll(jornalistaDao.findAll());
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                jornalistaSelected=(Jornalista) newValue;
                
                refreshFilds();
               
            }
        });
         
    }    
    
}

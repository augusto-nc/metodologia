/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desenvolvimentonc.acessoria.visual;

import br.com.desenvolvimentonc.acessoria.bd.dao.FotografoDao;
import br.com.desenvolvimentonc.acessoria.bd.dao.JornalistaDao;
import br.com.desenvolvimentonc.acessoria.bd.entities.Fotografo;
import br.com.desenvolvimentonc.acessoria.bd.entities.Jornalista;
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
public class FotografoCadastroController implements Initializable {

  @FXML
    Button btNew;
    
    @FXML
    Button btSave;
    
    @FXML
    TextField editName;
    
    @FXML
    TableView tableView;
    
    ObservableList<Fotografo> fotografoList;
    
    private void initializeTableView(){
          ((TableColumn)(tableView.getColumns().get(0))).setCellValueFactory(new PropertyValueFactory<Fotografo,Long>("id"));
          ((TableColumn)(tableView.getColumns().get(1))).setCellValueFactory(new PropertyValueFactory<Fotografo,String>("name"));
        
  
    }
    
    Fotografo fotografoSelected= new Fotografo();
           
    @FXML
   private void  saveClicked(){
       fotografoSelected.setName(editName.getText());
       if(fotografoSelected.getId()==null){
           fotografoDao.save(fotografoSelected);
           fotografoList.add(fotografoSelected);
       } else{
            fotografoDao.update(fotografoSelected);
            tableView.refresh();
       }
       
   
   }
   
   private void refreshFilds(){
        editName.setText(fotografoSelected.getName());
   }
   
   @FXML
   private void  createClicked(){
       fotografoSelected= new Fotografo();
       refreshFilds();
   }
    
    FotografoDao fotografoDao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fotografoList= FXCollections.observableArrayList();
        initializeTableView();
        tableView.setItems(fotografoList);
        fotografoDao= new FotografoDao();
        fotografoList.addAll(fotografoDao.findAll());
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                fotografoSelected=(Fotografo) newValue;
                refreshFilds();             
            }
        });
    }    
    
}

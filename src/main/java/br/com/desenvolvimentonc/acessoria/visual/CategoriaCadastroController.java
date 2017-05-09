/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desenvolvimentonc.acessoria.visual;

import br.com.desenvolvimentonc.acessoria.bd.dao.CategoriaDao;
import br.com.desenvolvimentonc.acessoria.bd.entities.Categoria;
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
public class CategoriaCadastroController implements Initializable {

 @FXML
    Button btNew;
    
    @FXML
    Button btSave;
    
    @FXML
    TextField editName;
    
    @FXML
    TableView tableView;
    
    ObservableList<Categoria> CategoriaList;
    
    private void initializeTableView(){
          ((TableColumn)(tableView.getColumns().get(0))).setCellValueFactory(new PropertyValueFactory<Categoria,Long>("id"));
          ((TableColumn)(tableView.getColumns().get(1))).setCellValueFactory(new PropertyValueFactory<Categoria,String>("name"));
        
  
    }
    
    Categoria categoriaSelected= new Categoria();
           
    @FXML
   private void  saveClicked(){
       categoriaSelected.setName(editName.getText());
       if(categoriaSelected.getId()==null){
           CategoriaDao.save(categoriaSelected);
           CategoriaList.add(categoriaSelected);
       } else{
            CategoriaDao.update(categoriaSelected);
            tableView.refresh();
       }
       
   
   }
   
   private void refreshFilds(){
        editName.setText(categoriaSelected.getName());
   }
   
   @FXML
   private void  createClicked(){
       categoriaSelected= new Categoria();
       refreshFilds();
   }
    
    CategoriaDao CategoriaDao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoriaList= FXCollections.observableArrayList();
        initializeTableView();
        tableView.setItems(CategoriaList);
        CategoriaDao= new CategoriaDao();
        CategoriaList.addAll(CategoriaDao.findAll());
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                categoriaSelected=(Categoria) newValue;
                refreshFilds();             
            }
        });
    }    
    
}

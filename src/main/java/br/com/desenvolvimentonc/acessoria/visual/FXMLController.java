package br.com.desenvolvimentonc.acessoria.visual;

import br.com.desenvolvimentonc.acessoria.bd.dao.MateriaDao;
import br.com.desenvolvimentonc.acessoria.bd.entities.Materia;
import br.com.desenvolvimentonc.acessoria.bd.utils.DaoFactory;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {
    
   @FXML
    MenuBar menuBar;  
   @FXML
    AnchorPane holder;       
           
   
    
    Materia selectedMateria=new Materia();
    
    @FXML
     private void materiaClicked() {
       holder.getChildren().clear();
       try {
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/MateriaCadastro.fxml"));
           holder.getChildren().addAll(root);

       } catch (IOException ex) {
           Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
       @FXML
     private void fotografoClicked() {
       holder.getChildren().clear();
       try {
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/FotografoCadastro.fxml"));
           holder.getChildren().addAll(root);

       } catch (IOException ex) {
           Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
     
     @FXML
     void jornalistaClicked() {
      
       holder.getChildren().clear();
       try {
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/JornalistaCadastro.fxml"));
           holder.getChildren().addAll(root);
       } catch (IOException ex) {
           Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        materiaClicked();
     
    }    
}

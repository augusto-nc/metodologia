/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desenvolvimentonc.acessoria.visual;

import br.com.desenvolvimentonc.acessoria.bd.dao.CategoriaDao;
import br.com.desenvolvimentonc.acessoria.bd.dao.FotografoDao;
import br.com.desenvolvimentonc.acessoria.bd.dao.JornalistaDao;
import br.com.desenvolvimentonc.acessoria.bd.dao.MateriaDao;
import br.com.desenvolvimentonc.acessoria.bd.entities.Categoria;
import br.com.desenvolvimentonc.acessoria.bd.entities.Colaborador;
import br.com.desenvolvimentonc.acessoria.bd.entities.Fotografo;
import br.com.desenvolvimentonc.acessoria.bd.entities.Jornalista;
import br.com.desenvolvimentonc.acessoria.bd.entities.Materia;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
    private TextField editQtdFotos;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private ComboBox comboJornalista1;
    
    @FXML
    private ComboBox comboJornalista2;
    
    @FXML
    private ComboBox comboFotografo;
    
    @FXML
    private ComboBox comboCategoria;
    private ObservableList<Categoria> categoriaList;
    
    
    @FXML
    void novoClicked(){
        materiaSelected= new Materia();
        refreshFields();
    }
    
    @FXML
    void saveClicked(){
        try{
              materiaSelected.setQtdFotos(Integer.valueOf(editQtdFotos.getText()));
        }catch(Exception e){
            materiaSelected.setQtdFotos(0);
        }
        materiaSelected.setTitle(editTitle.getText());
        materiaSelected.setUrl(editUrl.getText());
        materiaSelected.setJornalista1((Jornalista) comboJornalista1.getSelectionModel().getSelectedItem());
        materiaSelected.setJornalista2((Jornalista) comboJornalista2.getSelectionModel().getSelectedItem());
        materiaSelected.setFotografo((Fotografo) comboFotografo.getSelectionModel().getSelectedItem());
        materiaSelected.setCategoria((Categoria) comboCategoria.getSelectionModel().getSelectedItem());
        
        if(datePicker.getValue()!=null){
        Date date=   java.util.Date.from( 
        datePicker.getValue().atStartOfDay( 
            ZoneId.systemDefault() 
        ).toInstant() 
        );
        Calendar c= Calendar.getInstance();
        c.setTime(date);
        materiaSelected.setDate(c);
        }
        
        
        
        if(materiaSelected.getId()==null){
            materiaDao.save(materiaSelected);
            materiaList.add(materiaSelected);
        }else{
           materiaDao.update(materiaSelected);
           tableMateria.refresh();
        }
    }
    
    void refreshFields(){
        editUrl.setText(materiaSelected.getUrl());
        if(materiaSelected.getQtdFotos()!=null){
            editQtdFotos.setText(materiaSelected.getQtdFotos()+"");
        }else{
            editQtdFotos.setText("");
        }
        editTitle.setText(materiaSelected.getTitle());
        Calendar c= materiaSelected.getDate();
        
        if(c!=null){
            LocalDate date=c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            datePicker.setValue(date);
        }else{
            datePicker.setValue(null);
        }
        comboJornalista2.setValue(materiaSelected.getJornalista2());
        comboJornalista1.setValue(materiaSelected.getJornalista1());
        comboFotografo.setValue(materiaSelected.getFotografo());
        comboCategoria.setValue(materiaSelected.getCategoria());


    }
    
    ObservableList<Materia> materiaList;
     JornalistaDao jornalistaDao=new JornalistaDao();
     FotografoDao fotografoDao=new FotografoDao();
     CategoriaDao categoriaDao=new CategoriaDao();

     MateriaDao materiaDao= new MateriaDao();
     ObservableList<Jornalista> jornalistaList;
      ObservableList<Fotografo> fotografoList;

    Materia materiaSelected=new Materia();
    
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
          ((TableColumn)(tableMateria.getColumns().get(9))).setCellValueFactory(new PropertyValueFactory<Materia,String>("formatedDate"));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       initializeTableMateria();
        materiaList= FXCollections.observableArrayList();
        tableMateria.setItems(materiaList);
        jornalistaList= FXCollections.observableArrayList();
        fotografoList= FXCollections.observableArrayList();
        categoriaList=FXCollections.observableArrayList();
        jornalistaList.addAll(jornalistaDao.findAll());
        fotografoList.addAll(fotografoDao.findAll());
        categoriaList.addAll(categoriaDao.findAll());
        configComboBox();
        
        materiaList.addAll(materiaDao.findAll());
        tableMateria.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
           @Override
           public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               materiaSelected=(Materia) newValue;
               refreshFields();
           }
        }
);
        
    }    
    
    
    private void configComboBox(){
        comboJornalista1.setItems(jornalistaList);
        comboJornalista2.setItems(jornalistaList);
        comboFotografo.setItems(fotografoList);
        comboCategoria.setItems(categoriaList);
        Callback cellFactory = new Callback<ListView<Colaborador>,ListCell<Colaborador>>(){
    @Override
    public ListCell<Colaborador> call(ListView<Colaborador> l){
        return new ListCell<Colaborador>(){
            @Override
            protected void updateItem(Colaborador item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setText(item.getName());
                }
            }
        } ;
    }
};
         StringConverter<Colaborador> strConverter=new StringConverter<Colaborador>() {
              @Override
              public String toString(Colaborador user) {
                if (user == null){
                  return null;
                } else {
                  return user.getName();
                }
              }

            @Override
            public Colaborador fromString(String userId) {
                return null;
            }
        };
    
        comboJornalista1.setConverter(strConverter);
        comboJornalista2.setConverter(strConverter);
        comboJornalista1.setCellFactory(cellFactory);
        comboJornalista2.setCellFactory(cellFactory);
        comboFotografo.setConverter(strConverter);
        comboFotografo.setCellFactory(cellFactory);
        
             Callback cellFactory1 = new Callback<ListView<Categoria>,ListCell<Categoria>>(){
    @Override
    public ListCell<Categoria> call(ListView<Categoria> l){
        return new ListCell<Categoria>(){
            @Override
            protected void updateItem(Categoria item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setText(item.getName());
                }
            }
        } ;
    }
};
         StringConverter<Categoria> strConverter1=new StringConverter<Categoria>() {
              @Override
              public String toString(Categoria user) {
                if (user == null){
                  return null;
                } else {
                  return user.getName();
                }
              }

            @Override
            public Categoria fromString(String userId) {
                return null;
            }
        };
    
        comboCategoria.setConverter(strConverter1);
        comboCategoria.setCellFactory(cellFactory1);
    }
    
}

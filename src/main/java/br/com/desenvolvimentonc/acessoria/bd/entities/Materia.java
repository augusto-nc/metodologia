/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desenvolvimentonc.acessoria.bd.entities;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jose_Augusto
 */

@Entity
@Table(name="materias")
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="titulo")
    private String title;
    
    @Column(name="url")
    private String url;
    
    
    @Column(name="qtdFotos")
    private Integer qtdFotos;

    public Integer getQtdFotos() {
        return qtdFotos;
    }

    public void setQtdFotos(Integer qtdFotos) {
        this.qtdFotos = qtdFotos;
    }
    
    
    
    @OneToOne
    private Categoria categoria;
    
    @OneToOne
    Jornalista jornalista1;
      
      @OneToOne
    Jornalista jornalista2;
    
    @OneToOne
    Fotografo fotografo;

    public Fotografo getFotografo() {
        return fotografo;
    }

    public void setFotografo(Fotografo fotografo) {
        this.fotografo = fotografo;
    }
      
    @Temporal(TemporalType.TIMESTAMP)
    Calendar date;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Jornalista getJornalista1() {
        return jornalista1;
    }

    public void setJornalista1(Jornalista jornalista1) {
        this.jornalista1 = jornalista1;
    }

    public Jornalista getJornalista2() {
        return jornalista2;
    }

    public void setJornalista2(Jornalista jornalista2) {
        this.jornalista2 = jornalista2;
    }
    
    public String getNameJornalista2() {
         return jornalista2!=null ? jornalista2.getName() : "";
    }

    public String getNameJornalista1() {
        return jornalista1!=null ? jornalista1.getName() : "";
    }
    
     public String getNameFotografo() {
        return fotografo!=null ? fotografo.getName() : "";
    }
     public String getNameCategoria() {
        return categoria!=null ? categoria.getName() : " - ";
    }
     
     
     
    public String getNameAssuntos() {
        if(assuntos!=null){
            String str=new String();
            for(Assunto a:assuntos){
                str+=a.getName() +" ";
            }
            return str;
        }else{
            return "";
        }
       
    }

    @ManyToMany
      @JoinTable(name="assunto_materia", joinColumns=
      {@JoinColumn(name="materia_id")}, inverseJoinColumns=
        {@JoinColumn(name="assunto_id")})
    private List<Assunto> assuntos;

    public String getUrl() {
        return url;
    }
    
    @OneToMany(cascade = ALL,mappedBy = "materia")
    List<Foto> fotos;

    
    
    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Assunto> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.desenvolvimentonc.acessoria.Materia[ id=" + id + " ]";
    }
    
}

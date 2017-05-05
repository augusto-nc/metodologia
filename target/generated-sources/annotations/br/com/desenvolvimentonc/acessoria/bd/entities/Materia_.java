package br.com.desenvolvimentonc.acessoria.bd.entities;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Materia.class)
public abstract class Materia_ {

	public static volatile SingularAttribute<Materia, Calendar> date;
	public static volatile SingularAttribute<Materia, Integer> qtdFotos;
	public static volatile SingularAttribute<Materia, Jornalista> jornalista1;
	public static volatile SingularAttribute<Materia, Jornalista> jornalista2;
	public static volatile SingularAttribute<Materia, Categoria> categoria;
	public static volatile SingularAttribute<Materia, Long> id;
	public static volatile SingularAttribute<Materia, String> title;
	public static volatile SingularAttribute<Materia, String> url;
	public static volatile ListAttribute<Materia, Assunto> assuntos;
	public static volatile ListAttribute<Materia, Foto> fotos;
	public static volatile SingularAttribute<Materia, Fotografo> fotografo;

}


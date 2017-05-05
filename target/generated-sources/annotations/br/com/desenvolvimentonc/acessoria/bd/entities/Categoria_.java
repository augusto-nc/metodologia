package br.com.desenvolvimentonc.acessoria.bd.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, String> name;
	public static volatile SingularAttribute<Categoria, Materia> materia;
	public static volatile SingularAttribute<Categoria, Long> id;

}


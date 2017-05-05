package br.com.desenvolvimentonc.acessoria.bd.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Assunto.class)
public abstract class Assunto_ {

	public static volatile SingularAttribute<Assunto, String> name;
	public static volatile SingularAttribute<Assunto, Long> id;
	public static volatile ListAttribute<Assunto, Materia> materias;

}


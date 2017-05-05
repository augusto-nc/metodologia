/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desenvolvimentonc.acessoria.bd.utils;

import br.com.desenvolvimentonc.acessoria.bd.dao.MateriaDao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jose_Augusto
 */
public class DaoFactory {
    private static final String PERSISTENCE_UNIT_NAME = "br.com.desenvolvimentonc_acessoria_jar_1.0-SNAPSHOTPU";

	private static EntityManagerFactory entityManagerFactoryInstance;

	public static EntityManagerFactory entityManagerFactorInstance() {
		if (entityManagerFactoryInstance == null) {
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return entityManagerFactoryInstance;
	}
        
        private static MateriaDao materiaDaoInstance;

	public static MateriaDao materiaInstance() {
		if (materiaDaoInstance == null) {
			materiaDaoInstance = new MateriaDao();
		}

		return materiaDaoInstance;
	}
        
        
        
}

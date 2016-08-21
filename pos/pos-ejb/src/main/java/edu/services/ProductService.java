package edu.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pos.entities.Product;

/**
 * Session Bean implementation class ProductService
 */
@Stateless
@LocalBean
public class ProductService implements ProductServiceRemote, ProductServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProductService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProduct(Product p) {
		em.persist(p);
		
	}

}

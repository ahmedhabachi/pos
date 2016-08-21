package edu.services;

import javax.ejb.Remote;

import pos.entities.Product;

@Remote
public interface ProductServiceRemote {

	void addProduct(Product p);
	
}

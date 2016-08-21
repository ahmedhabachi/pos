package client.test;

import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation.Family;

import pos.delegate.ProductDelegate;
import pos.entities.Product;
import pos.entities.Productfamily;
import pos.entities.Subfamily;

public class Test {

	public static void main(String[] args) {
		
		Productfamily family=new Productfamily();
		family.setIdFamily(1);
		
		Subfamily subfamily=new Subfamily();
		subfamily.setIdSF(1);
		subfamily.setProductfamily(family);
		
		Product p =new Product();
		p.setSubfamily(subfamily);
		p.setLabel("test prod");
		
		ProductDelegate.addProd(p);

	}

}

package pos.delegate;

import edu.services.ProductServiceRemote;
import pos.entities.Product;
import pos.servicelocator.ServiceLocator;

public class ProductDelegate {

	private static ProductServiceRemote prodServRem;
	private final static String jndiName = "pos-ear/pos-ejb/ProductService!edu.services.ProductServiceRemote";

	private static ProductServiceRemote getProxy() {
		return (ProductServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);

	}
	
	public static void addProd(Product p){
		getProxy().addProduct(p);
	}
	
}

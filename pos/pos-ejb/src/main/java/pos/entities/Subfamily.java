package pos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subfamily database table.
 * 
 */
@Entity
@NamedQuery(name="Subfamily.findAll", query="SELECT s FROM Subfamily s")
public class Subfamily implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSF;

	private String description;

	private String img;

	private String label;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="subfamily", fetch=FetchType.EAGER)
	private List<Product> products;

	//bi-directional many-to-one association to Productfamily
	@ManyToOne
	@JoinColumn(name="idFamily")
	private Productfamily productfamily;

	public Subfamily() {
	}

	public int getIdSF() {
		return this.idSF;
	}

	public void setIdSF(int idSF) {
		this.idSF = idSF;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSubfamily(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSubfamily(null);

		return product;
	}

	public Productfamily getProductfamily() {
		return this.productfamily;
	}

	public void setProductfamily(Productfamily productfamily) {
		this.productfamily = productfamily;
	}

}
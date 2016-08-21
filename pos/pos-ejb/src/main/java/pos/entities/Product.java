package pos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduit;

	private String desccription;

	private String img;

	private String label;

	private BigDecimal price;

	//bi-directional many-to-one association to Cafeorderline
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<Cafeorderline> cafeorderlines;

	//bi-directional many-to-one association to Subfamily
	@ManyToOne
	@JoinColumn(name="idSF")
	private Subfamily subfamily;

	public Product() {
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesccription() {
		return this.desccription;
	}

	public void setDesccription(String desccription) {
		this.desccription = desccription;
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

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Cafeorderline> getCafeorderlines() {
		return this.cafeorderlines;
	}

	public void setCafeorderlines(List<Cafeorderline> cafeorderlines) {
		this.cafeorderlines = cafeorderlines;
	}

	public Cafeorderline addCafeorderline(Cafeorderline cafeorderline) {
		getCafeorderlines().add(cafeorderline);
		cafeorderline.setProduct(this);

		return cafeorderline;
	}

	public Cafeorderline removeCafeorderline(Cafeorderline cafeorderline) {
		getCafeorderlines().remove(cafeorderline);
		cafeorderline.setProduct(null);

		return cafeorderline;
	}

	public Subfamily getSubfamily() {
		return this.subfamily;
	}

	public void setSubfamily(Subfamily subfamily) {
		this.subfamily = subfamily;
	}

}
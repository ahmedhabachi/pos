package pos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cafeorderline database table.
 * 
 */
@Entity
@NamedQuery(name="Cafeorderline.findAll", query="SELECT c FROM Cafeorderline c")
public class Cafeorderline implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CafeorderlinePK id;

	private int qte;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idProduit", insertable=false, updatable=false)
	private Product product;

	//bi-directional many-to-one association to Cafeorder
	@ManyToOne
	@JoinColumn(name="idcafeorder", insertable=false, updatable=false)
	private Cafeorder cafeorder;

	public Cafeorderline() {
	}

	public CafeorderlinePK getId() {
		return this.id;
	}

	public void setId(CafeorderlinePK id) {
		this.id = id;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cafeorder getCafeorder() {
		return this.cafeorder;
	}

	public void setCafeorder(Cafeorder cafeorder) {
		this.cafeorder = cafeorder;
	}

}
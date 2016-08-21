package pos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productfamily database table.
 * 
 */
@Entity
@NamedQuery(name="Productfamily.findAll", query="SELECT p FROM Productfamily p")
public class Productfamily implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFamily;

	private String description;

	private String img;

	private String label;

	//bi-directional many-to-one association to Subfamily
	@OneToMany(mappedBy="productfamily", fetch=FetchType.EAGER)
	private List<Subfamily> subfamilies;

	public Productfamily() {
	}

	public int getIdFamily() {
		return this.idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
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

	public List<Subfamily> getSubfamilies() {
		return this.subfamilies;
	}

	public void setSubfamilies(List<Subfamily> subfamilies) {
		this.subfamilies = subfamilies;
	}

	public Subfamily addSubfamily(Subfamily subfamily) {
		getSubfamilies().add(subfamily);
		subfamily.setProductfamily(this);

		return subfamily;
	}

	public Subfamily removeSubfamily(Subfamily subfamily) {
		getSubfamilies().remove(subfamily);
		subfamily.setProductfamily(null);

		return subfamily;
	}

}
package pos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cafetable database table.
 * 
 */
@Entity
@NamedQuery(name="Cafetable.findAll", query="SELECT c FROM Cafetable c")
public class Cafetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTable;

	private int capacity;

	private byte state;

	private int tablenumber;

	//bi-directional many-to-one association to Cafeorder
	@OneToMany(mappedBy="cafetable", fetch=FetchType.EAGER)
	private List<Cafeorder> cafeorders;

	public Cafetable() {
	}

	public int getIdTable() {
		return this.idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public byte getState() {
		return this.state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public int getTablenumber() {
		return this.tablenumber;
	}

	public void setTablenumber(int tablenumber) {
		this.tablenumber = tablenumber;
	}

	public List<Cafeorder> getCafeorders() {
		return this.cafeorders;
	}

	public void setCafeorders(List<Cafeorder> cafeorders) {
		this.cafeorders = cafeorders;
	}

	public Cafeorder addCafeorder(Cafeorder cafeorder) {
		getCafeorders().add(cafeorder);
		cafeorder.setCafetable(this);

		return cafeorder;
	}

	public Cafeorder removeCafeorder(Cafeorder cafeorder) {
		getCafeorders().remove(cafeorder);
		cafeorder.setCafetable(null);

		return cafeorder;
	}

}
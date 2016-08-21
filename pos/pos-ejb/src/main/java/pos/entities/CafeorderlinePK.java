package pos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cafeorderline database table.
 * 
 */
@Embeddable
public class CafeorderlinePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idProduit;

	@Column(insertable=false, updatable=false)
	private int idcafeorder;

	public CafeorderlinePK() {
	}
	public int getIdProduit() {
		return this.idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdcafeorder() {
		return this.idcafeorder;
	}
	public void setIdcafeorder(int idcafeorder) {
		this.idcafeorder = idcafeorder;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CafeorderlinePK)) {
			return false;
		}
		CafeorderlinePK castOther = (CafeorderlinePK)other;
		return 
			(this.idProduit == castOther.idProduit)
			&& (this.idcafeorder == castOther.idcafeorder);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProduit;
		hash = hash * prime + this.idcafeorder;
		
		return hash;
	}
}
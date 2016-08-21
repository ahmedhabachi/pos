package pos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cafeorder database table.
 * 
 */
@Entity
@NamedQuery(name="Cafeorder.findAll", query="SELECT c FROM Cafeorder c")
public class Cafeorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcafeorder;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private BigDecimal total;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Cafetable
	@ManyToOne
	@JoinColumn(name="idTable")
	private Cafetable cafetable;

	//bi-directional many-to-one association to Cafeorderline
	@OneToMany(mappedBy="cafeorder", fetch=FetchType.EAGER)
	private List<Cafeorderline> cafeorderlines;

	public Cafeorder() {
	}

	public int getIdcafeorder() {
		return this.idcafeorder;
	}

	public void setIdcafeorder(int idcafeorder) {
		this.idcafeorder = idcafeorder;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cafetable getCafetable() {
		return this.cafetable;
	}

	public void setCafetable(Cafetable cafetable) {
		this.cafetable = cafetable;
	}

	public List<Cafeorderline> getCafeorderlines() {
		return this.cafeorderlines;
	}

	public void setCafeorderlines(List<Cafeorderline> cafeorderlines) {
		this.cafeorderlines = cafeorderlines;
	}

	public Cafeorderline addCafeorderline(Cafeorderline cafeorderline) {
		getCafeorderlines().add(cafeorderline);
		cafeorderline.setCafeorder(this);

		return cafeorderline;
	}

	public Cafeorderline removeCafeorderline(Cafeorderline cafeorderline) {
		getCafeorderlines().remove(cafeorderline);
		cafeorderline.setCafeorder(null);

		return cafeorderline;
	}

}
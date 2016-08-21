package pos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLog;

	private String name;

	private String pwd;

	//bi-directional many-to-one association to Cafeorder
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Cafeorder> cafeorders;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getLastLog() {
		return this.lastLog;
	}

	public void setLastLog(Date lastLog) {
		this.lastLog = lastLog;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Cafeorder> getCafeorders() {
		return this.cafeorders;
	}

	public void setCafeorders(List<Cafeorder> cafeorders) {
		this.cafeorders = cafeorders;
	}

	public Cafeorder addCafeorder(Cafeorder cafeorder) {
		getCafeorders().add(cafeorder);
		cafeorder.setUser(this);

		return cafeorder;
	}

	public Cafeorder removeCafeorder(Cafeorder cafeorder) {
		getCafeorders().remove(cafeorder);
		cafeorder.setUser(null);

		return cafeorder;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateConnection")
	private Date dateConnection;

	@Column(name="name", nullable=false, length=45)
	private String name;

	@Column(name="password", nullable=false, length=45)
	private String password;

	@Column(name ="stringConnection", length=45)
	private String stringConnection;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateConnection() {
		return this.dateConnection;
	}

	public void setDateConnection(Date dateConnection) {
		this.dateConnection = dateConnection;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStringConnection() {
		return this.stringConnection;
	}

	public void setStringConnection(String stringConnection) {
		this.stringConnection = stringConnection;
	}

}
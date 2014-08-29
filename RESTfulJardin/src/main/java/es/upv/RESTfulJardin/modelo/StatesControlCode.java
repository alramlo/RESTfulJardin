package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the states_control_code database table.
 * 
 */
@Entity
@Table(name="states_control_code")
@NamedQuery(name="StatesControlCode.findAll", query="SELECT s FROM StatesControlCode s")
public class StatesControlCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String name;

	public StatesControlCode() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
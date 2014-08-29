package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the states_control_element database table.
 * 
 */
@Entity
@Table(name="states_control_element")
@NamedQuery(name="StatesControlElement.findAll", query="SELECT s FROM StatesControlElement s")
public class StatesControlElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String name;

	public StatesControlElement() {
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
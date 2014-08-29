package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the areas database table.
 * 
 */
@Entity
@Table(name="areas")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String name;

	@JoinTable(name="areas_control_nodes")
	@ManyToMany
	private List<ControlNode> controlNodes;
	

	public Area() {
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

	public List<ControlNode> getControlNodes() {
		return controlNodes;
	}

	public void setControlNodes(List<ControlNode> controlNodes) {
		this.controlNodes = controlNodes;
	}

	

}
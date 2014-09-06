package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the areas_control_nodes database table.
 * 
 */
@Entity
@Table(name="areas_control_nodes")
@NamedQuery(name="AreasControlNode.findAll", query="SELECT a FROM AreasControlNode a")
public class AreasControlNode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="area_id",nullable=false)
	private Area area;

	@ManyToOne
	@JoinColumn(name="control_node_id",nullable=false)
	private ControlNode controlNode;

	public AreasControlNode() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public ControlNode getControlNode() {
		return controlNode;
	}

	public void setControlNode(ControlNode controlNode) {
		this.controlNode = controlNode;
	}



}
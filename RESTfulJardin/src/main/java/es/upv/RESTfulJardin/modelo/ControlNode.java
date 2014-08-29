package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the control_nodes database table.
 * 
 */
@Entity
@Table(name="control_nodes")
@NamedQuery(name="ControlNode.findAll", query="SELECT c FROM ControlNode c")
public class ControlNode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String ip;

	@Column(length=45)
	private String model;

	@Column(length=45)
	private String serial;

	@JoinTable(name="areas_control_nodes")
	@ManyToMany
	private List<Area> areas;

	public ControlNode() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

}
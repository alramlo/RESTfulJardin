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
	private Integer id;

	@Column(length=45)
	private String ip;

	@Column(length=45)
	private String model;

	@Column(length=45)
	private String serial;


	public ControlNode() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

}
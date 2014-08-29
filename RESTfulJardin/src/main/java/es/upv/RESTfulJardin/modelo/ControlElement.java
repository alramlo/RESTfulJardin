package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the control_elements database table.
 * 
 */
@Entity
@Table(name="control_elements")
@NamedQuery(name="ControlElement.findAll", query="SELECT c FROM ControlElement c")
public class ControlElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String model;

	@Column(nullable=false, length=45)
	private String name;

	@Column(length=45)
	private String serial;

	//uni-directional many-to-one association to ControlNode
	@ManyToOne
	@JoinColumn(name="control_node", nullable=false)
	private ControlNode controlNodeBean;

	//uni-directional many-to-one association to StatesControlElement
	@ManyToOne
	@JoinColumn(name="state", nullable=false)
	private StatesControlElement statesControlElement;

	//uni-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private Type typeBean;

	public ControlElement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public ControlNode getControlNodeBean() {
		return this.controlNodeBean;
	}

	public void setControlNodeBean(ControlNode controlNodeBean) {
		this.controlNodeBean = controlNodeBean;
	}

	public StatesControlElement getStatesControlElement() {
		return this.statesControlElement;
	}

	public void setStatesControlElement(StatesControlElement statesControlElement) {
		this.statesControlElement = statesControlElement;
	}

	public Type getTypeBean() {
		return this.typeBean;
	}

	public void setTypeBean(Type typeBean) {
		this.typeBean = typeBean;
	}

}
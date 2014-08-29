package es.upv.RESTfulJardin.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the control_codes database table.
 * 
 */
@Entity
@Table(name="control_codes")
@NamedQuery(name="ControlCode.findAll", query="SELECT c FROM ControlCode c")
public class ControlCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String name;

	//uni-directional many-to-one association to ControlNode
	@ManyToOne
	@JoinColumn(name="Control_Node", nullable=false)
	private ControlNode controlNode;

	//uni-directional many-to-one association to StatesControlCode
	@ManyToOne
	@JoinColumn(name="state", nullable=false)
	private StatesControlCode statesControlCode;

	public ControlCode() {
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

	public ControlNode getControlNode() {
		return this.controlNode;
	}

	public void setControlNode(ControlNode controlNode) {
		this.controlNode = controlNode;
	}

	public StatesControlCode getStatesControlCode() {
		return this.statesControlCode;
	}

	public void setStatesControlCode(StatesControlCode statesControlCode) {
		this.statesControlCode = statesControlCode;
	}

}
package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Vyshali Prabananth Lal
 *
 */
/**
 * Entity implementation class for Entity: Treatment
 *
 */
/*
 * TODO
 */

@Entity
@Table
@DiscriminatorColumn(name="TREATMENT_TYPE_DISC")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Treatment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * TODO
	 */
	@Id
	@GeneratedValue
	private long id;
	
	private String diagnosis;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/*
	 * TODO discriminator column
	 */
	/* (Optional) The column length. (Applies only if a string-valued column is used.) */
	@Column(name = "TREATMENT_TYPE_DISC", length=2)
	private String treatmentType;
	
	public String getTreatmentType() {
		return treatmentType;
	}

	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/*
	 * TODO
	 */
	@ManyToOne
	@JoinColumn(nullable=false)
	private Patient patient;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
		// More logic in the domain model.
	}
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Provider provider;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public Treatment() {
		super();
	}
   
}


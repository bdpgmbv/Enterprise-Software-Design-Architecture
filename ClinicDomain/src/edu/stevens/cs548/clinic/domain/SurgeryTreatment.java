package edu.stevens.cs548.clinic.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vyshali Prabananth Lal
 *
 */
//TODO
@Entity
@DiscriminatorValue("SU")
public class SurgeryTreatment extends Treatment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4173146640306267418L;
	
	// TODO
	/*
	 * @Temporal  annotation must be specified for persistent fields or properties of type java.util.Date and java.util.Calendar
	 * In JPA, @Temporal annotation solves the one of the major issue of converting the date and time values from Java object to compatible database type and retrieving back to the application.
	 * The mapping between the Java 8 Date/Time classes and the SQL types is implicit, there is not need to specify the @Temporal annotation.
	 */
	@Temporal(TemporalType.DATE)
	private Date surgeryDate;

	public Date getSurgeryDate() {
		return surgeryDate;
	}

	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}
	
	public SurgeryTreatment() {
		super();
		this.setTreatmentType("SU");
	}

}


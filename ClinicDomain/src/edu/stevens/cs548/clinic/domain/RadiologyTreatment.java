package edu.stevens.cs548.clinic.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vyshali Prabananth Lal
 *
 */
//TODO
@Entity
@DiscriminatorValue("RA")
public class RadiologyTreatment extends Treatment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3656673416179492428L;

	// TODO JPA annotation
	/*
	 * @Temporal  annotation must be specified for persistent fields or properties of type java.util.Date and java.util.Calendar
	 * In JPA, @Temporal annotation solves the one of the major issue of converting the date and time values from Java object to compatible database type and retrieving back to the application.
	 * The mapping between the Java 8 Date/Time classes and the SQL types is implicit, there is not need to specify the @Temporal annotation.
	 */
	@ElementCollection
	@Temporal(TemporalType.DATE)
	protected Collection<Date> treatmentDates;

	public Collection<Date> getTreatmentDates() {
		return treatmentDates;
	}

	public void setTreatmentDates(Collection<Date> treatmentDates) {
		this.treatmentDates = treatmentDates;
	}
	
	public RadiologyTreatment() {
		super();
		this.setTreatmentType("RA");
	}
	
}

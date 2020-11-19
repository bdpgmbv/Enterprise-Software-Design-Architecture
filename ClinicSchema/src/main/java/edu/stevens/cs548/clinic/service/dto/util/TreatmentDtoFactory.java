package edu.stevens.cs548.clinic.service.dto.util;

import edu.stevens.cs548.clinic.service.dto.DrugTreatmentType;
import edu.stevens.cs548.clinic.service.dto.ObjectFactory;
import edu.stevens.cs548.clinic.service.dto.RadiologyTreatmentType;
import edu.stevens.cs548.clinic.service.dto.SurgeryTreatmentType;
import edu.stevens.cs548.clinic.service.dto.TreatmentDto;

public class TreatmentDtoFactory {
	
	ObjectFactory factory;
	
	public TreatmentDtoFactory() {
		factory = new ObjectFactory();
	}
	
	public TreatmentDto createDrugTreatmentDto () {
		// TODO
		TreatmentDto t = factory.createTreatmentDto();
		DrugTreatmentType dt = factory.createDrugTreatmentType();
		t.setDrugTreatment(dt);
		return t;
	}
	
	public TreatmentDto createSurgeryTreatmentDto () {
		TreatmentDto t = factory.createTreatmentDto();
		SurgeryTreatmentType st = factory.createSurgeryTreatmentType();
		t.setSurgeryTreatment(st);
		return t;
	}
	
	public TreatmentDto createRadiologyTreatmentDto () {
		TreatmentDto t = factory.createTreatmentDto();
		RadiologyTreatmentType rt = factory.createRadiologyTreatmentType();
		t.setRadiologyTreatment(rt);
		return t;
	}
	/*
	 * TODO: Repeat for other treatments.
	 */

}

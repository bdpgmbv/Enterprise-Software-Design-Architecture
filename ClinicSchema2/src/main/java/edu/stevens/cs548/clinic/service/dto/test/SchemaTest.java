package edu.stevens.cs548.clinic.service.dto.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.stevens.cs548.clinic.service.dto.DrugTreatmentType;
import edu.stevens.cs548.clinic.service.dto.PatientDto;
import edu.stevens.cs548.clinic.service.dto.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.ProviderSpecType;
import edu.stevens.cs548.clinic.service.dto.RadiologyTreatmentType;
import edu.stevens.cs548.clinic.service.dto.SurgeryTreatmentType;
import edu.stevens.cs548.clinic.service.dto.util.DateAdapter;
import edu.stevens.cs548.clinic.service.dto.util.PatientDtoFactory;
import edu.stevens.cs548.clinic.service.dto.util.ProviderDtoFactory;
import edu.stevens.cs548.clinic.service.dto.util.TreatmentDtoFactory;

public class SchemaTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("** Testing with element substitution start");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("** Testing with element substitution end");
	}

	@Test
	public void test() {
		PatientDtoFactory patientFactory = new PatientDtoFactory();
		ProviderDtoFactory providerFactory = new ProviderDtoFactory();
		TreatmentDtoFactory treatmentFactory = new TreatmentDtoFactory();

	    try {
		    JAXBContext context = JAXBContext.newInstance("edu.stevens.cs548.clinic.service.dto");
		    Marshaller marshaller = context.createMarshaller();
		    marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);

		    PatientDto patient = patientFactory.createPatientDto();
		    // TODO fill in the fields

		    patient.setId(1);
		    patient.setName("JohnPatient");
		    patient.setPatientId(1000);
		    
		    System.out.println();
			marshaller.marshal(patient,System.out);

		    ProviderDto provider = providerFactory.createProviderDto();
		    // TODO fill in the fields
		    
		    provider.setId(1);
		    provider.setName("JoeProvider");
		    provider.setNpi("1000npi");
		    provider.setProviderSpec(ProviderSpecType.SURGERY);
		    
		    System.out.println();
			marshaller.marshal(provider,System.out);
			
			DrugTreatmentType drugTreatmentType = treatmentFactory.createDrugTreatmentType();
			JAXBElement<DrugTreatmentType> drugTreatment = treatmentFactory.createDrugTreatmentDto(drugTreatmentType);
		    // TODO fill in the fields

			drugTreatmentType.setId(1);
			drugTreatmentType.setPatient(patient.getId());
			drugTreatmentType.setProvider(provider.getId());
			drugTreatmentType.setDiagnosis("Drug Treatment");
			drugTreatmentType.setDosage(10);
			drugTreatmentType.setDrug("P150Drug");
			
		    System.out.println();
			marshaller.marshal(drugTreatment,System.out);
			
			SurgeryTreatmentType surgeryTreatmentType = treatmentFactory.createSurgeryTreatmentType();
			JAXBElement<SurgeryTreatmentType> surgeryTreatment = treatmentFactory.createSurgeryTreatmentDto(surgeryTreatmentType);
		    // TODO fill in the fields

			surgeryTreatmentType.setId(1);
			surgeryTreatmentType.setPatient(patient.getId());
			surgeryTreatmentType.setProvider(provider.getId());
			surgeryTreatmentType.setDiagnosis("Surgery Treatment");
			surgeryTreatmentType.setDateOfSurgery(DateAdapter.parseDate("2013-12-13"));
		    
			System.out.println();
			marshaller.marshal(surgeryTreatment,System.out);
			
			
			RadiologyTreatmentType radiologyTreatmentType = treatmentFactory.createRadiologyTreatmentType();
			JAXBElement<RadiologyTreatmentType> radiologyTreatment = treatmentFactory.createRadiologyTreatmentDto(radiologyTreatmentType);
		    // TODO fill in the fields

			radiologyTreatmentType.setId(1);
			radiologyTreatmentType.setPatient(patient.getId());
			radiologyTreatmentType.setProvider(provider.getId());
			radiologyTreatmentType.setDiagnosis("Radiology Treatment");
			radiologyTreatmentType.getRadiologyTreatmentDates().add(DateAdapter.parseDate("2012-01-03"));
			radiologyTreatmentType.getRadiologyTreatmentDates().add(DateAdapter.parseDate("2012-02-07"));
		    
			System.out.println();
			marshaller.marshal(radiologyTreatment,System.out);
			
			// TODO create different forms of treatment objects and print them

	    } catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

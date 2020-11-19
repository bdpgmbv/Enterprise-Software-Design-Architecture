package edu.stevens.cs548.clinic.service.dto.test;

import javax.xml.bind.JAXBContext;
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
import edu.stevens.cs548.clinic.service.dto.TreatmentDto;
import edu.stevens.cs548.clinic.service.dto.util.DateAdapter;
import edu.stevens.cs548.clinic.service.dto.util.PatientDtoFactory;
import edu.stevens.cs548.clinic.service.dto.util.ProviderDtoFactory;
import edu.stevens.cs548.clinic.service.dto.util.TreatmentDtoFactory;

public class SchemaTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("** Testing with choice element start");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("** Testing with choice element end");
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
			provider.setName("JackProvider");
			provider.setNpi("npi1000");
			provider.setProviderSpec(ProviderSpecType.SURGERY);
		    
		    System.out.println();
			marshaller.marshal(provider,System.out);
			
			// TODO create different forms of treatment objects and print them
			TreatmentDto treatment = treatmentFactory.createDrugTreatmentDto();

			treatment.setId(1000);
			treatment.setPatient(patient.getId());
			treatment.setProvider(provider.getId());
			treatment.setDiagnosis("Drug theraphy");

			DrugTreatmentType drugTreatment = new DrugTreatmentType();
			drugTreatment.setDrug("P750drug");
			drugTreatment.setDosage(10);

			treatment.setDrugTreatment(drugTreatment);

			System.out.println();
			marshaller.marshal(treatment,System.out);
		
			
			TreatmentDto treatmentSurg = treatmentFactory.createSurgeryTreatmentDto();

			treatmentSurg.setId(1001);
			treatmentSurg.setPatient(patient.getId());
			treatmentSurg.setProvider(provider.getId());
			treatmentSurg.setDiagnosis("Surgery Treatment");

			SurgeryTreatmentType surgeryTreatment = new SurgeryTreatmentType();
			surgeryTreatment.setDateOfSurgery(DateAdapter.parseDate("2010-10-10"));

			treatmentSurg.setSurgeryTreatment(surgeryTreatment);

			System.out.println();
			marshaller.marshal(treatmentSurg,System.out);
			
			
			TreatmentDto treatmentRadio = treatmentFactory.createRadiologyTreatmentDto();
			
			treatmentRadio.setId(1002);
			treatmentRadio.setPatient(patient.getId());
			treatmentRadio.setProvider(provider.getId());
			treatmentRadio.setDiagnosis("Radiology Treatment");
			
			RadiologyTreatmentType radiologyTreatment = new RadiologyTreatmentType();
			radiologyTreatment.getRadiologyTreatmentDates().add(DateAdapter.parseDate("2012-12-12"));
			radiologyTreatment.getRadiologyTreatmentDates().add(DateAdapter.parseDate("2007-02-12"));
			
			treatmentRadio.setRadiologyTreatment(radiologyTreatment);
			
			System.out.println();
			marshaller.marshal(treatmentRadio,System.out);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

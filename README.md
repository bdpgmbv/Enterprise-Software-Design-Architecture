Health Care System comprises:
* A clinic database consists of a collection of patient records, one for each patient. Each patient has: 1. a patient identifier (that may be assigned for example by a national government), 2. a patient name. (Furthermore each patient is related by a one-to-many relationship to a collection of treatment records.)
* Every treatment record includes a diagnosis of the condition for which the treatment is prescribed (e.g. throat cancer, HIV/AIDS, hepatitis, etc). 
Currently there are three specific forms of treatment records: 1. A drug treatment record includes a drug and a dosage. 2. A surgery treatment record includes a date of surgery. 3. A radiology treatment record includes a list of dates of radiology treatments. (The diagnosis, patient and provider administering the treatment can be common fields for all types of treatment records. Patients and providers are identified by their database identifiers.)
* Every healthcare provider has a record that includes their provider identifier (NPI), their name, and an indication of their specialization (surgery, radiology, oncology, etc). Each provider may be related to several treatment instances. We will represent the patient treatment and provider-treatment relationships using foreign keys.



Phase 1: Data Modeling 
* Created a JAXB Maven Project. 
* Used "maven-jaxb2-plugin" 
```
Quick Info:
The most advanced and feature-full Maven plugin for XML Schema compilation. 
This Maven plugin wraps and enhances the JAXB Schema Compiler (XJC) and allows compiling XML Schemas 
(as well as WSDL, DTDs, RELAX NG) into Java classes in Maven builds.
```
* Added the Plugin to the pom.xml file.
* Under src/main/resources created Schema.xsd, Schema.xjb, jaxb.properties, DateAdapter.xsd files.
* Schema.xsd - Defines the XML Schema for these Entity Types. 
* Schema.xjb - Using external binding customization file that enables us to customize JAXB bindings.
```
<?xml version="1.0" encoding="UTF-8"?>
<bindings xmlns="http://java.sun.com/xml/ns/jaxb" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xjc="http://java.sun.com/xml/ns/jaxb/xjc"
	version="2.1" schemaLocation="Schema.xsd" node="/xs:schema">

	<schemaBindings>
		<package name="edu.stevens.cs548.clinic.service.dto" />
	</schemaBindings>

	<globalBindings>
	    <serializable uid="1" />
		<javaType name="java.util.Date" xmlType="xs:date"
			parseMethod="edu.stevens.cs548.clinic.service.dto.util.DateAdapter.parseDate"
			printMethod="edu.stevens.cs548.clinic.service.dto.util.DateAdapter.printDate" />
	</globalBindings>

</bindings>
```
Hint - Binding customization files should be straight ASCII text. The name or extension does not matter, although a typical extension, is.xjb.
```
Customizations to the default JAXB bindings are made in the form of binding declarations passed to the JAXB binding compiler. These binding declarations can be made in either of two ways:

As inline annotations in a source XML schema
As declarations in an external binding customizations file
```



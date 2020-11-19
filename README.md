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
* Schema.xjb - The default bindings generated by the JAXB binding compiler will be sufficient to meet our needs. There are cases, however, in which we may want to modify the default bindings. We are using external binding customization file that enables us to customize JAXB bindings. Here we override the specified default binding of XML Schema built-in datatype to Java datatype for **Date**.  **We are using an alternative Java class that can represent additional characteristics of the built-in XML Schema datatype for Date.**

```
Schema.xjb
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
```
Quick Info on Schema.xjb:

Binding Customization File Format: Binding customization files should be straight ASCII text. The name or extension does not matter, although a typical extension, is.xjb.

The binding customization file must begin with the jxb:bindings version attribute, plus attributes for the JAXB and XMLSchema namespaces:
<jxb:bindings version="1.0"
  xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
  xmlns:xs="http://www.w3.org/2001/XMLSchema">

The remote schema to which the binding declaration applies must be identified explicitly in XPath notation by means of a jxb:bindings declaration specifying schemaLocation and node attributes:
schemaLocation - URI reference to the remote schema
node - XPath 1.0 expression that identifies the schema node within schemaLocation to which the given binding declaration is associated; in the case of the initial jxb:bindings declaration in the binding customization file, this node is typically "/xs:schema"

Schema scope customizations are declared with <schemaBindings>. 

Global scope customizations are declared with <globalBindings>. 

<javaType> Binding Declarations:
The <javaType> declaration provides a way to customize the translation of XML datatypes to and from Java datatypes. XML provides more datatypes than Java, and so the <javaType> declaration lets us specify custom datatype bindings when the default JAXB binding cannot sufficiently represent your schema.
The target Java datatype can be a Java built-in datatype or an application-specific Java datatype. If an application-specific datatype is used as the target, our implementation must also provide parse and print methods for unmarshalling and marshalling data. To this end, the JAXB specification supports a parseMethod and printMethod:
The parseMethod is called during unmarshalling to convert a string from the input document into a value of the target Java datatype.
The printMethod is called during marshalling to convert a value of the target type into a lexical representation.
If we prefer to define your own datatype conversions, JAXB defines a static class, DatatypeConverter, to assist in the parsing and printing of valid lexical representations of the XML Schema built-in datatypes.
The syntax for the <javaType> customization is:
<javaType name= "javaType"
      [ xmlType= "xmlType" ]
      [ hasNsContext = "true" | "false" ]
      [ parseMethod= "parseMethod" ]
      [ printMethod= "printMethod" ]> 
name is the Java datatype to which xmlType is to be bound.
xmlType is the name of the XML Schema datatype to which javaType is to bound; this attribute is required when the parent of the <javaType> declaration is <globalBindings>.
parseMethod is the name of the parse method to be called during unmarshalling.
printMethod is the name of the print method to be called during marshalling.
hasNsContext allows a namespace context to be specified as a second parameter to a print or a parse method; can be either true, false, 1, or 0. By default, this attribute is false, and in most cases you will not need to change it.

The <javaType> declaration can be used in:
A <globalBindings> declaration
An annotation element for simple type definitions, GlobalBindings, and <basetype> declarations.
A <property> declaration.

```
[Guide for Customizing JAXB Bindings](https://docs.oracle.com/cd/E17802_01/webservices/webservices/docs/1.6/tutorial/doc/JAXBUsing4.html#wp148613)


package ru.pel.tests.multicartatest.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

//@Service
public class XmlValidatorAgainstXsd {
    public boolean validate(BufferedReader input, File xsd) throws SAXException, IOException, XMLStreamException {
        StAXSource source;
        FileInputStream inputStream;
//        boolean isInputValid;

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsd);
            Validator validator = schema.newValidator();
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
//            inputStream = new FileInputStream(input);
//            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);

            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(input);
            source = new StAXSource(xmlStreamReader);
            validator.validate(source);
//            isInputValid=true;
        return true;
    }
}

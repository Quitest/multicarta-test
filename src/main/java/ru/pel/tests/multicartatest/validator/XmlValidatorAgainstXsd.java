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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XmlValidatorAgainstXsd {
    public boolean validate(InputStream input, File xsd) throws SAXException, IOException, XMLStreamException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(xsd);
        Validator validator = schema.newValidator();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();

        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(input);
        StAXSource source = new StAXSource(xmlStreamReader);
        validator.validate(source);
        return true;
    }
}

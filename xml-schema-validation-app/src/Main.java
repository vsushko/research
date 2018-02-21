import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Validator;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class Main {

    public static void main(String[] args) {
        /*
        Calendar calendar = new GregorianCalendar();

        Person person = new Person();
        person.setName("Name1");
        person.setLastName("LastName1");
        person.setAge(23);
        person.setDate(new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));

        try {
            File file = new File("jaxb.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // Форматированый вывод
            jaxbMarshaller.marshal(person, file);
            jaxbMarshaller.marshal(person, System.out);

        } catch (JAXBException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        try
        {
            File file = new File("jaxb.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person person1 = (Person)jaxbUnmarshaller.unmarshal(file);

            System.out.print("Customer: " + person1.getName() +
                    "(name='" + person1.getName() +
                    ",lastname='" + person1.getName() +
                    "',age='" + person1.getAge() +
                    ",date='" + person1.getDate() +
                    "')");
        }
        catch (JAXBException jaxbe)
        {
            System.out.println(jaxbe.getLocalizedMessage());
            jaxbe.printStackTrace();
        }
        */
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource("personschema.xsd"));
            Validator validator = (Validator) schema.newValidator();
            validator.validate(new StreamSource("jaxb.xml"));
            System.out.println("Validate is complete...");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

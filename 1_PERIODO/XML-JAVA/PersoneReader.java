import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersoneReader extends DefaultHandler{
    private String PersonName;
    private int PersonAge;
    private String PersonSex;
    private int AgeSum;
    private int PeopleAmount;
    private static ArrayList<Person> People = new ArrayList<>();
    private String s;

    public PersoneReader(String f){
        // TODO Auto-generated method stub
        try{
            SAXParserFactory ParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = ParserFactory.newSAXParser();

            parser.parse(new File(f), this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @return the people
     */
    public ArrayList<Person> getPeople() {
        return People;
    }

    @Override
    public void startDocument(){
        // TODO Auto-generated method stub
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        if(qName.equals("persona")) {PeopleAmount++;
            PersonSex = attributes.getValue("sesso");
            PersonAge = Integer.parseInt(attributes.getValue("eta"));
            AgeSum += PersonAge;
        }

        if(qName.equals("nome"))
            PersonName = s;
        


        if(qName.equals("cognome")) 
            PersonName += s;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO Auto-generated method stub
        PersonName=new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO Auto-generated method stub
        Person p = new Person(PersonName, PersonAge, PersonSex);
        //I add it to the ArrayList
        People.add(p);

        //when endDocument() method is called I print all the people I've found in the file
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("the average age of these people is " + (int) PeopleAmount/AgeSum);
    }




    public static void main(String[] args) {
        PersoneReader reader = new PersoneReader("Z:\\INFO\\1° PERIODO\\XML-JAVA\\Persone.xml");

        for(int i = 0; i<People.size(); i++){
            System.out.print(People.get(i));
            System.out.println();
        }
    }
}

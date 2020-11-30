package hu.domparse.wwsamb;
//a szükséges library-k a project-hez
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyWwsamb {

	public static void main(String[] args) {

	       try {

		  //útvonal megadásával meghatároztam az XML dokumentum helyét
	        String filepath = "D:\\XMLFeladatWwsamb\\XMLWwsamb.xml";
		  //dokumentum olvasó létrehozása
	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	        Document doc = docBuilder.parse(filepath);

	        // a megadott nevû elemet összeszedi a fából
		  //a dolgozók element 2. elemét (0-ról kezdõdik a számozás)
	        Node elem = doc.getElementsByTagName("dolgozók").item(1);	 

		  //a dolgozók elem második elemének a gyerekeit szedi ki      
	        NodeList list = elem.getChildNodes();

		  //gyerekelemek ellenõrzése
	        for (int i = 0; i < list.getLength(); i++) {
	            //vizsgált elem mint node
	           	Node node = list.item(i);


			//ha a keresett elem megegyezik az „Utca”-val
	          	if ("Utca".equals(node.getNodeName())) {

			//akkor az értékét megváltoztatja (Napsugaras utcára)
	            node.setTextContent("Napsugaras utca");
	            
	            //kiírja az aktuális node-ot (dolgozók)
	            System.out.println(elem.getNodeName() + ": " +
elem.getTextContent() );
			//valamint a benne lévõ minden elem tartalmát, hogy 
//lássuk, hogy tényleg megtörtént a módosítás
	            
	           }
	           
	        }

		  //az új tartalom beírása az XML file-ba is
	        TransformerFactory transformerFactory =
TransformerFactory.newInstance();

	        Transformer transformer =transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File(filepath));
	        transformer.transform(source, result);
	        
		  //visszajelzés, hogy sikeresen beírta
	        System.out.println("Done");
	       
	       } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	       } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	       } catch (IOException ioe) {
	        ioe.printStackTrace();
	       } catch (SAXException sae) {
	        sae.printStackTrace();
	       }    
}
}

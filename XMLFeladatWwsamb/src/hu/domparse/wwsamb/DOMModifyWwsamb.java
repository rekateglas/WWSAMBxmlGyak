package hu.domparse.wwsamb;
//a sz�ks�ges library-k a project-hez
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

		  //�tvonal megad�s�val meghat�roztam az XML dokumentum hely�t
	        String filepath = "D:\\XMLFeladatWwsamb\\XMLWwsamb.xml";
		  //dokumentum olvas� l�trehoz�sa
	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	        Document doc = docBuilder.parse(filepath);

	        // a megadott nev� elemet �sszeszedi a f�b�l
		  //a dolgoz�k element 2. elem�t (0-r�l kezd�dik a sz�moz�s)
	        Node elem = doc.getElementsByTagName("dolgoz�k").item(1);	 

		  //a dolgoz�k elem m�sodik elem�nek a gyerekeit szedi ki      
	        NodeList list = elem.getChildNodes();

		  //gyerekelemek ellen�rz�se
	        for (int i = 0; i < list.getLength(); i++) {
	            //vizsg�lt elem mint node
	           	Node node = list.item(i);


			//ha a keresett elem megegyezik az �Utca�-val
	          	if ("Utca".equals(node.getNodeName())) {

			//akkor az �rt�k�t megv�ltoztatja (Napsugaras utc�ra)
	            node.setTextContent("Napsugaras utca");
	            
	            //ki�rja az aktu�lis node-ot (dolgoz�k)
	            System.out.println(elem.getNodeName() + ": " +
elem.getTextContent() );
			//valamint a benne l�v� minden elem tartalm�t, hogy 
//l�ssuk, hogy t�nyleg megt�rt�nt a m�dos�t�s
	            
	           }
	           
	        }

		  //az �j tartalom be�r�sa az XML file-ba is
	        TransformerFactory transformerFactory =
TransformerFactory.newInstance();

	        Transformer transformer =transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File(filepath));
	        transformer.transform(source, result);
	        
		  //visszajelz�s, hogy sikeresen be�rta
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

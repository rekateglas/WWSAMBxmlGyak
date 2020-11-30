package hu.domparse.wwsamb;
//a sz�ks�ges library-k a project-hez
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReadWwsamb {

	public static void main(String[] args) {

		//dokumentum olvas� l�trehoz�sa
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		
		//t�mbben t�roltam el az element-ek neveit
		String[] b = { "besztel", "besz�ll�t�k", "boltok", "dolgoz�k", "kateg�ri�k", "�ru", "NM_kapcsolat" };

		
		//az olvas�s kiv�telt dobhat, try-catch blokkra van sz�ks�g
		try {

			
		//�tvonal megad�s�val meghat�roztam az XML dokumentum hely�t
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("D:\\XMLFeladatWwsamb\\XMLWwsamb.xml"));

			document.getDocumentElement().normalize();
			
			//gy�k�r elem be�ll�t�sa
			Element rootNode = document.getDocumentElement();
			System.out.println("Gy�k�r elem neve: " +
rootNode.getNodeName());
			
		//ciklus a lista elemeire
for (int i = 0; i < b.length; i++) {
			NodeList nodeList =
document.getElementsByTagName(b[i]);
System.out.println("***************************************");

			//ciklus az aktu�lis elemek ki�rat�s�ra
	for (int j = 0; j < nodeList.getLength(); j++) {
				
		//aktu�lis elem nev�nek ki�rat�sa
Node actualNode = nodeList.item(j);
		System.out.println("Jelenlegi elem: " +
actualNode.getNodeName());

	//a gyerekelemek �s tartalmuk ki�r�sa az aktu�lis elemhez
		if (b[i].equals("besztel") == true) {
			Element actualElement = (Element) actualNode;

System.out.println("Besz�ll�t� Telefonsz�m: "+
actualElement.
getElementsByTagName("BeszTelSzam")
.item(0)
.getTextContent());

			System.out.println("Besz�ll�t� ID: "+
actualElement.
getElementsByTagName("idBesz�ll�t�")
.item(0)
.getTextContent());

			System.out.println();		
} 

	//a gyerekelemek �s tartalmuk ki�r�sa az aktu�lis elemhez
else if (b[i].equals("besz�ll�t�k") == true) {
			Element actualElement = (Element) actualNode;

System.out.println("Besz�ll�t� ID: " +
actualElement.getAttribute("beszid"));

			System.out.println("Besz�ll�t� ID: "+
actualElement.
getElementsByTagName("idBesz�ll�t�")
.item(0)
.getTextContent());

			System.out.println("Besz�ll�t� Neve: "+
actualElement.
getElementsByTagName("besz�ll�t�_neve")
.item(0)
.getTextContent());

			System.out.println();		
} 
	//a gyerekelemek �s tartalmuk ki�r�sa az aktu�lis elemhez
else if (b[i].equals("boltok") == true) {
			Element actualElement = (Element) actualNode;

			System.out.println("Bolt helye: " +
actualElement.
getElementsByTagName("helye")
.item(0)
.getTextContent());

			System.out.println("Bolt ID: " +
actualElement.
getElementsByTagName("idBolt")
.item(0)
.getTextContent());
						
System.out.println("Dolgoz�k Sz�ma: "+
actualElement.
getElementsByTagName("dolgoz�k_sz�ma")
.item(0)
.getTextContent());

			System.out.println("Utols� �rucsere D�tuma: "+
actualElement.
getElementsByTagName("�rucsere_d�tuma")
.item(0)
.getTextContent());

			System.out.println("�r� ID: "+
actualElement.
getElementsByTagName("id�ru")
.item(0)
.getTextContent());

			System.out.println();
		} 

	//a gyerekelemek �s tartalmuk ki�r�sa az aktu�lis elemhez
else if (b[i].equals("dolgoz�k") == true) {
			Element actualElement = (Element) actualNode;

			System.out.println("Bolt helye: "+
actualElement.
getElementsByTagName("idDolgoz�")
.item(0)
.getTextContent());




			System.out.println("Bolt ID: "+
actualElement.
getElementsByTagName("n�v")
.item(0)
.getTextContent());

			System.out.println("Szem�lyigazolv�ny sz�m: "+
actualElement.
getElementsByTagName("szig_sz�m")
.item(0)
.getTextContent());

			System.out.println("Munkaviszony kezdete: "+
actualElement.
getElementsByTagName("munkaviszony_kezdete")
.item(0)
.getTextContent());

			System.out.println("Utca: "+
actualElement.
getElementsByTagName("Utca")
.item(0)
.getTextContent());

			System.out.println("H�zsz�m: "+
actualElement.
getElementsByTagName("Hsz")
.item(0)
.getTextContent());

			System.out.println("Ir�ny�t�sz�m: "+
actualElement.
getElementsByTagName("Irsz")
.item(0)
.getTextContent());

			System.out.println("Bolt ID: "+
actualElement.
getElementsByTagName("idBolt")
.item(0)
.getTextContent());

			System.out.println();
		} 

	//a gyerekelemek �s tartalmuk ki�r�sa az aktu�lis elemhez
else if (b[i].equals("kateg�ri�k") == true) {
			Element actualElement = (Element) actualNode;

					
			System.out.println("Kateg�ria ID: "	+
actualElement.	getElementsByTagName("idKateg�ria")	.item(0)	.getTextContent());
						
System.out.println("Kateg�ria Neve: "+
actualElement.
getElementsByTagName("kateg�ria_neve")
.item(0)
.getTextContent());

			System.out.println("Kateg�ri�ba tartoz� term�kek sz�ma:"+
actualElement.
getElementsByTagName("kateg�ri�ba_tart_term�kek_sz�ma")
.item(0)
.getTextContent());

			System.out.println();
		} 

	//a gyerekelemek �s tartalmuk ki�r�sa az aktu�lis elemhez
else if (b[i].equals("NM_kapcsolat") == true) {
			Element actualElement = (Element) actualNode;

			System.out.println("�ru �rt�ke: "+
actualElement.
getElementsByTagName("�ru_�ssz�rt�ke")
.item(0)
.getTextContent());

			System.out.println("�ru mennyis�ge: "+
actualElement.	getElementsByTagName("�ru_mennyis�ge")
.item(0)
.getTextContent());

			System.out.println("Besz�ll�t�s ideje: "+
actualElement.	getElementsByTagName("besz�ll�t�s_ideje")	.item(0)
.getTextContent());

			System.out.println("�ru ID: "+
actualElement.
getElementsByTagName("id�ru")
.item(0)
.getTextContent());

						
System.out.println("Besz�ll�t� ID: "+
actualElement.	getElementsByTagName("idBesz�ll�t�")	.item(0)	.getTextContent());

			System.out.println();
		}

	//a gyerekelemek �s tartalmuk ki�r�sa az aktu�lis elemhez
else if (b[i].equals("�ru") == true) {
			Element actualElement = (Element) actualNode;
		
			System.out.println("�ru ID: "+
actualElement.
getElementsByTagName("id�ru")
.item(0)
.getTextContent());
				
			System.out.println("�ru n�v: "+
actualElement.	getElementsByTagName("n�v")	.item(0)
.getTextContent());

			System.out.println("Darab�r: "+
actualElement.	getElementsByTagName("Darab�r")
.item(0)
.getTextContent());

			System.out.println("Kateg�ria: "+
actualElement.	getElementsByTagName("kateg�ria")	.item(0)
.getTextContent());

			System.out.println("Kateg�ria ID: "	+	
actualElement.	getElementsByTagName("idKateg�ria")	
.item(0)
.getTextContent());

			System.out.println();
		}
		}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



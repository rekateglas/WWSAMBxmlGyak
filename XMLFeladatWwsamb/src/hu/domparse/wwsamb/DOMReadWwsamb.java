package hu.domparse.wwsamb;
//a szükséges library-k a project-hez
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReadWwsamb {

	public static void main(String[] args) {

		//dokumentum olvasó létrehozása
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		
		//tömbben tároltam el az element-ek neveit
		String[] b = { "besztel", "beszállítók", "boltok", "dolgozók", "kategóriák", "áru", "NM_kapcsolat" };

		
		//az olvasás kivételt dobhat, try-catch blokkra van szükség
		try {

			
		//útvonal megadásával meghatároztam az XML dokumentum helyét
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("D:\\XMLFeladatWwsamb\\XMLWwsamb.xml"));

			document.getDocumentElement().normalize();
			
			//gyökér elem beállítása
			Element rootNode = document.getDocumentElement();
			System.out.println("Gyökér elem neve: " +
rootNode.getNodeName());
			
		//ciklus a lista elemeire
for (int i = 0; i < b.length; i++) {
			NodeList nodeList =
document.getElementsByTagName(b[i]);
System.out.println("***************************************");

			//ciklus az aktuális elemek kiíratására
	for (int j = 0; j < nodeList.getLength(); j++) {
				
		//aktuális elem nevének kiíratása
Node actualNode = nodeList.item(j);
		System.out.println("Jelenlegi elem: " +
actualNode.getNodeName());

	//a gyerekelemek és tartalmuk kiírása az aktuális elemhez
		if (b[i].equals("besztel") == true) {
			Element actualElement = (Element) actualNode;

System.out.println("Beszállító Telefonszám: "+
actualElement.
getElementsByTagName("BeszTelSzam")
.item(0)
.getTextContent());

			System.out.println("Beszállító ID: "+
actualElement.
getElementsByTagName("idBeszállító")
.item(0)
.getTextContent());

			System.out.println();		
} 

	//a gyerekelemek és tartalmuk kiírása az aktuális elemhez
else if (b[i].equals("beszállítók") == true) {
			Element actualElement = (Element) actualNode;

System.out.println("Beszállító ID: " +
actualElement.getAttribute("beszid"));

			System.out.println("Beszállító ID: "+
actualElement.
getElementsByTagName("idBeszállító")
.item(0)
.getTextContent());

			System.out.println("Beszállító Neve: "+
actualElement.
getElementsByTagName("beszállító_neve")
.item(0)
.getTextContent());

			System.out.println();		
} 
	//a gyerekelemek és tartalmuk kiírása az aktuális elemhez
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
						
System.out.println("Dolgozók Száma: "+
actualElement.
getElementsByTagName("dolgozók_száma")
.item(0)
.getTextContent());

			System.out.println("Utolsó Árucsere Dátuma: "+
actualElement.
getElementsByTagName("árucsere_dátuma")
.item(0)
.getTextContent());

			System.out.println("Árú ID: "+
actualElement.
getElementsByTagName("idÁru")
.item(0)
.getTextContent());

			System.out.println();
		} 

	//a gyerekelemek és tartalmuk kiírása az aktuális elemhez
else if (b[i].equals("dolgozók") == true) {
			Element actualElement = (Element) actualNode;

			System.out.println("Bolt helye: "+
actualElement.
getElementsByTagName("idDolgozó")
.item(0)
.getTextContent());




			System.out.println("Bolt ID: "+
actualElement.
getElementsByTagName("név")
.item(0)
.getTextContent());

			System.out.println("Személyigazolvány szám: "+
actualElement.
getElementsByTagName("szig_szám")
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

			System.out.println("Házszám: "+
actualElement.
getElementsByTagName("Hsz")
.item(0)
.getTextContent());

			System.out.println("Irányítószám: "+
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

	//a gyerekelemek és tartalmuk kiírása az aktuális elemhez
else if (b[i].equals("kategóriák") == true) {
			Element actualElement = (Element) actualNode;

					
			System.out.println("Kategória ID: "	+
actualElement.	getElementsByTagName("idKategória")	.item(0)	.getTextContent());
						
System.out.println("Kategória Neve: "+
actualElement.
getElementsByTagName("kategória_neve")
.item(0)
.getTextContent());

			System.out.println("Kategóriába tartozó termékek száma:"+
actualElement.
getElementsByTagName("kategóriába_tart_termékek_száma")
.item(0)
.getTextContent());

			System.out.println();
		} 

	//a gyerekelemek és tartalmuk kiírása az aktuális elemhez
else if (b[i].equals("NM_kapcsolat") == true) {
			Element actualElement = (Element) actualNode;

			System.out.println("Áru értéke: "+
actualElement.
getElementsByTagName("áru_összértéke")
.item(0)
.getTextContent());

			System.out.println("Áru mennyisége: "+
actualElement.	getElementsByTagName("áru_mennyisége")
.item(0)
.getTextContent());

			System.out.println("Beszállítás ideje: "+
actualElement.	getElementsByTagName("beszállítás_ideje")	.item(0)
.getTextContent());

			System.out.println("Áru ID: "+
actualElement.
getElementsByTagName("idÁru")
.item(0)
.getTextContent());

						
System.out.println("Beszállító ID: "+
actualElement.	getElementsByTagName("idBeszállító")	.item(0)	.getTextContent());

			System.out.println();
		}

	//a gyerekelemek és tartalmuk kiírása az aktuális elemhez
else if (b[i].equals("áru") == true) {
			Element actualElement = (Element) actualNode;
		
			System.out.println("Áru ID: "+
actualElement.
getElementsByTagName("idÁru")
.item(0)
.getTextContent());
				
			System.out.println("Áru név: "+
actualElement.	getElementsByTagName("név")	.item(0)
.getTextContent());

			System.out.println("Darabár: "+
actualElement.	getElementsByTagName("Darabár")
.item(0)
.getTextContent());

			System.out.println("Kategória: "+
actualElement.	getElementsByTagName("kategória")	.item(0)
.getTextContent());

			System.out.println("Kategória ID: "	+	
actualElement.	getElementsByTagName("idKategória")	
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



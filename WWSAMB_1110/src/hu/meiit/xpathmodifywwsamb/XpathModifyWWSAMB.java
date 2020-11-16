package hu.meiit.xpathmodifywwsamb;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XpathModifyWWSAMB {

	public static void main(String[] args)
	{
		try
		{
			File file = new File("D:\\TR_WWSAMB\\xml\\WWSAMB_1110\\studentWWSAMB.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			document.getDocumentElement().normalize();
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/class/student[@rollno='393']";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			Node node = nodeList.item(0);
			System.out.println("Current Element: " + node.getNodeName());

			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;

				element.getElementsByTagName("lastname").item(0).setTextContent("Z�ld");
				
				System.out.println("Student roll no: " + element.getAttribute("rollno"));
				System.out.println("First Name: " + element.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name: " + element.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Nick Name: " + element.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("Marks: " + element.getElementsByTagName("marks").item(0).getTextContent());
			}

			System.out.println();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

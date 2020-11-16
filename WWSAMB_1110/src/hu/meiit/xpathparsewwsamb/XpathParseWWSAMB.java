package hu.meiit.xpathparsewwsamb;

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

public class XpathParseWWSAMB {

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
			String expression = "/class/student";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++)
			{
				Node actualNode = nodeList.item(i);
				System.out.println("Current Element: " + actualNode.getNodeName());

				if (actualNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element actualElement = (Element) actualNode;

					System.out.println("Student roll no: " + actualElement.getAttribute("rollno"));
					System.out.println("First Name: " + actualElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name: " + actualElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name: " + actualElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Marks: " + actualElement.getElementsByTagName("marks").item(0).getTextContent());
				}

				System.out.println();
			}
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

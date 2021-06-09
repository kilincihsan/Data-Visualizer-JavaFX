package sample;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DomParser {
    public static String[][] parseFile() throws ParserConfigurationException, IOException, SAXException {
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //document builder
        Document document = builder.parse(new File(Controller.getFilePath()));

        //normalize
        document.getDocumentElement().normalize();

        //root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //records
        NodeList nList = document.getElementsByTagName("record");

        //parsedData
        String[][] parsedData = new String[10000][10000];

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node node = nList.item(i);
            for(int j=0; j<5;j++){
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    //System.out.println(eElement.getElementsByTagName("field").item(j).getTextContent());
                    parsedData[i][j]=eElement.getElementsByTagName("field").item(j).getTextContent();


                    //to see the elements
                    //System.out.println(parsedData[i][j]);

                    //System.out.println("Name : " + eElement.getElementsByTagName("field").item(0).getTextContent());
                    //System.out.println("Country : " + eElement.getElementsByTagName("field").item(1).getTextContent());
                    //System.out.println("Year : " + eElement.getElementsByTagName("field").item(2).getTextContent());
                    //System.out.println("Value : " + eElement.getElementsByTagName("field").item(3).getTextContent());
                    //System.out.println("Continent : " + eElement.getElementsByTagName("field").item(4).getTextContent());
                }
            }
        }
        return parsedData;
    }
}

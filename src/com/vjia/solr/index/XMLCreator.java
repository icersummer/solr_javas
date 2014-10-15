package com.vjia.solr.index;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// http://www.w3schools.com/dom/dom_nodes_create.asp
public class XMLCreator {

	Logger log = Logger.getLogger(XMLCreator.class);

	String xmlFileFolder = "F:\\gitrepo\\solr_javas\\XML_files\\";

	// result: index 0: created or not; index 1: created xml path
	public Object[] createXML(String fileName, String fileContent) {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			log.info("xmlFilePath=" + xmlFileFolder + fileName+".xml");
//			System.out.println("xmlFilePath=" + xmlFileFolder + fileName);
			// OutputStream os = new FileOutputStream(xmlFileFolder + fileName);
			Document doc = builder.newDocument();
			Element root = doc.createElement("Java_Files");
			doc.appendChild(root);
			
			Element node = doc.createElement("Java_File");
			root.appendChild(node);
			
			Element e1 = doc.createElement("fileName");
			e1.appendChild(doc.createTextNode(fileName));
			node.appendChild(e1);
			
			Element e2 = doc.createElement("filePath");
			e2.appendChild(doc.createTextNode(xmlFileFolder+fileName+".xml"));
			node.appendChild(e2);
			
			Element e3 = doc.createElement("fileContent");
			e3.appendChild(doc.createTextNode(fileContent));
			node.appendChild(e3);
			
//			Node textnode = doc.createTextNode("first");
//			node.appendChild(textnode);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(xmlFileFolder
					+ fileName+".xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

//			System.out.println("File saved!");
			log.info("File saved.");

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] a = { "true", xmlFileFolder+fileName+".xml" };
		return a;
	}

}

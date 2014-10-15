package com.vjia.util;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Set Deprecated for now, as it's no use for now for this project.
 * 
 */
@Deprecated
public class XMLUtil {

	public static String getXMLValueByName(String xmlFilePath, String name) {
		String returnValue = "No Value!";
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			InputStream is = new FileInputStream(xmlFilePath);
			Document doc = builder.parse(is);
			Element root = doc.getDocumentElement();
			NodeList nodes = root.getChildNodes();
			if (nodes != null) {
				for (int i = 0; i < nodes.getLength(); i++) {
					Node node = nodes.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						String test =node.getNodeName();
						if(test.equals(name)){
							returnValue=node.getTextContent().trim();
						}
					}
				}
			}
		} catch (Exception e) {

		}
		return returnValue;
	}

	public static String getNodeAttributeByName(String xmlFilePath,String nodeName,String attributeName) {
		String returnVal="No value!";
		DocumentBuilderFactory domBuilderFactory = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder domBuilder = domBuilderFactory.newDocumentBuilder();
			InputStream is = new FileInputStream(xmlFilePath);
			Document doc = domBuilder.parse(is);
			Element root = doc.getDocumentElement();
			NodeList nodes = root.getChildNodes();
			if (nodes != null) {
				for (int i = 0; i < nodes.getLength(); i++) {
					Node node = nodes.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						String test = node.getNodeName();
						if (test.equals(nodeName)) {
							returnVal = node.getAttributes().getNamedItem(attributeName).getNodeValue();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}
}

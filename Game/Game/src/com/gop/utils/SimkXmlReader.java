package com.gop.utils;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.newdawn.slick.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public abstract class SimkXmlReader {

	/** set to false to deactivate node debug */
	boolean doDebug = false;

	protected String filePath;
	protected Document document;

	public SimkXmlReader(String filePath) throws ParserConfigurationException,
			SAXException, IOException {
		this.filePath = filePath;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		document = parser.parse(filePath);
		document.getDocumentElement().normalize();
	}

	public abstract void build() throws NumberFormatException, ParseException,
			Exception;

	protected void logNode(Node node) {
		if (doDebug) { /* debug only */
			StringBuffer sb = new StringBuffer("+ " + node.getNodeName());
			if (node.getChildNodes().getLength() == 1) {
				sb.append(" text: [" + node.getTextContent() + "]");
			} else {
				sb.append(" chldrn: " + node.getChildNodes().getLength());
			}
			if (node.hasAttributes()) {
				sb.append(" attr: " + node.getAttributes().getLength() + " ["
						+ node.getAttributes().item(0).getNodeName() + ":"
						+ node.getAttributes().item(0).getTextContent() + "]");
			}
			Log.debug(sb.toString());
		}
	}
}

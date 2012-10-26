package com.gop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public abstract class xmlReader {

	private XMLStreamReader reader;
	final String filePath;

	public xmlReader(String filePath) throws Exception {
		this.filePath = filePath;
		InputStream istream;
		istream = new FileInputStream(new File(filePath));

		reader = XMLInputFactory.newInstance().createXMLStreamReader(
				new InputStreamReader(istream));
	}

	public boolean hasNext() {
		try {
			return reader.hasNext();
		} catch (XMLStreamException e) {
			return false;
		}
	}

	public void terminate() {
		try {
			reader.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

}

package com.clemente.pruebaJDOM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JDOMException, IOException
    {
    	File file = new File("/home/clemente/xml/factura.XML");
    	SAXBuilder builder = new SAXBuilder();
    	Document doc = (Document) builder.build(file);
    	
    	Element raiz = doc.getRootElement();
    	Namespace nscfdi = Namespace.getNamespace("cfdi", "comprobante");
    	Namespace nstfd = Namespace.getNamespace("tfd", "TimbreFiscalDigital");
    	
    	raiz.getChild("complemento", nscfdi).removeChild("TimbreFiscalDigital", nstfd);
    	
    	XMLOutputter out = new XMLOutputter(Format.getPrettyFormat()); 
    	FileOutputStream file2 = new FileOutputStream("/home/clemente/xml/facturaSin.XML"); 
    	out.output(doc, file2); 
    	file2.flush(); 
    	file2.close();
    	
    }
    
    
    
    
}

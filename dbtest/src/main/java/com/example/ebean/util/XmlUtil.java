package com.example.ebean.util;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


/**
 * @author yuzk
 * @date 2017/11/27
 */
public class XmlUtil {

    public static String format(String inputXML) {
        SAXReader reader = new SAXReader();
        String requestXML = null;
        XMLWriter writer = null;
        try {
            Document document = reader.read(new StringReader(inputXML));
            if (document != null) {

                StringWriter stringWriter = new StringWriter();
                OutputFormat format = new OutputFormat(" ", true);
                writer = new XMLWriter(stringWriter, format);
                writer.write(document);
                writer.flush();
                requestXML = stringWriter.getBuffer().toString();
            }
            return requestXML;
        }catch (Exception e) {
            return null;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

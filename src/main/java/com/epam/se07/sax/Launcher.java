package com.epam.se07.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Launcher {

    public static void main(String[] args) throws Exception {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(false);
        parserFactory.setNamespaceAware(true);
        SAXParser parser = parserFactory.newSAXParser();
        try {
            parser.parse(Launcher.class.getResourceAsStream("web.xml"), new WebXmlHandler(3));
        } catch (ToMuchServletsFoundException ignore) {}

        System.out.println("End of launcher");
    }
}

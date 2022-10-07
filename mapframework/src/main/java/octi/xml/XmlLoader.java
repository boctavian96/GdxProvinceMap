package octi.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlLoader {
    public static Document prepareDatamodel(String path){
        try {
            SAXReader reader = new SAXReader();
            return reader.read(path);
        }catch (DocumentException de){
            de.printStackTrace();
        }
        return null;
    }
}

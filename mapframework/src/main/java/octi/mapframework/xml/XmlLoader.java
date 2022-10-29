package octi.mapframework.xml;

import lombok.NonNull;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.net.URL;

public class XmlLoader {
    public static Document prepareDatamodel(@NonNull String path){
        try {
            SAXReader reader = new SAXReader();
            return reader.read(path);
        }catch (DocumentException de){
            de.printStackTrace();
        }
        return null;
    }

    public static Document prepareDatamodel(@NonNull URL path){
        try{
            SAXReader reader = new SAXReader();
            return reader.read(path);
        }catch (DocumentException de){
            de.printStackTrace();
        }
        return null;
    }
}

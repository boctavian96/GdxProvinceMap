package octi.xml;

import lombok.NonNull;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

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
}

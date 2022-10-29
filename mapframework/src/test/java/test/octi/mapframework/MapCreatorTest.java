package test.octi.mapframework;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.sun.tools.javac.util.Assert;
import octi.mapframework.MapCreator;
import octi.mapframework.maptype.PoliticalMap;
import octi.mapframework.xml.XmlLoader;
import org.dom4j.Document;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class MapCreatorTest {


    @Test
    void testMapCreate() throws URISyntaxException {
        URL datamodelURL = MapCreatorTest.class.getResource("/test/testMap1/mapDatamodel.xml");
        URL mapId = MapCreatorTest.class.getResource("/test/testMap1/mapId.png");

        Document datamodel = XmlLoader.prepareDatamodel(datamodelURL);
        FileHandle fh = new FileHandle(new File(mapId.toURI()));


        //Given
        MapCreator mapCreator = new MapCreator(fh, datamodel);

        //When
        Texture createdMap = mapCreator.generateMap(new PoliticalMap());

        //Then
        Assert.checkNonNull(createdMap);
    }
}

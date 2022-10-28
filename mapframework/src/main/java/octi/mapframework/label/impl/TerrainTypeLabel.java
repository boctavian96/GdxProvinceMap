package octi.mapframework.label.impl;

import com.badlogic.gdx.graphics.g2d.Batch;
import octi.mapframework.label.ILabel;
import octi.mapframework.label.LabelModel;
import octi.mapframework.model.Point;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

public class TerrainTypeLabel implements ILabel {
    @Override
    public List<LabelModel> drawProvinceLabel(Batch batch, Document doc) {
        List<LabelModel> labelModels = new ArrayList<>();
        if(doc.selectNodes("//province//center").isEmpty()){
            return null;
        }
        List<Node> nodes = doc.selectNodes("//province");

        for(Node n : nodes){
            String coordinates = n.valueOf("center");
            String terrainType = n.valueOf("terrainType");
            Point p = new Point(coordinates);
            labelModels.add(new LabelModel(terrainType, p));
        }
        return labelModels;
    }
}

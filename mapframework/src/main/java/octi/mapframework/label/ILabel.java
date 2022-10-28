package octi.mapframework.label;

import com.badlogic.gdx.graphics.g2d.Batch;
import org.dom4j.Document;

import java.util.List;

public interface ILabel {
    List<LabelModel> drawProvinceLabel(Batch batch, Document doc);
}

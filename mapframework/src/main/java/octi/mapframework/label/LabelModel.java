package octi.mapframework.label;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import octi.mapframework.model.Point;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class LabelModel {
    private String labelName;
    private Point labelPosition;
}

package octi.map.screen.stage.widget;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import octi.map.GdxProvinceMap;

public class MapModeWidget extends WidgetGroup {
    public MapModeWidget(GdxProvinceMap context){
        Table table = new Table();
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));


        TextButton pMap = new TextButton("Political Map", skin);
        pMap.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                context.setMapState(0);
            }
        });

        TextButton rMap = new TextButton("Resource Map", skin);
        rMap.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                context.setMapState(1);
            }
        });

        TextButton tMap = new TextButton("Terrain Map", skin);
        tMap.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                context.setMapState(2);
            }
        });


        table.top().add(pMap.pad(10f)).pad(1f);
        table.add(rMap.pad(10f)).pad(1f);
        table.add(tMap.pad(10f)).pad(1f);

        addActor(table);
    }
}

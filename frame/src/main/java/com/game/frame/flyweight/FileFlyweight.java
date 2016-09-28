package com.game.frame.flyweight;

import com.game.frame.fsm.TouchMessage;
import com.game.frame.texture.TexRegionManager;

import org.andengine.entity.shape.RectangularShape;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import java.io.File;

/**
 * Created by fangxg on 2015/7/2.
 */
public class FileFlyweight extends BaseFlyweight {
    protected String fileName;
    private BaseGameActivity gameActivity;
    public FileFlyweight(float pOffsetX, float pOffsetY, String pFileName, BaseGameActivity pGameActivity) {
        super(pOffsetX, pOffsetY);
        fileName = pFileName;
        gameActivity = pGameActivity;
    }

    @Override
    public RectangularShape getShapeSelf(TouchMessage pTouchMessage) {

        File resFile = new File(fileName);
        if (resFile.exists() == true) {

            FileBitmapTextureAtlasSource fileBitmapTextureAtlasSource = FileBitmapTextureAtlasSource.create(resFile);
            BitmapTextureAtlas saveTex = new BitmapTextureAtlas(gameActivity.getTextureManager(), 256, 128);
            TiledTextureRegion saveTexReg = BitmapTextureAtlasTextureRegionFactory.createTiledFromSource(saveTex, fileBitmapTextureAtlasSource, 0, 0, 1, 1);
            saveTex.load();

            TiledSprite retSprite = TexRegionManager.getSprite( offsetX,  offsetY, saveTexReg, 0,  pTouchMessage);
            return retSprite;
        }else{
            throw new IllegalArgumentException("FileFlyweight create filed, file not found: " + fileName);
        }
    }
}

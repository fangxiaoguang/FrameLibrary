package com.game.frame.texture;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import java.io.File;

public class TiledTextureRegionNode {

    private String key;
    private int sizeX, sizeY;
    private int column, row;
    private TiledTextureRegion textureRegion;

    public TiledTextureRegionNode(String pKey, int pSizeX, int pSizeY, int pColumn, int pRow) {

        key = pKey;
        sizeX = pSizeX;
        sizeY = pSizeY;
        column = pColumn;
        row = pRow;
        textureRegion = null;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public TiledTextureRegion getTextureRegion(BaseGameActivity pGameActivity) {

        if (textureRegion == null) {
            BuildableBitmapTextureAtlas texture = new BuildableBitmapTextureAtlas(pGameActivity.getTextureManager(),
                    rebuildTextureSize(getSizeX()), rebuildTextureSize(getSizeY()), TextureOptions.BILINEAR);

            textureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(texture, pGameActivity, "texture/" + key + ".png", column,
                    row);
            try {
                texture.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
                texture.load();
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                throw new IllegalArgumentException("TextureRegion load error :" + key + ".png");
            }
        }
        return textureRegion;
    }

    public TiledTextureRegion getTextureRegion(BaseGameActivity pGameActivity, String pSdcartdPahtTexture) {

        if (textureRegion == null) {
            File resFile = new File(pSdcartdPahtTexture + key + ".png");
            FileBitmapTextureAtlasSource fileBitmapTextureAtlasSource = FileBitmapTextureAtlasSource.create(resFile);
            BitmapTextureAtlas texture = new BitmapTextureAtlas(pGameActivity.getTextureManager(), rebuildTextureSize(getSizeX()),
                    rebuildTextureSize(getSizeY()), TextureOptions.BILINEAR);
            textureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromSource(texture, fileBitmapTextureAtlasSource, 0, 0, column, row);
            texture.load();
        }
        return textureRegion;
    }

    private static int rebuildTextureSize(int i) {
        int ret = 1;
        while (ret < i) {
            ret = ret * 2;
        }
        return ret;
    }
}
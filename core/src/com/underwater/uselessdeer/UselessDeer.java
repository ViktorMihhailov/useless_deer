package com.underwater.uselessdeer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.overlap2d.extensions.spine.SpineItemType;
import com.uwsoft.editor.renderer.SceneLoader;

public class UselessDeer extends ApplicationAdapter {

    private SceneLoader sl;
    private Viewport viewport;


	@Override
	public void create () {
        viewport = new StretchViewport(1200, 768); // this should be the size of camera in WORLD units. make sure you check that in editor first.
        sl = new SceneLoader(); // default scene loader loads all resources from default RM as usual.
        sl.injectExternalItemType(new SpineItemType());
        sl.loadScene("MainScene", viewport); // loading scene as usual
    }

	@Override
	public void render() {
        Gdx.gl.glClearColor(36/225f, 20 / 225f, 116 / 225f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sl.getEngine().update(Gdx.graphics.getDeltaTime()); // getting the ashley engine and updating it (it will render things with it's own render system)
	}
}

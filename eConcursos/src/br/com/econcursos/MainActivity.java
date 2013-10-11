package br.com.econcursos;


import android.os.Bundle;
import br.com.econcursos.fragments.MenuClickInterface;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;

public class MainActivity extends SherlockFragmentActivity implements MenuClickInterface {
    SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu_fragment_layout);
        menu.setSlidingEnabled(true);        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        menu.toggle();
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onListitemClick(MenuItem item) {
		//chama outras activits aqui
	}
}
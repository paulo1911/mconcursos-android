package br.com.econcursos;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import br.com.econcursos.fragments.ConcursoSearchFragment;
import br.com.econcursos.fragments.MenuClickInterface;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnActionExpandListener;
import com.slidingmenu.lib.SlidingMenu;


public class MainActivity extends SherlockFragmentActivity implements MenuClickInterface, OnActionExpandListener {
	private SlidingMenu menu;
	private EditText editsearch;
	private MenuItem menuSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(com.actionbarsherlock.R.style.Theme_Sherlock_Light);
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
		menu.setFadeEnabled(true);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		menu.setMenu(R.layout.menu_fragment_layout);
		menu.setSlidingEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.menu_search: {

			break;
		}

		default:
			menu.toggle();
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getSupportMenuInflater().inflate(R.menu.main, menu);
		
		// Show the search menu item in menu.xml
		this.menuSearch = menu.findItem(R.id.menu_search);
		menuSearch.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
		menuSearch.setOnActionExpandListener(this);
		
		// Locate the EditText in menu.xml
		editsearch = (EditText) this.menuSearch.getActionView();
		editsearch.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editsearch.getWindowToken(), 0);
				
				buscaConcursos((v !=null && v.getText() !=null) ? v.getText().toString(): null);
				
				return false;
			}
		});

		return super.onCreateOptionsMenu(menu);
	}

	private void buscaConcursos(String text) {
		if(text != null) {
			Intent intent = getIntent();
			intent.putExtra(ConcursoSearchFragment.PARAM_QUERY_STRING,text);		
			
			ConcursoSearchFragment concursoSearchFragment = new ConcursoSearchFragment();
			concursoSearchFragment.setArguments(intent.getExtras());
			
			this.menuSearch.collapseActionView();
			
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.fragment_container, concursoSearchFragment);
			ft.addToBackStack(null);
			ft.commit();
		}
		
		this.menuSearch.collapseActionView();
		       
	}

	// Menu Action Collapse
	@Override
	public boolean onMenuItemActionCollapse(MenuItem item) {
		// Empty EditText to remove text filtering
		editsearch.setText("");
		editsearch.clearFocus();
		return true;
	}

	// Menu Action Expand
	@Override
	public boolean onMenuItemActionExpand(MenuItem item) {
		// Focus on EditText
		editsearch.requestFocus();
		// Force the keyboard to show on EditText focus
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

		return true;
	}

	@Override
	public void onListitemClick(MenuItem item) {
		menu.toggle();
	}
}	
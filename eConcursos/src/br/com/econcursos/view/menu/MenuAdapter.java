/**
 * 
 */
package br.com.econcursos.view.menu;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.econcursos.R;

import com.actionbarsherlock.view.MenuItem;

/**
 * @author Paulo
 *
 */
public class MenuAdapter extends BaseAdapter {
	
	private Context ctx;
	private List<MenuItem> listMenu;
	
	public MenuAdapter(Context ctx, List<MenuItem> listMenu) {
		this.ctx = ctx;
		this.listMenu = listMenu;
	}

	@Override
	public int getCount() {
		return (listMenu != null) ? listMenu.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return (listMenu != null) ? listMenu.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		MenuItem menuItem = listMenu.get(position);
		
		LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View viewToReturn = inflater.inflate(R.layout.menu_list_item_layout, null);
		
		ImageView iconeMenu = (ImageView) viewToReturn.findViewById(R.id.iconeMenu);
		iconeMenu.setContentDescription(menuItem.getTitle());
		iconeMenu.setImageDrawable(menuItem.getIcon());
		
		TextView titulo = (TextView) viewToReturn.findViewById(R.id.titulo);
		titulo.setText(menuItem.getTitle());		
		
		
		return viewToReturn;
	}

	

}

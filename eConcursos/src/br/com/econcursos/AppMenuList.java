/**
 * 
 */
package br.com.econcursos;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.view.MenuItem;

/**
 * @author Paulo
 *
 */
public class AppMenuList {
	
	public static List<MenuItem> getAppMenuList(Context context) {
		return getAppMenuListItem(context);
	}
	
	private static List<MenuItem> getAppMenuListItem(Context context) {
		List<MenuItem> toREturn = new ArrayList<MenuItem>();
		
		MenuItem inicioItem = new MenuBuilder(context).add(R.string.item_menu_home).setIcon(R.drawable.menu_home_azul);
		toREturn.add(inicioItem);
		
		MenuItem menuItemDestaque = new MenuBuilder(context).add(R.string.item_menu_em_destaque).setIcon(R.drawable.menu_item_destaque_brasil_azul);
		toREturn.add(menuItemDestaque);
		
		MenuItem menuItemNoBrasil = new MenuBuilder(context).add(R.string.item_menu_no_brasil).setIcon(R.drawable.menu_item_no_brasil);
		toREturn.add(menuItemNoBrasil);
		
		MenuItem menuItemPorEstado = new MenuBuilder(context).add(R.string.item_menu_por_estados).setIcon(R.drawable.menu_item_concurso_por_estado);
		toREturn.add(menuItemPorEstado);
		
		MenuItem menuItemPorRegiao = new MenuBuilder(context).add(R.string.item_menu_por_regiao).setIcon(R.drawable.menu_item_concursos_por_regiao);
		toREturn.add(menuItemPorRegiao);
		
		MenuItem menuItemFavoritos = new MenuBuilder(context).add(R.string.item_menu_favoritos).setIcon(R.drawable.menu_item_favoritos);
		toREturn.add(menuItemFavoritos);
		
		MenuItem menuItemProvas = new MenuBuilder(context).add(R.string.menu_item_provas_gabaritos).setIcon(R.drawable.menu_item_provas_gabaritos);
		toREturn.add(menuItemProvas);		
		
		return toREturn;
	}

}

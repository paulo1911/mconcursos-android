/**
 * 
 */
package br.com.econcursos.fragments;

/**
 * @author Paulo
 *
 */


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import br.com.econcursos.AppMenuList;
import br.com.econcursos.R;
import br.com.econcursos.view.menu.MenuAdapter;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;

public class MenuFragment extends SherlockFragment {
    ListView list;
    MenuClickInterface mClick;
	private static ListAdapter menuAdapter = null;
    
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mClick = (MenuClickInterface) activity;
    }

    private static ListAdapter getMenuAdapter(Context ctx){
        
        if(menuAdapter == null) {
            menuAdapter = new MenuAdapter(ctx, AppMenuList.getAppMenuList(ctx));
        } 
        
        return menuAdapter;
    }
    
    public void onActivityCreated(Bundle savedInstanceState) {
    	getActivity().setTheme(com.actionbarsherlock.R.style.Theme_Sherlock_Light);
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getView().findViewById(R.id.list);
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
            	
            	MenuItem item = (MenuItem) arg0.getItemAtPosition(position);
   
           		mClick.onListitemClick(item);

                
                switch (position) {
                   
        			case 0: {
        				//perfil
        	              break;
        			}
        			
        			case 1:{
        				//destaque
        	              FragmentManager fm = getActivity().getSupportFragmentManager();            
        	              FragmentTransaction ft = fm.beginTransaction();
        	              ft.replace(R.id.fragment_container,  new ConcursosEmDestaqueFragment());
        	              ft.addToBackStack(null);
        	              ft.commit();
        	              break;
        			}
        			case 2: {
        					//por estado
	      	              FragmentManager fm = getActivity().getSupportFragmentManager();	              
	      	              FragmentTransaction ft = fm.beginTransaction();
	      	              ft.replace(R.id.fragment_container,  new ConcursosPorEstadoFragment());
	      	              ft.addToBackStack(null);
	      	              ft.commit();
        				break;
        				
        			}
					case 3: {
						//por regiao
						break;
					}
					case 4: {
						//favoritos
						break;
					}
					case 5: {
						//povas
						break;
					}
	
					default:{
						break;
					}	
				}
               
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_side_layout, container, false);
        ListView listMenu = (ListView) v.findViewById(R.id.list);
        listMenu.setAdapter(getMenuAdapter(getActivity()));        
        return v;
    }
}
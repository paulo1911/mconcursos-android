/**
 * 
 */
package br.com.econcursos.fragments;

/**
 * @author Paulo
 *
 */


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.com.econcursos.AppMenuList;
import br.com.econcursos.R;
import br.com.econcursos.view.menu.MenuAdapter;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;

public class MenuFragment extends SherlockFragment {
    ListView list;
    MenuClickInterface mClick;
    
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mClick = (MenuClickInterface) activity;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getView().findViewById(R.id.list);
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                MenuItem i=(MenuItem) arg0.getItemAtPosition(arg2);
                mClick.onListitemClick(i);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_side_layout, container, false);
        ListView listMenu = (ListView) v.findViewById(R.id.list);
        listMenu.setAdapter(new MenuAdapter(getSherlockActivity(), AppMenuList.getAppMenuList(getSherlockActivity())));        
        return v;
    }
}
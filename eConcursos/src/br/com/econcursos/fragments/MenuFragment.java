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
import br.com.econcursos.R;

import com.actionbarsherlock.app.SherlockFragment;

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
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                String i=(String) arg0.getItemAtPosition(arg2);
                mClick.onListitemClick(i);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_list_layout, container, false);
        return v;
    }
}
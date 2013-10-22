/**
 * 
 */
package br.com.econcursos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.econcursos.R;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * @author Paulo
 *
 */
public class HomeFragment extends SherlockFragment {

	private Context context = null;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);		
		this.context = getActivity(); 
	}
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		getActivity().setContentView(R.layout.activity_main);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       
        View v = inflater.inflate(R.layout.activity_main, container, false);
 
        return v;
    }
}

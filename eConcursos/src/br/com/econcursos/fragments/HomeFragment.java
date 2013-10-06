/**
 * 
 */
package br.com.econcursos.fragments;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import br.com.econcursos.R;
import br.com.econcursos.domain.model.Concurso;
import br.com.econcursos.domain.model.ConcursosAdapter;
import br.com.econcursos.webservice.ConcursosService;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * @author Paulo
 *
 */
public class HomeFragment extends SherlockFragment implements Runnable {
	
	private Integer page = 1;
	public static final int HOME_FRAGMENT_ACTIVITY = 1;
	private Handler handler = new Handler();
	private Context context = null;
	
	private static String URL_HOME_CONCURSOS = "https://mconcurso-pauloleite.rhcloud.com/rest/concursos/list";
	
	
	private void getConcursosToStart() {		
		
		ImageView imageView = (ImageView) getView().findViewById(R.id.status_running);
		imageView.setVisibility(View.VISIBLE);
		new Thread(this).start();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);		
		this.context = getActivity(); 
		getConcursosToStart();
	}
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.concursos_list_frame_layout, container, false);
        ListView list = (ListView) v.findViewById(R.id.list_concursos);
        return v;
    }
	
	private List<Concurso> getConcursosFromServer(String url, Integer page) {
		
		ArrayList<Concurso>  concursosResult = null;
		
		if(url != null) {
			
			Integer pageParam = (page != null) ? page : 1;
			
			ConcursosService service = new ConcursosService();
			concursosResult = service.getConcursos(url, pageParam);			
		}
		return concursosResult;	
	}

	@Override
	public void run() {
		
		try {
			
			final List<Concurso> concursosToView = getConcursosFromServer(URL_HOME_CONCURSOS, this.page);
			
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					
					ListView listView = (ListView) getView().findViewById(R.id.list_concursos);
					listView.setAdapter(new ConcursosAdapter(context,concursosToView));				
				}
			});
			
		} catch (Exception e) {
			
		} finally {
			
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					
					ImageView imageView = (ImageView) getView().findViewById(R.id.status_running);
					imageView.setVisibility(View.GONE);
					
				}
			});
			
		}
	}
	
}

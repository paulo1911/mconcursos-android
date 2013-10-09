/**
 * 
 */
package br.com.econcursos.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
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
public class HomeFragment extends SherlockFragment implements Runnable, OnScrollListener {
	
	private ProgressDialog dialog = null;
	private Integer page = 1;
	public static final int HOME_FRAGMENT_ACTIVITY = 1;
	private Handler handler = new Handler();
	private Context context = null;
	private int firstVisibleItem;
	private int visibleItemCount;
	private int totalItemCount;
	private int previousTotal = 0;
	private boolean loading = true;
	private boolean isEndOfList = false;
	private boolean isTopOfList = true;
	private int currentScrollState;
	private boolean changeVisibleItem = false;
	
	private static String URL_HOME_CONCURSOS = "https://mconcurso-pauloleite.rhcloud.com/rest/concursos/list";
	
	
	private void getConcursosToStart() {		
		
		dialog = ProgressDialog.show(getActivity(), "Aguarde", "Obtendo dados de concursos...");
		
		//ImageView imageView = (ImageView) getView().findViewById(R.id.status_running);
		//imageView.setVisibility(View.VISIBLE);
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
        list.setOnScrollListener(this);
        return v;
    }
	
	private Map<String, Object> getMapConcursosFromServer(String url, Integer page) throws Exception {
		Map<String, Object> result = null;
		
		if(url != null) {
			
			Integer pageParam = (page != null) ? page : 1;
			
			ConcursosService service = new ConcursosService();
			result = service.getConcursosMapResults(url, pageParam);			
		}
		return result;	
	}

	@Override
	public void run() {
		
		try {
			
			
			
			final Map<String, Object> concursosMapToView = getMapConcursosFromServer(URL_HOME_CONCURSOS, this.page);

			
			if (concursosMapToView != null) {
				
				final List<Concurso> concursosList = (List<Concurso>) concursosMapToView.get("concursosList");
			
			
				handler.post(new Runnable() {
						
						@Override
						public void run() {
							
							ListView listView = (ListView) getView().findViewById(R.id.list_concursos);
							listView.setAdapter(new ConcursosAdapter(context, concursosList));	
							
							if (dialog != null) {
								dialog.dismiss();
							}
							
							loading = false;
						}
				});
						
			}			

			
		} catch (Exception e) {			
			
						
			
		} finally {
			
			if (dialog != null) {
				dialog.dismiss();
			}
			
			loading = false;
			
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		
		this.changeVisibleItem = ((this.firstVisibleItem != firstVisibleItem) || this.visibleItemCount != visibleItemCount) ? true : false;
		
		this.firstVisibleItem = firstVisibleItem;
		this.visibleItemCount = visibleItemCount;
		this.totalItemCount = totalItemCount;
		Log.i(getClass().getName(),String.format("Executou: onScroll - valores: firstVisibleItem = %d, visibleItemCount= %d, totalItemCount= %d",firstVisibleItem, visibleItemCount, totalItemCount));
		
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
		this.currentScrollState = scrollState;
		
		switch (scrollState) {
		
        case OnScrollListener.SCROLL_STATE_IDLE:
    		Log.i(getClass().getName(),String.format("Executou: onScrollStateChanged - valores: scrollState = %d", OnScrollListener.SCROLL_STATE_IDLE));
        	
    		doPagination();
    		
            break;
        case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
            break;
        case OnScrollListener.SCROLL_STATE_FLING:
            break;
        }
		
	}
	
	

	
	private void doPagination() {
		
		this.isEndOfList = false;
		this.isTopOfList = false;
		
		if (!loading) {
			
			if((this.firstVisibleItem + this.visibleItemCount) >= this.totalItemCount) {
				//paginando para frente
				page++;
				this.isEndOfList = true;
				
			} else if(this.firstVisibleItem == 0){
				//paginando para traz
				int pageOld = page--;
				page = (page <= 0 ) ? 1 : page;
				
				if(pageOld != page) {
					this.isTopOfList = true;
				}
			}
			
			if(this.isEndOfList || this.isTopOfList) {
			
				this.loading = true;
				getConcursosToStart();
	
				Log.i(getClass().getName(),String.format("Obtendo registros em página: %d", page));
			
			}
        }

	}
	
	
}

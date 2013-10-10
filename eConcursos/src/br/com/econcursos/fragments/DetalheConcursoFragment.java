/**
 * 
 */
package br.com.econcursos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.econcursos.R;
import br.com.econcursos.domain.model.Concurso;
import br.com.econcursos.webservice.ConcursosService;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;



/**
 * @author Paulo
 *
 */
public class DetalheConcursoFragment extends SherlockFragment implements Runnable {

	private ConcursosService concursosService = new ConcursosService();
	private Handler viewHandler = new Handler();
	private String idConcurso = null;
	private Context context = null;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		this.context = getActivity();
		
		this.idConcurso = getActivity().getIntent().getStringExtra(Concurso.ID_FIELD);		
		
		getConcursoToStart();
	}

	private void getConcursoToStart() {

		new Thread(this).start();
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detalhe_concurso_layout, container, false);
        return v;
    }

	@Override
	public void run() {
		
		try {
		
			final Concurso concurso = getConcursoFromServer(this.idConcurso);
		
			viewHandler.post(new Runnable() {
				
				@Override
				public void run() {
					//LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					View view  = getView();//inflater.inflate(R.layout.detalhe_concurso_layout, null);
					
					TextView dataFonteDetalhe = (TextView) view.findViewById(R.id.dataFonteDetalhe);
					dataFonteDetalhe.setText((concurso.getDataPublicacao() != null) ? concurso.getDataPublicacao().toString() : null);
					
					TextView titulo = (TextView) view.findViewById(R.id.title);
					titulo.setText(concurso.getTitulo());
					
					TextView description = (TextView) view.findViewById(R.id.description);
					description.setText(concurso.getDescricao());
					
				}
			});
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			
			
		}
		
	}
	
	/**
	 * Retorna o {@link Concurso} a partir de um id informado
	 * @param idConcurso
	 * @return
	 * @throws Exception 
	 */
	private Concurso getConcursoFromServer(String idConcurso) throws Exception {
		 Concurso concurso = null;
		 
		 if(idConcurso != null ) {
		 
			 concurso = concursosService.getConcursoById(idConcurso);
		 
		 }
		 
		return concurso;
	}	
	
}

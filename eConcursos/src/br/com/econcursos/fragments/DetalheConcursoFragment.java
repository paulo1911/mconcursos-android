/**
 * 
 */
package br.com.econcursos.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import br.com.econcursos.R;
import br.com.econcursos.domain.model.AnexosSpinnerAdapter;
import br.com.econcursos.domain.model.ArquivoAnexoModel;
import br.com.econcursos.domain.model.Concurso;
import br.com.econcursos.util.DataUtils;
import br.com.econcursos.webservice.ConcursosService;
import br.com.econcursos.widget.ActionDialog;

import com.actionbarsherlock.app.SherlockFragment;



/**
 * @author Paulo
 *
 */
public class DetalheConcursoFragment extends SherlockFragment implements Runnable, OnLongClickListener {

	private ConcursosService concursosService = new ConcursosService();
	private Handler viewHandler = new Handler();
	private String idConcurso = null;
	private Context context = null;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
    	getActivity().setTheme(com.actionbarsherlock.R.style.Theme_Sherlock_Light);
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
        TextView desc = (TextView) v.findViewById(R.id.description);
        desc.setOnLongClickListener(this);
        return v;
    }

	@Override
	public void run() {
		
		try {
		
			final Concurso concurso = getConcursoFromServer(this.idConcurso);
		
			viewHandler.post(new Runnable() {
				
				@Override
				public void run() {
					View view  = getView();
					
					TextView titulo = (TextView) view.findViewById(R.id.title);
					titulo.setText(concurso.getTitulo());
					
					TextView dataFonteDetalhe = (TextView) view.findViewById(R.id.dataFonteDetalhe);
					dataFonteDetalhe.setText((concurso.getDataPublicacao() != null) ? DataUtils.formatDatePorExtenso(concurso.getDataPublicacao()) : null);
					
					TextView description = (TextView) view.findViewById(R.id.description);
					description.setText(concurso.getDescricao());
					
					if(concurso.getAnexos() != null) {					
						Spinner anexos = (Spinner) view.findViewById(R.id.attachments);
						List<ArquivoAnexoModel> anexosList = new ArrayList<ArquivoAnexoModel>(concurso.getAnexos());
						anexos.setAdapter(new AnexosSpinnerAdapter(context, anexosList));
						anexos.setVisibility(View.VISIBLE);					
					}					
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

	@Override
	public boolean onLongClick(View v) {
		
		Dialog actionDialog = new ActionDialog(getActivity());
		actionDialog.show();
		
		return true;
	}	
	
}

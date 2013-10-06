/**
 * 
 */
package br.com.econcursos.domain.model;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.econcursos.R;
import br.com.econcursos.util.DataUtils;

/**
 * @author Paulo
 *
 */
public class ConcursosAdapter extends BaseAdapter {
	
	private Context ctx;
	private List<Concurso> listConcursos;
	
	/**
	 * @param ctx
	 * @param listConcursos
	 */
	public ConcursosAdapter(Context ctx, List<Concurso> listConcursos) {
		super();
		this.ctx = ctx;
		this.listConcursos = listConcursos;
	}

	@Override
	public int getCount() {
		return (listConcursos != null) ? listConcursos.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return (listConcursos != null) ? listConcursos.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Concurso concurso = listConcursos.get(position);
		
		LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View viewToReturn = inflater.inflate(R.layout.concursos_list_list_layout, null);
		
		TextView dataFonte = (TextView)viewToReturn.findViewById(R.id.dataFonte);
		
		String dataFonteText = String.format("%s em %s",DataUtils.formatDateDiaMesAno(concurso.getDataPublicacao()), (concurso.getFonte() != null) ? concurso.getFonte().getNome() : null);
		
		dataFonte.setText(dataFonteText);
		
		TextView titulo = (TextView) viewToReturn.findViewById(R.id.titulo);
		titulo.setText(concurso.getTitulo());
		
		TextView descricao = (TextView) viewToReturn.findViewById(R.id.descricao);
		descricao.setText(concurso.getDescricao());
		
		if(concurso.getTotalAnexos() != null && concurso.getTotalAnexos() > 0) {
		
			ImageView imgAnexo = (ImageView) viewToReturn.findViewById(R.id.anexoImage);
			imgAnexo.setImageResource(R.drawable.download_anexo);
		}		
		
		return viewToReturn;
	}	
}

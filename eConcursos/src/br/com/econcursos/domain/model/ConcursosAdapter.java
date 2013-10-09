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
import br.com.econcursos.util.TextJustify;

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
		
		View viewToReturn = inflater.inflate(R.layout.concursos_list_layout, null);
		
		TextView dataFonte = (TextView)viewToReturn.findViewById(R.id.dataFonte);
		
		String dataFonteText = String.format("%s em %s",DataUtils.formatDateDiaMesAno(concurso.getDataPublicacao()), (concurso.getFonte() != null) ? concurso.getFonte().getNome() : null);
		
		dataFonte.setText(dataFonteText);
		
		TextView titulo = (TextView) viewToReturn.findViewById(R.id.titulo);
		titulo.setVerticalScrollBarEnabled(false);
		titulo.setText(getDescriptionToTextView(concurso.getTitulo(), 100, "."));		
		TextJustify.run(titulo, 305f);		
		
		TextView descricao = (TextView) viewToReturn.findViewById(R.id.descricao);
		descricao.setVerticalScrollBarEnabled(false);
		descricao.setText(getDescriptionToTextView(concurso.getDescricao(), 150, "."));
		descricao.setPadding(0,5,0, 20);		
		TextJustify.run(descricao, 305f);
		
		if(concurso.getTotalAnexos() != null && concurso.getTotalAnexos() > 0) {
			descricao.setPadding(0,5,0,10);
			
			ImageView imgAnexo = (ImageView) viewToReturn.findViewById(R.id.anexoImage);
			imgAnexo.setImageResource(R.drawable.download_anexo);
			imgAnexo.setPadding(0,5,0, 20);
			
			TextView totalAnexos = (TextView) viewToReturn.findViewById(R.id.totalAnexos);
			totalAnexos.setVerticalScrollBarEnabled(false);
			totalAnexos.setText(String.format("Editais e Anexos (%d)", concurso.getTotalAnexos()));
			totalAnexos.setPadding(0,5,0, 30);
		}		
		
		return viewToReturn;
	}
	
	private String getDescriptionToTextView(String text, int max_length, String endConcat) {
		
		String toReturn = null;
		
		if(text != null) {
			
			if(text.length() > max_length) {
				
				int end = text.indexOf(".", max_length);				
				
				toReturn = text.substring(0, (end > 0)? end : max_length);
				
				toReturn = String.format("%s%s", toReturn, endConcat);
				
			} else {
				
				return text;
			}
		}
		
		return toReturn;
		
	}
	
	private String getHTMLText(String text) {
		if(text != null ) {
			return String.format("<html><body style=\"text-align:justify;\">%s</body></html>", text);
		}
		return null;
	}	
}

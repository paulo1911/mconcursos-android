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

/**
 * @author Paulo
 *
 */
public class AnexosSpinnerAdapter extends BaseAdapter {

	private Context context;
	private List<ArquivoAnexoModel> listaAnexos;
	
	/**
	 * @param ctx
	 * @param listConcursos
	 */
	public AnexosSpinnerAdapter(Context ctx, List<ArquivoAnexoModel> listaAnexos) {
		super();
		this.context = ctx;
		this.listaAnexos = listaAnexos;
	}

	@Override
	public int getCount() {
		return (this.listaAnexos != null) ? this.listaAnexos.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return (this.listaAnexos != null) ? this.listaAnexos.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
	 if (null == convertView) {
         LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         convertView = inflater.inflate(R.layout.anexos_spinner_layout, null);
      }
	 
	 ArquivoAnexoModel anexo = this.listaAnexos.get(position);
	 
	 TextView name = (TextView) convertView.findViewById(R.id.rowText);
	 name.setText(anexo.getNomeArquivo());

     ImageView icon = (ImageView) convertView.findViewById(R.id.rowImage);
      //icon.setImageDrawable(spinnerIcon);

      return convertView;
	}  
	
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		
		 if (null == convertView) {
	         LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	         convertView = inflater.inflate(R.layout.anexos_spinner_layout, null);
	      }
	
		 ArquivoAnexoModel anexo = this.listaAnexos.get(position);
		 
		 TextView name = (TextView) convertView.findViewById(R.id.rowText);
		 name.setText(anexo.getNomeArquivo());

	      ImageView icon = (ImageView) convertView.findViewById(R.id.rowImage);
	      //icon.setImageDrawable(spinnerIcon);
	
	     return convertView;
	}
}

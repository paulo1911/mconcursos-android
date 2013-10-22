/**
 * 
 */
package br.com.econcursos.domain.model;

import java.util.List;

import br.com.econcursos.R;
import br.com.econcursos.util.Estado;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Paulo
 *
 */
public class ComboEstadosSpinnerAdapter extends BaseAdapter {
	
	private Estado[] estados = Estado.values();

	private Context context;
	
	/**
	 * @param ctx
	 * @param estados
	 */
	public ComboEstadosSpinnerAdapter(Context ctx, Estado[] estados) {
		super();
		this.context = ctx;
		this.estados = estados;
	}

	@Override
	public int getCount() {
		return (this.estados != null) ? this.estados.length : 0;
	}

	@Override
	public Object getItem(int position) {
		return (this.estados != null) ? this.estados[position] : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
	 if (null == convertView) {
         LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         convertView = inflater.inflate(R.layout.estados_spinner_layout, null);
      }
	 
		 Estado estado = this.estados[position];
		 
		 TextView name = (TextView) convertView.findViewById(R.id.rowText);
		 name.setText(estado.nomeEstado());

      return convertView;
	}  
	
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		
		 if (null == convertView) {
	         LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	         convertView = inflater.inflate(R.layout.anexos_spinner_layout, null);
	      }
		 
			 Estado estado = this.estados[position];
			 
			 TextView name = (TextView) convertView.findViewById(R.id.rowText);
			 name.setText(estado.nomeEstado());

	      return convertView;
	}

}

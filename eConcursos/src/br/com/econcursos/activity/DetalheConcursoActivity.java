/**
 * 
 */
package br.com.econcursos.activity;

import android.os.Bundle;
import br.com.econcursos.R;

import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * @author Paulo
 *
 */
public class DetalheConcursoActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhe_concurso_fragment_layout);
	}	
}

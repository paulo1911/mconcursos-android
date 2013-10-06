/**
 * 
 */
package br.com.econcursos.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.util.Log;
import br.com.econcursos.domain.model.ArquivoAnexoModel;
import br.com.econcursos.domain.model.Concurso;
import br.com.econcursos.util.DataUtils;
import br.com.econcursos.webservice.model.ConcursosWS;

/**
 * @author Paulo
 * 
 */
public class ConcursosService {

	@SuppressLint("DefaultLocale")
	public ArrayList<Concurso> getConcursos(String urlPath, Integer page) {
		
		ArrayList<Concurso> listToReturn = null;
		
		if(urlPath !=null ) {
	
			String urlGet = (page != null && page > 0) ? String.format("%s/%d",urlPath, page) : urlPath;
			
			String stringResult = null;
			
			try {
				
				stringResult = doGetRequest(urlGet);
				
				listToReturn = getListConcursoFromJsonResult(stringResult);
				
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listToReturn;
	}
	
	/**
	 * Execute requisição {@link HttpGet} com base na Url informada
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private String doGetRequest(String url) throws ClientProtocolException, IOException {
		
		StringBuilder builder = new StringBuilder();
		HttpClient client = HttpServiceClientFactory.getInstance();
		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = client.execute(httpGet);
		StatusLine statusLine = response.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		
		if (statusCode == 200) {
			
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
			String line;
			
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			
		} else {
			Log.e(ConcursosService.class.toString(), String.format("Falha ao obter dados de: \n%s \nstatus code: %s", url, statusCode));
		}
		
		return builder.toString();
	}
	
	/**
	 * Retorna {@link List<{@link Concurso}>} a partir de uma String json
	 * @param result
	 * @return
	 */
	private ArrayList<Concurso> getListConcursoFromJsonResult(String result) {
		
		ArrayList<Concurso> listToReturn = null;
		
		if (result != null) {
			
			JSONObject jsonRsult = null;
			JSONObject jsonResponse = null;
			JSONArray concursosArrayObject = null;
			
			try {
				
				jsonRsult = new JSONObject(result);
				jsonResponse = jsonRsult.getJSONObject(ConcursosWS.RESPONSE);
				concursosArrayObject = jsonResponse.getJSONArray(ConcursosWS.CONCURSOS_LIST);
				
				if(concursosArrayObject != null && concursosArrayObject.length() > 0) {
					
					listToReturn = new ArrayList<Concurso>();
					
					for(int i=0;i < concursosArrayObject.length() ; i++) {
						
						listToReturn.add(getConcursoFromJsonObject(concursosArrayObject.getJSONObject(i)));
						
					}
				
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return listToReturn;
	}
	
	/**
	 * Retorna {@link Concurso} a partir de um {@link JSONObject} informado
	 * @param concursoObject
	 * @return
	 */
	private Concurso getConcursoFromJsonObject(JSONObject concursoObject) {

		Concurso toReturn = null;		
		
		if(concursoObject != null) {
			toReturn = new Concurso();
			try {
				
				toReturn.setId(getStringData(Concurso.ID_FIELD, concursoObject));
				toReturn.setTitulo(getStringData(Concurso.TITULO_FIELD, concursoObject));
				toReturn.setDescricao(getStringData(Concurso.DESCRICAO_FIELD, concursoObject));
				toReturn.setLink(getStringData(Concurso.LINK_FIELD, concursoObject));
				
				String stringDate = getStringData(Concurso.DATA_PUBLICACAO_FIELD, concursoObject);
				
				Date dataPublicacao = (stringDate != null) ? DataUtils.getDateFromString(stringDate) : null;
				
				toReturn.setDataPublicacao(dataPublicacao);
				
				toReturn.setAnexos(getAnexosFromJson(concursoObject));
				
				String totalAanexos = getStringData(Concurso.TOTAL_ANEXOS_FIELD, concursoObject);				
				Integer totalAnexosNumber = (totalAanexos != null) ? Integer.valueOf(totalAanexos) : null;				
				toReturn.setTotalAnexos(totalAnexosNumber);

			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
		
		return toReturn;
	}
	
	/**
	 * Retorna String com base na chave informada
	 * @param idField
	 * @param concursoObject
	 * @return
	 * @throws JSONException 
	 */
	private String getStringData(String keyField, JSONObject concursoObject) throws JSONException {
		
		if(concursoObject != null && concursoObject.has(keyField)) {
			
			return concursoObject.getString(keyField);
		}
		
		return null;
	}
	
	/**
	 * Retorna {@link Set<{@link ArquivoAnexoModel}>} a partir de um {@link JSONObject} informado
	 * @param concursoObject
	 * @return
	 */
	private Set<ArquivoAnexoModel> getAnexosFromJson(JSONObject concursoObject) {
		
		Set<ArquivoAnexoModel> setAnexosToReturn = null;
		
		if(concursoObject != null && concursoObject.has(Concurso.ANEXOS_FIELD)) {
			
			setAnexosToReturn = new HashSet<ArquivoAnexoModel>();
			
			JSONArray anexosJsonArray = null;
			JSONObject anexoObject = null;
			
			try {
				anexosJsonArray = concursoObject.getJSONArray(Concurso.ANEXOS_FIELD);
			} catch (JSONException e1) {
				
				try {
					
					anexoObject = concursoObject.getJSONObject(Concurso.ANEXOS_FIELD);
					
					if(anexoObject != null) {
						setAnexosToReturn.add(getAnexoFromJsonObject(anexoObject));
					}
					
					return setAnexosToReturn;
					
				} catch (JSONException e) {
	
					e.printStackTrace();
				}
				
			}		
			
			
			if(anexosJsonArray != null && anexosJsonArray.length() > 0) {
				
				setAnexosToReturn = new HashSet<ArquivoAnexoModel>();
				
				for(int i=0;i < anexosJsonArray.length() ; i++) {
					
					try {
					
						setAnexosToReturn.add(getAnexoFromJsonObject(anexosJsonArray.getJSONObject(i)));	
					
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}			
			}		
		
		}
		return null;
	}
	
	/**
	 * Retorna {@link ArquivoAnexoModel} de um {@link JSONObject} informado.
	 * @param jsonObject
	 * @return
	 */
	private ArquivoAnexoModel getAnexoFromJsonObject(JSONObject jsonObject) {
		ArquivoAnexoModel toReturn = null;
		
		if(jsonObject != null) {
			
			toReturn = new ArquivoAnexoModel();
			
			try {
				
				toReturn.setNomeArquivo(getStringData(ArquivoAnexoModel.NOME_ARQUIVO_FIELD, jsonObject));
				toReturn.setUrlArquivo(getStringData(ArquivoAnexoModel.URL_ARQUIVO_FIELD, jsonObject));
				
			} catch (JSONException e) {

				e.printStackTrace();
			}						
		}
		
		return toReturn;
	}
}

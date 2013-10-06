package br.com.econcursos.domain.model;

import java.io.Serializable;

/**
 * @author Paulo
 *
 */
public class ArquivoAnexoModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeArquivo;
	
	private String urlArquivo;
	
	public static final String NOME_ARQUIVO_FIELD = "n";
	public static final String URL_ARQUIVO_FIELD = "u";
	
	public ArquivoAnexoModel() {
		
		
	}
	
	/**
	 * @param nomeArquivo
	 * @param urlArquivo
	 * @param descricao
	 */
	public ArquivoAnexoModel(String nomeArquivo, String urlArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
		this.urlArquivo = urlArquivo;
	}

	/**
	 * @return the nomeArquivo
	 */
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	/**
	 * @param nomeArquivo the nomeArquivo to set
	 */
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	/**
	 * @return the urlArquivo
	 */
	public String getUrlArquivo() {
		return urlArquivo;
	}
	/**
	 * @param urlArquivo the urlArquivo to set
	 */
	public void setUrlArquivo(String urlArquivo) {
		this.urlArquivo = urlArquivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeArquivo == null) ? 0 : nomeArquivo.hashCode());
		result = prime * result
				+ ((urlArquivo == null) ? 0 : urlArquivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArquivoAnexoModel other = (ArquivoAnexoModel) obj;
		if (nomeArquivo == null) {
			if (other.nomeArquivo != null)
				return false;
		} else if (!nomeArquivo.equals(other.nomeArquivo))
			return false;
		if (urlArquivo == null) {
			if (other.urlArquivo != null)
				return false;
		} else if (!urlArquivo.equals(other.urlArquivo))
			return false;
		return true;
	}
	
	

}

package br.com.econcursos.domain.model;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Paulo
 *
 */
public class Concurso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;	
	private String titulo;
	private String descricao;	
	private String link;	
	private Set<ArquivoAnexoModel> anexos;	
	private Set<String> regioesRelacionadas;	
	private Date dataPublicacao;	
	private Fonte fonte;
	private Set<String> tags;
	private Integer totalAnexos;
	
	public static final String ID_FIELD = "_id";
	public static final String TITULO_FIELD = "t";
	public static final String DESCRICAO_FIELD = "d";
	public static final String LINK_FIELD = "l";
	public static final String ANEXOS_FIELD = "a";
	public static final String TOTAL_ANEXOS_FIELD = "ta";
	public static final String DATA_PUBLICACAO_FIELD = "dtp";
	public static final String FONTE_ID_FIELD = "f_id";
	public static final String UF_FIELD = "uf";
	public static final String TAGS_FIELD = "tg";
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the dataPublicacao
	 */
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	/**
	 * @param dataPublicacao the dataPublicacao to set
	 */
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	/**
	 * @return the regioesRelacionadas
	 */
	public Set<String> getRegioesRelacionadas() {
		return regioesRelacionadas;
	}

	/**
	 * @param regioesRelacionadas the regioesRelacionadas to set
	 */
	public void setRegioesRelacionadas(Set<String> regioesRelacionadas) {
		this.regioesRelacionadas = regioesRelacionadas;
	}

	/**
	 * @return the fonte
	 */
	public Fonte getFonte() {
		return fonte;
	}

	/**
	 * @param fonte the fonte to set
	 */
	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}


	/**
	 * @return the anexos
	 */
	public Set<ArquivoAnexoModel> getAnexos() {
		return anexos;
	}

	/**
	 * @param anexos the anexos to set
	 */
	public void setAnexos(Set<ArquivoAnexoModel> anexos) {
		this.anexos = anexos;
	}

	/**
	 * @return the tags
	 */
	public Set<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	/**
	 * @return the totalAnexos
	 */
	public Integer getTotalAnexos() {
		return totalAnexos;
	}

	/**
	 * @param totalAnexos the totalAnexos to set
	 */
	public void setTotalAnexos(Integer totalAnexos) {
		this.totalAnexos = totalAnexos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataPublicacao == null) ? 0 : dataPublicacao.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Concurso other = (Concurso) obj;
		if (dataPublicacao == null) {
			if (other.dataPublicacao != null)
				return false;
		} else if (!dataPublicacao.equals(other.dataPublicacao))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	/**
	 * Adiciona um arquivo anexo ao concurso atual
	 * @param arquivoAnexoModel
	 */
	public void addAnexo(ArquivoAnexoModel arquivoAnexoModel) {

		if(this.anexos == null) {
			this.anexos = new HashSet<ArquivoAnexoModel>();
		}
		
		this.anexos.add(arquivoAnexoModel);
	}

}

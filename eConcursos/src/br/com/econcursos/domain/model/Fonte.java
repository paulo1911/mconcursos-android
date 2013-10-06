package br.com.econcursos.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Paulo
 * 
 */
public class Fonte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String copyright;
	private String descricao;
	private String link;
	private String logo;

	private Set<Concurso> concursos = null;
	
	
	public static final String FONTE_ID_FIELD = "_id";
	public static final String FONTE_NAME_FIELD = "n";
	public static final String FONTE_DESCRICAO_FIELD = "d";
	public static final String FONTE_LINK_FIELD = "l";
	public static final String FONTE_LOGO_FIELD = "i";
	public static final String FONTE_CPYRIGHT_FIELD = "cp";
	

	public Fonte() {
	}
	
	public Fonte(String idFonte) {
		this.id = idFonte;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
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
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo
	 *            the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the concursos
	 */
	public Set<Concurso> getConcursos() {
		
		if(this.concursos == null) {
			this.concursos = new HashSet<Concurso>();
		}
		
		return this.concursos;
	}

	/**
	 * @param concursos
	 *            the concursos to set
	 */
	public void setConcursos(Set<Concurso> concursos) {
		this.concursos = concursos;
	}
	
	/**
	 * @return the copyright
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void addConcurso(Concurso... concursos) {
		
		if(this.concursos == null) {
			this.concursos = new HashSet<Concurso>();
		}
		
		for(Concurso c: concursos) {		
			this.concursos.add(c);		
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Fonte other = (Fonte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}

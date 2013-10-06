package br.com.econcursos.webservice.model;

import java.util.List;

import br.com.econcursos.domain.model.Concurso;
import br.com.econcursos.util.PageDescriptorWS;

/**
 * @author Paulo
 *
 */
public class ConcursosWS {
	
	private PageDescriptorWS pageDescriptor;
	
	public static final String RESPONSE = "res";
	public static final String CONCURSOS_LIST = "cs";
	public static final String CONCURSO_SINGLE = "c";
	

	private List<Concurso> concursos;	

	private Concurso concurso;
	
	public void setConcursos(List<Concurso> concursos) {
		this.concursos = concursos;
		
	}
	/**
	 * @return the concursos
	 */
	public List<Concurso> getConcursos() {
		return concursos;
	}

	/**
	 * @return the concursos
	 */
	public Concurso getConcurso() {
		return concurso;
	}
	
	/**
	 * @return the concursos
	 */
	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}
	
	/**
	 * @return the pageDescriptor
	 */
	public PageDescriptorWS getPageDescriptorWS() {
		return pageDescriptor;
	}
	
	/**
	 * @param pageDescriptor the pageDescriptor to set
	 */
	public void setPageDescriptorWS(PageDescriptorWS pageDescriptor) {
		this.pageDescriptor = pageDescriptor;
	}	
}

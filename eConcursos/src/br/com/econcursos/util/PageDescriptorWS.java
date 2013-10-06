package br.com.econcursos.util;

import java.io.Serializable;

/**
 * Classe modelo para retornar o page Descriptor
 * @author Paulo
 *
 */
public class PageDescriptorWS implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String PAGE_DESCRIPTOR_ELEMENT = "pd";
	public static final String FIELD_PAGE = "p";
	public static final String FIELD_TOTAL_ENTRIES = "te";
	public static final String FIELD_PAGESIZE = "ps";
	
	private Integer page = 1;

	private Long totalEntries = 0L;

	private Integer pageSize = 0;
	
	/**
	 * 
	 */
	public PageDescriptorWS() {
	}
	/**
	 * @param page
	 * @param totalEntries
	 * @param pageSize
	 */
	public PageDescriptorWS(Integer page, Long totalEntries, Integer pageSize) {
		super();
		this.page = page;
		this.totalEntries = totalEntries;
		this.pageSize = pageSize;
	}
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the totalEntries
	 */
	public Long getTotalEntries() {
		return totalEntries;
	}
	/**
	 * @param totalEntries the totalEntries to set
	 */
	public void setTotalEntries(Long totalEntries) {
		this.totalEntries = totalEntries;
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}	
	
}

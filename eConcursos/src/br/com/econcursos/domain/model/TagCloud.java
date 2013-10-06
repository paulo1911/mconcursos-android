package br.com.econcursos.domain.model;


import java.io.Serializable;
import java.util.Date;

/**
 * @author Paulo
 *
 */
public class TagCloud implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String tag;
	private Long rate;
	private Date createDate;
	private Date lastUpdate;
	
	public static final String FIELD_ID = "_id";
	public static final String FIELD_TAG = "t";
	public static final String FIELD_RATE = "r";
	public static final String FIELD_CREATE_DATE = "c";
	public static final String FIELD_LAST_UPDATE = "u";
	
	public TagCloud(){
		
	}
	
	public TagCloud(String tag){
		this.tag = tag;
	}	
	
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
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the rate
	 */
	public Long getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(Long rate) {
		this.rate = rate;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}
	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		TagCloud other = (TagCloud) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	
}

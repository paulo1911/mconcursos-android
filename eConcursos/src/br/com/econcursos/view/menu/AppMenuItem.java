/**
 * 
 */
package br.com.econcursos.view.menu;

import java.io.Serializable;

/**
 * @author Paulo
 *
 */
public 	class AppMenuItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String labelMenu;
	private int imgResourse;
	
	/**
	 * @return the labelMenu
	 */
	public String getLabelMenu() {
		return labelMenu;
	}
	/**
	 * @param labelMenu the labelMenu to set
	 */
	public void setLabelMenu(String labelMenu) {
		this.labelMenu = labelMenu;
	}
	/**
	 * @return the imgResourse
	 */
	public int getImgResourse() {
		return imgResourse;
	}
	/**
	 * @param imgResourse the imgResourse to set
	 */
	public void setImgResourse(int imgResourse) {
		this.imgResourse = imgResourse;
	}	
	
}
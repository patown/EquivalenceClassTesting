package com.comb.dataset.beans;

import java.util.List;

public class ItemBean {
	private List VECList ;
	private	List IECList ;
	private String name;
	public ItemBean(String name){
		this.name=name;
	}
	public List getVECList() {
		return VECList;
	}
	public List getIECList() {
		return IECList;
	}
	public ItemBean setVECList(List vECList) {
		VECList = vECList;
		return this;
	}
	public ItemBean setIECList(List iECList) {
		IECList = iECList;
		return this;
	}
	public String getName() {
		return name;
	}
	
}

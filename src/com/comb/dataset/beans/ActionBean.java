package com.comb.dataset.beans;


import java.util.List;


public class ActionBean {
    private List<ItemBean> itemBeans;
    private String name;
    private String comb="0";
    /**
     * 
     * @param name  
     * and using  WEAK_NORNAMAL("0") by default
     */
    public ActionBean(String name) {
        this.name = name;
    }
    /**
     * 
     * @param name  
     * @param comb 	AllComb("0"),EachChoice("1"),Pairwise("2"); default is "0"
     */
    public ActionBean(String name,String comb) {
        this.name = name;
        if (null!=comb){
        this.comb=comb;
        }
    }
    public String getName() {
        return this.name;
    }
	public List<ItemBean> getItemBeans() {
		return itemBeans;
	}
	public void setItemBeans(List<ItemBean> itemBeans) {
		this.itemBeans = itemBeans;
	}
	public String getComb() {
		return comb;
	}
	public void setComb(String comb) {
		this.comb = comb;
	}
	

}

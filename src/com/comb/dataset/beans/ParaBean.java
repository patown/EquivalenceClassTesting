package com.comb.dataset.beans;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParaBean {
    private HashMap<String, List> VECParas = new HashMap<String, List>();
    private HashMap<String, List> IECParas = new HashMap<String, List>();
    private String name;
    public ParaBean(String name) {
        this.name = name;
    }
	public HashMap<String, List> getVECParas() {
		return VECParas;
	}
	public HashMap<String, List> getIECParas() {
		return IECParas;
	}
	public ParaBean setVECParas(HashMap<String, List> vECParas) {
		VECParas = vECParas;
		return this;
	}
	public ParaBean setIECParas(HashMap<String, List> iECParas) {
		IECParas = iECParas;
		return this;
	}

    public String getName() {
        return this.name;
    }

}

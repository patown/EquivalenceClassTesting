package com.comb.dataset;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.comb.dataset.beans.ParaBean;




public class TestParaBean {
	private List idVECList ;
	private	List idIECList ;
	private	List<Integer> VECList_isActive;
	private	List<Integer> IECList_isActive;
	ParaBean bean = new ParaBean("bean");
	HashMap<String, List> VECParas = new HashMap<>();	
	HashMap<String, List> IECParas = new HashMap<>();	
	@Test
	public void TestBean(){

		String[] id_vec= new String[]{"a","123456789"};
		String[] id_iec= new String[]{"",null};

		Integer[] isActive_vec= new Integer[]{0,1};
		Integer[] isActive_iec= new Integer[]{-1,2};	

		idVECList =Arrays.asList(id_vec);
		idIECList =Arrays.asList(id_iec);	
		VECList_isActive =Arrays.asList(isActive_vec);
		IECList_isActive=Arrays.asList(isActive_iec);
		

		VECParas.put("id", idVECList);
		VECParas.put("isActive",VECList_isActive);
		IECParas.put("id", idIECList);
		IECParas.put("isActive",IECList_isActive);
		
		bean.setIECParas(IECParas).setVECParas(VECParas);
		

		System.out.println(bean.getIECParas().get("id").toString());
		System.out.println(bean.getIECParas().get("isActive").toString());

		
	}
}

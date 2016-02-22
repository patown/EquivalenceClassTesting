package com.comb.dataset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.AllCombinations;
import main.EachChoice;

import org.junit.Before;
import org.junit.Test;

import com.comb.dataset.beans.CombDataSetBean;
import com.comb.dataset.beans.ParaBean;

public class TestCombBean {
	private List idVECList ;
	private	List idIECList ;
	private	List VECList_isActive;
	private	List IECList_isActive;
	//private	List<Integer> VECList_isActive;
	//private	List<Integer> IECList_isActive;
	ParaBean bean = new ParaBean("name");
	HashMap<String, List> VECParas = new HashMap<>();	
	HashMap<String, List> IECParas = new HashMap<>();
	private CombDataSetBean combBean;
	@Before
	public void setBeans(){

		String[] id_vec= new String[]{"a","a123456789"};
		String[] id_iec= new String[]{"",null,"a123456789a123456789"};

		String[] isActive_vec= new String[]{"0","1"};
		String[] isActive_iec= new String[]{"-1","2",Integer.toString(Integer.MAX_VALUE),Integer.toString(Integer.MIN_VALUE)};
// 		Integer[] isActive_vec= new Integer[]{0,1};
// 		Integer[] isActive_iec= new Integer[]{-1,2};	

		idVECList =Arrays.asList(id_vec);
		idIECList =Arrays.asList(id_iec);	
		VECList_isActive =Arrays.asList(isActive_vec);
		IECList_isActive=Arrays.asList(isActive_iec);
		

		VECParas.put("id", idVECList);
		VECParas.put("isActive",VECList_isActive);
		IECParas.put("id", idIECList);
		IECParas.put("isActive",IECList_isActive);
		
		bean.setIECParas(IECParas).setVECParas(VECParas);
	}
	
	@Test
	public void TestBean(){
		String key="isActive";
		combBean = new CombDataSetBean(bean,"test");
	Map<String, List> map=	combBean.getListIEC(key);
		List<List<String>> list = new ArrayList<>() ;
		for(List value:map.values()){
			list.add(value);
		}
		EachChoice eachChoice = new EachChoice(list);
		Set<List<String>> expectedResults =eachChoice.getCombinations();
		System.out.println("****VEC(valid   equivalence class)****");
		System.out.println(VECParas.toString());
		System.out.println("****IEC(invalid equivalence class)****");
		System.out.println(IECParas.toString());
		System.out.println("****EachChoice("+key+")****");
		System.out.println(expectedResults.toString());
	}
}

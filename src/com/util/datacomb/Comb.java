package com.util.datacomb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.comb.dataset.beans.CombDataSetBean;
import com.util.DataUtils;
import com.util.datacomb.CombType;

import main.AllCombinations;
import main.Criteria;
import main.EachChoice;
import main.Pairwise;

public class Comb {

	/**
	 * 
	 * @param dataset
	 * @return Set<List<String>> result set. Using STRONG_NORNAMAL by default
	 */
	public static Set<List<String>> genResultSet(CombDataSetBean dataset) {
		Set<List<String>> expectedResults = new HashSet<List<String>>();
		CombType combType = dataset.getCombType();
		if (null == combType) {
			combType = CombType.STRONG_NORNAMAL;
		}
		switch (combType) {
		case STRONG_NORNAMAL:
			expectedResults = getStrongNormal(dataset);
			break;
		case STRONG_ROBUST:
			expectedResults = getStrongRobust(dataset);
			break;
		case WEAK_NORNAMAL:
			expectedResults = getWeakNormal(dataset);
			break;
		case WEAK_ROBUST:
			expectedResults = getWeakRobust(dataset);
			break;
		default:
		}

		return expectedResults;
	}

	private static Set<List<String>> getStrong(CombDataSetBean dataset) {
		Map<String, Map<String, List>> mapIEC = dataset.getMapIEC();
		Set<List<String>> resultStrong = new HashSet<>();
		List<List<String>> list = new ArrayList<>();
		Set<String> keyset = mapIEC.keySet();
		String key;
		for (Iterator it = keyset.iterator(); it.hasNext();) {
			key = (String) it.next();
			list = DataUtils.genListFromMap(mapIEC.get(key));
			Criteria criteria = new AllCombinations(list);
			resultStrong.addAll(criteria.getCombinations());
		}
		return resultStrong;
	}

	public static Set<List<String>> getStrongNormal(CombDataSetBean dataset) {
		AllCombinations allComb = new AllCombinations(dataset.getListVEC());
		return allComb.getCombinations();
	}

	public static Set<List<String>> getStrongRobust(CombDataSetBean dataset) {
		Set<List<String>> resultStrongRobust = new HashSet<>();
		AllCombinations robustComb = new AllCombinations(
				dataset.getAllIECList());
		resultStrongRobust = robustComb.getCombinations(); // Robust
		// AllCombinations allComb = new AllCombinations(dataset.getListVEC());
		resultStrongRobust.addAll(getStrong(dataset));
		return resultStrongRobust;
	}

	public static Set<List<String>> getWeakNormal(CombDataSetBean dataset) {
		EachChoice eachChoice = new EachChoice(dataset.getListVEC());
		return eachChoice.getCombinations();

	}

	public static Set<List<String>> getWeakRobust(CombDataSetBean dataset) {
		Map<String, Map<String, List>> mapIEC = dataset.getMapIEC();
		Set<List<String>> resultWeakRobust = new HashSet<>();
		List<List<String>> list = new ArrayList<>();
		Set<String> keyset = mapIEC.keySet();
		String key;
		for (Iterator it = keyset.iterator(); it.hasNext();) {
			key = (String) it.next();
			list = DataUtils.genListFromMap(mapIEC.get(key));
			EachChoice eachChoice = new EachChoice(list);
			resultWeakRobust.addAll(eachChoice.getCombinations());
		}
		return resultWeakRobust;
	}

}

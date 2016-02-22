package com.util.datacomb;

public enum CombType {
	WEAK_NORNAMAL("0"),STRONG_NORNAMAL("1"),WEAK_ROBUST("2"),STRONG_ROBUST("3");
	public String type;
	CombType(String type){
		this.type=type;
	}
	public String toString(){
		return type;
	}
}

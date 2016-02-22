package com.util.datacomb;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ECTesting {
	public abstract Set<List<String>>  getWeakNormal();
	public abstract Set<List<String>>  getStrongNormal();
	public abstract Set<List<String>>  getWeakRobust();
	public abstract Set<List<String>>  getStrongRobust();
}

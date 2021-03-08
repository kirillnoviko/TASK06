package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Criteria<E> {// new Criteria<SC.Oven>()

	//Class searchType;
	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}
	

	public Set<Entry<E, Object>> getCriteria() {

		return criteria.entrySet();
	}
	// you may add your own code here

}

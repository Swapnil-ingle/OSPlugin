package com.krishagni.openspecimen;

import java.util.Map;
import java.util.HashMap;

public class Record {
	private Map<String, Object> records = new HashMap<String, Object>();

	public void addRecord(String column, Object value) {
		records.put(column, value);
	}

	public Map<String, Object> getRecords() {
		return records;
	}
	
}



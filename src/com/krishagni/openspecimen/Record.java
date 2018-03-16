package com.krishagni.openspecimen;

import java.util.Map;
import java.util.HashMap;

public class Record {
	private Map<String, Object> fields = new HashMap<String, Object>();

	public void addField(String string, Object object) {
		fields.put(string, object);
	}

	public Map<String, Object> getFields() {
		return fields;
	}
	
}



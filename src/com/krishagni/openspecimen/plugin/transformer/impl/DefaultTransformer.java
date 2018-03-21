package com.krishagni.openspecimen.plugin.transformer.impl;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishagni.openspecimen.plugin.core.Metadata;
import com.krishagni.openspecimen.plugin.core.Record;
import com.krishagni.openspecimen.plugin.core.Metadata.Field;
import com.krishagni.openspecimen.plugin.transformer.Transformer;

public class DefaultTransformer implements Transformer {
	private Metadata metadata;
	
	private ObjectMapper objMapper = new ObjectMapper();
	
	public DefaultTransformer(Metadata metaData) {
		this.metadata = metaData;
	}

	public <T> T transform(Record record, Class<T> objectType){
		Map<String, Object> attrValueMap = new HashMap<>();
		
		for (Field columnMetadata : metadata.getFields()) {
			if (record.getValue(columnMetadata.getColumn()) != null) {

				attrValueMap.put(columnMetadata.getAttribute(), record.getValue(columnMetadata.getColumn()));
		
//				rowData.remove(columnMetadata.getColumn());
			} else {
				System.out.println("Error: A field present in Metadata doesn't occur in Record.");
				System.exit(0);
			}
		}

//		assert(rowData.isEmpty()):"Error: A field is present in record that doesn't have mapping in Metadata.";
		
		return objMapper.convertValue(attrValueMap, objectType);
	}

}

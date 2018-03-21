package com.krishagni.openspecimen.plugin.transformer.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
				if (columnMetadata.getType()=="datetime") {
					Date date = parseToDate(record.getValue(columnMetadata.getColumn()),columnMetadata.getFormat());
					attrValueMap.put(columnMetadata.getAttribute(),date);
				} else {
					attrValueMap.put(columnMetadata.getAttribute(), record.getValue(columnMetadata.getColumn()));
				}
//				rowData.remove(columnMetadata.getColumn());
			} else {
				System.out.println("Error: A field present in Metadata doesn't occur in Record.");
				System.exit(0);
			}
		}

//		assert(rowData.isEmpty()):"Error: A field is present in record that doesn't have mapping in Metadata.";
		
		return objMapper.convertValue(attrValueMap, objectType);
	}

	private Date parseToDate(Object value, String format) {
		Date date = null;
		
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			date = simpleDateFormat.parse((String) value);
			
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

}

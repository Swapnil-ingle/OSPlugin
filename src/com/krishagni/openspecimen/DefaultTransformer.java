package com.krishagni.openspecimen;

import java.util.Map;

import com.krishagni.openspecimen.Metadata.Field;

public class DefaultTransformer <T> implements Transformer <T> {
	
	private Metadata metadata;
	
	public DefaultTransformer(Metadata metaData) {
		this.metadata = metaData;
		
	}
	
	public <T> T transform(Record record, Class<T> className) {
		System.out.format("%15s %15s %25s","Column","Attribute","Value\n");
		Map<String, Object> records = record.getFields();

		for(Field iterator: metadata.fields) {
			Field currentObj = iterator;

			if(records.get(currentObj.getColumn()) != null) {
				System.out.format("%15s %15s %25s",currentObj.getColumn(),
						currentObj.getAttribute(),records.get(currentObj.getColumn())+"\n");
				records.remove(currentObj.getColumn());
			} else {
				System.out.println("Error: A field present in Metadata doesn't occur in Record.");
				System.exit(0);
			}
		}
		
		assert(records.isEmpty()):"Error: A field is present in record that doesn't have mapping in Metadata.";
		
		return null;
	}

}

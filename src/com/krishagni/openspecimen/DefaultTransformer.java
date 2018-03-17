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
		Map<String, Object> rowData = record.getRecords();

		for(Field columnMetadata : metadata.fields) {
			if(rowData.get(columnMetadata.getColumn()) != null) {
				System.out.format("%15s %15s %25s", columnMetadata.getColumn(),
						columnMetadata.getAttribute(), rowData.get(columnMetadata.getColumn())+"\n");
				rowData.remove(columnMetadata.getColumn());
			} else {
				System.out.println("Error: A field present in Metadata doesn't occur in Record.");
				System.exit(0);
			}
		}
		
		assert(rowData.isEmpty()):"Error: A field is present in record that doesn't have mapping in Metadata.";
		
		return null;
	}

}

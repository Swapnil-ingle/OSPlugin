package com.krishagni.openspecimen.plugin.core;

import com.krishagni.openspecimen.plugin.core.Metadata.Field;
import com.krishagni.openspecimen.plugin.transformer.Transformer;
import com.krishagni.openspecimen.plugin.transformer.impl.DefaultTransformer;

public class InstituteImporter {

	public static void main (String[] args) throws Exception {			
		Metadata instituteMetadata = new Metadata();
		
		Field idMetadata = instituteMetadata.new Field();
		idMetadata.setAttribute("id");
		idMetadata.setColumn("Identifier");
		idMetadata.setType("Long");
		instituteMetadata.addField(idMetadata);
		
		Field nameMetadata = instituteMetadata.new Field();
		nameMetadata.setAttribute("name");
		nameMetadata.setColumn("Institute Name");
		nameMetadata.setType("String");
		instituteMetadata.addField(nameMetadata);

		Record record = new Record();

		record.add("Identifier", 25L);
		record.add("Institute Name", "Brand New Institute");

		Transformer transformer = new DefaultTransformer(instituteMetadata);
		InstituteDetail detail = transformer.transform(record,InstituteDetail.class);
		//
		//Testing Output
		//
		System.out.println(detail.getId());
		System.out.println(detail.getName());
	}

}

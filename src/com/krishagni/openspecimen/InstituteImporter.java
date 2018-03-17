package com.krishagni.openspecimen;

import com.krishagni.openspecimen.Metadata.Field;

public class InstituteImporter {

	public static void main (String[] args) {			
		Metadata instituteMetadata = new Metadata();
		
		Field idMetadata = instituteMetadata.new Field();
		idMetadata.setAttribute("id");
		idMetadata.setColumn("Identifier");
		idMetadata.setType("int");
		instituteMetadata.addField(idMetadata);

		
		Field nameMetadata = instituteMetadata.new Field();
		nameMetadata.setAttribute("name");
		nameMetadata.setColumn("Institute Name");
		nameMetadata.setType("String");
		instituteMetadata.addField(nameMetadata);
		
		Field siteMetadata = instituteMetadata.new Field();
		siteMetadata.setAttribute("site");
		siteMetadata.setColumn("Site Name");
		siteMetadata.setType("String");
		instituteMetadata.addField(siteMetadata);
		
		Record record = new Record();
				
		record.addRecord("Identifier", 25);
		record.addRecord("Institute Name", "Brand New Institute");
		record.addRecord("Site Name", "New Site");

		Transformer transformer = new DefaultTransformer(instituteMetadata);
		transformer.transform(record, InstituteDetail.class);
	}

}

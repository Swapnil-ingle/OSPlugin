package com.krishagni.openspecimen;

public interface Transformer <T> {
	<T> T transform(Record record, Class <T> className);
}

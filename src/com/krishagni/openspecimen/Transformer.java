package com.krishagni.openspecimen;

public interface Transformer{
	<T> T transform(Record record, Class<T> objectType);
}

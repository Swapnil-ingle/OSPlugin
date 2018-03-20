package com.krishagni.openspecimen.plugin.transformer;

import com.krishagni.openspecimen.plugin.core.Record;

public interface Transformer{
	<T> T transform(Record record, Class<T> objectType);
}

package com.jodo.notify.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultObjectBuilder<T> {
	public T build(ResultSet rs) throws SQLException;
}

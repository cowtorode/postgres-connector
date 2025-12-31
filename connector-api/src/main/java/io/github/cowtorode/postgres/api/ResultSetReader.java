package io.github.cowtorode.postgres.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetReader {
	void read(ResultSet result) throws SQLException;
}

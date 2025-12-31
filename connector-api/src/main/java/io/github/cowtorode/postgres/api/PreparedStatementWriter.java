package io.github.cowtorode.postgres.api;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementWriter {
	void write(PreparedStatement stmt) throws SQLException;
}

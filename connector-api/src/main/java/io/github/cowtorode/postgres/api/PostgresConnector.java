package io.github.cowtorode.postgres.api;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PostgresConnector {
	void prepareStatement(String command, PreparedStatementWriter writer) throws SQLException;

	void query(PreparedStatement stmt, ResultSetReader reader) throws SQLException;

	void close() throws SQLException;
}

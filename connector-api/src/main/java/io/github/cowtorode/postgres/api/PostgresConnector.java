package io.github.cowtorode.postgres.api;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PostgresConnector {
	boolean getAutoCommit() throws SQLException;

	void setAutoCommit(boolean autoCommit) throws SQLException;

	void commit() throws SQLException;

	void rollback() throws SQLException;

	void prepare(String statement, PreparedStatementWriter writer) throws SQLException;

	void query(PreparedStatement statement, ResultSetReader reader) throws SQLException;

	void close() throws SQLException;
}

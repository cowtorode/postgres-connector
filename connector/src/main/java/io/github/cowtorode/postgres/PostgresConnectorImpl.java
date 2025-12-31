package io.github.cowtorode.postgres;

import io.github.cowtorode.postgres.api.PostgresConnector;
import io.github.cowtorode.postgres.api.PreparedStatementWriter;
import io.github.cowtorode.postgres.api.ResultSetReader;

import java.sql.*;

public class PostgresConnectorImpl implements PostgresConnector {
	private final Connection connection;

    public PostgresConnectorImpl(String url, String username, String password) throws SQLException {
		this.connection = DriverManager.getConnection(url, username, password);
    }

	@Override
	public void prepareStatement(String command, PreparedStatementWriter writer) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(command);

		writer.write(stmt);

		stmt.close();
	}

	@Override
	public void query(PreparedStatement stmt, ResultSetReader reader) throws SQLException {
		ResultSet result = stmt.executeQuery();

		reader.read(result);

		result.close();
	}

	@Override
	public void close() throws SQLException {
		connection.close();
	}
}

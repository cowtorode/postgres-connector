package io.github.cowtorode.postgres;

import io.github.cowtorode.postgres.api.PostgresConnector;
import io.github.cowtorode.postgres.api.PreparedStatementWriter;
import io.github.cowtorode.postgres.api.ResultSetReader;

import java.sql.*;

public class PostgresConnectorImpl implements PostgresConnector {
	private final Connection connection;
	private boolean lastAutoCommit;

    public PostgresConnectorImpl(String url, String username, String password) throws SQLException {
		connection = DriverManager.getConnection(url, username, password);
    }

	@Override
	public boolean getAutoCommit() throws SQLException {
		return connection.getAutoCommit();
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		connection.setAutoCommit(autoCommit);
	}

	@Override
	public void commit() throws SQLException {
		connection.commit();
	}

	@Override
	public void rollback() throws SQLException {
		connection.rollback();
	}

	@Override
	public void prepare(String statement, PreparedStatementWriter writer) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(statement);

		writer.write(preparedStatement);

		preparedStatement.close();
	}

	@Override
	public void query(PreparedStatement statement, ResultSetReader reader) throws SQLException {
		ResultSet set = statement.executeQuery();

		reader.read(set);

		set.close();
	}

	@Override
	public void close() throws SQLException {
		connection.close();
	}
}

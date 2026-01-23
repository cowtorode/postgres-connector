package io.github.cowtorode.postgres.example;

import io.github.cowtorode.postgres.PostgresConnectorImpl;
import io.github.cowtorode.postgres.api.PostgresConnector;

import java.sql.SQLException;

public class ConnectorTest {
	public static void main(String[] args) {
		try {
			String url = System.getenv("DATABASE_URL");
			String username = System.getenv("DATABASE_USERNAME");
			String password = System.getenv("DATABASE_PASSWORD");

			PostgresConnector connector = new PostgresConnectorImpl(url, username, password);

			connector.close();
		} catch (SQLException sql) {
			System.err.println("Failed to connect: " + sql.getMessage());
		}
	}
}

package br.com.siam.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides JDBC connections to the Supabase PostgreSQL database.
 *
 * Configure SUPABASE_DB_URL, SUPABASE_DB_USER and SUPABASE_DB_PASSWORD
 * as environment variables before starting the application.
 */
public final class DatabaseConnection {

    private static final String URL = requireEnvironmentVariable("SUPABASE_DB_URL");
    private static final String USER = requireEnvironmentVariable("SUPABASE_DB_USER");
    private static final String PASSWORD = requireEnvironmentVariable("SUPABASE_DB_PASSWORD");

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static String requireEnvironmentVariable(String variableName) {
        String value = System.getenv(variableName);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Required environment variable is not configured: " + variableName
            );
        }

        return value;
    }
}

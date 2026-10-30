package br.com.siam.config;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class DatabaseConnectionSmokeTest {

    private static final Set<String> REQUIRED_TABLES = Set.of(
            "app_user",
            "gas_station",
            "gas_pump",
            "fiscalization",
            "next_steps",
            "photo_evidence"
    );

    @Test
    void shouldConnectToSupabaseAndFindInitialSchema() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            assertTrue(connection.isValid(5), "JDBC connection should be valid");

            DatabaseMetaData metadata = connection.getMetaData();
            assertTrue(
                    "PostgreSQL".equalsIgnoreCase(metadata.getDatabaseProductName()),
                    "Expected a PostgreSQL database"
            );

            Set<String> foundTables = new java.util.HashSet<>();
            try (ResultSet tables = metadata.getTables(
                    connection.getCatalog(),
                    "public",
                    "%",
                    new String[]{"TABLE"}
            )) {
                while (tables.next()) {
                    foundTables.add(tables.getString("TABLE_NAME"));
                }
            }

            Set<String> missingTables = new java.util.HashSet<>(REQUIRED_TABLES);
            missingTables.removeAll(foundTables);

            assertTrue(
                    missingTables.isEmpty(),
                    "Missing tables in public schema: " + missingTables
            );

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT 1")) {
                assertTrue(resultSet.next());
                assertTrue(resultSet.getInt(1) == 1);
            }
        } catch (IllegalStateException exception) {
            fail("Set SUPABASE_DB_URL, SUPABASE_DB_USER and SUPABASE_DB_PASSWORD before running the test.", exception);
        }
    }
}

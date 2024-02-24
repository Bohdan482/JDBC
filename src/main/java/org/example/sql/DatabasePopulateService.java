package org.example.sql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Connection connection = Database.getINSTANCE().getConnection();
        String sql = null;
        try {
            sql = String.join("\n", Files.readAllLines(Path.of("populate_db.sql")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}

package Storage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final Database INSTANCE = new Database();

    private Connection connection;
    private Database(){
        try {
            String dbUrl = "jdbc:h2:./test";
            connection = DriverManager.getConnection(dbUrl);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Database getINSTANCE() {
        return INSTANCE;
    }

    public Connection getConnection(){
        return  connection;
    }
}

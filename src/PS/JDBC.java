
package PS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

    public static Connection Con() throws SQLException {

        String url =
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=java_june_25;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "loginTimeout=10;";

        String username = "moni";
        String password = "moni3204";

        return DriverManager.getConnection(
            url, username, password
        );
    }
}

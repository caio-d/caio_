import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class connect {

    public Connection getConnect() {

        try {
            final String url = "jdbc:mysql://localhost/usuario";
            final String user = "root";
            final String password = "cabalfera55";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
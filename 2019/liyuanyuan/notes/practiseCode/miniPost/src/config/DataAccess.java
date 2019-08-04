package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class DataAccess {

    private static ComboPooledDataSource dataSource;

    static {
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("BBS201315");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/postdata?useUnicode=true&characterEncoding=utf-8");
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("can not get database connection  ", e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}

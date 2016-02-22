package shop.DBManager;


import java.sql.*;

public class DBManager {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://test/test?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASS = "r00tP@ss";
    private static DBManager dbManager;
    private static Connection conn;
    private static Statement stmt;

    private DBManager(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String createDatabaseQuery = "";
            stmt.execute(createDatabaseQuery);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC driver is not in the selected folder");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    public static DBManager getDbManager(){
        if (dbManager == null){
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public static void executeDBUpdate(String sql){
        DBManager.getDbManager();
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        }
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("JDBC driver is not in the selected folder");
//        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    public static ResultSet selectData(String sql){
        DBManager.getDbManager();
        ResultSet rs = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

        }
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("JDBC driver is not in the selected folder");
//        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se) {
                    se.printStackTrace();
                }
            }
            return rs;
        }
    }
}

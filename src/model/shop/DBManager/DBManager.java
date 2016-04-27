package model.shop.DBManager;


import java.sql.*;

class DBManager {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/photoworld";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static DBManager dbManager;
    private static Connection conn;
    private static Statement stmt;
   
    private DBManager(){
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
            StringBuilder sql = new StringBuilder();
            sql.append("CREATE SCHEMA IF NOT EXISTS photoworld DEFAULT CHARACTER SET utf8; ");
            sql.append("USE photoworld; ");
            stmt = conn.prepareStatement(sql.toString());
            sql.setLength(0);
            sql.append("CREATE TABLE IF NOT EXISTS categories");
            sql.append("(id INT NOT NULL AUTO_INCREMENT,");
            sql.append("category_name VARCHAR(45) NOT NULL,");
            sql.append("PRIMARY KEY (id));");
            stmt.execute(sql.toString());
            sql.setLength(0);
            sql.append("CREATE TABLE IF NOT EXISTS photoworld.subcategories (");
            sql.append("id INT NOT NULL AUTO_INCREMENT,");
            sql.append("subcategory VARCHAR(45) NOT NULL,");
            sql.append("categories_id INT NOT NULL,");
            sql.append("PRIMARY KEY (id),");
            sql.append("INDEX fk_subcategories_categories1_idx (categories_id ASC),");
            sql.append("CONSTRAINT fk_subcategories_categories1 ");
            sql.append("FOREIGN KEY (categories_id)");
            sql.append("REFERENCES photoworld.categories (id));");
            stmt.execute(sql.toString());
            sql.setLength(0);
            sql.append("CREATE TABLE IF NOT EXISTS photoworld.products (");
            sql.append("id INT NOT NULL AUTO_INCREMENT,");
            sql.append("brand VARCHAR(45) NOT NULL,");
            sql.append("model VARCHAR(45) NULL,");
            sql.append("description MEDIUMTEXT NULL,");
            sql.append("amountInstock INT NOT NULL,");
            sql.append("price DOUBLE NULL,");
            sql.append("warranty_months INT NULL,");
            sql.append("subcategories_id INT NOT NULL,");
            sql.append("image MEDIUMBLOB NULL,");
            sql.append("PRIMARY KEY (id),");
            sql.append("INDEX fk_product_subcategories1_idx (subcategories_id ASC),");
            sql.append("CONSTRAINT fk_product_subcategories1 ");
            sql.append("FOREIGN KEY (subcategories_id) ");
            sql.append("REFERENCES photoworld.subcategories (id));");
            stmt.execute(sql.toString());
            sql.setLength(0);
            sql.append("CREATE TABLE IF NOT EXISTS photoworld.customers (");
            sql.append("username VARCHAR(16) NOT NULL,");
            sql.append("password VARCHAR(16) NOT NULL,");
            sql.append("email VARCHAR(45) NOT NULL,");
            sql.append("first_name VARCHAR(45) NOT NULL,");
            sql.append("last_name VARCHAR(45) NOT NULL,");
            sql.append("phone VARCHAR(45) NOT NULL,");
            sql.append("town VARCHAR(45) NOT NULL,");
            sql.append("street_name VARCHAR(45) NOT NULL,");
            sql.append("street_number INT NULL,");
            sql.append("UNIQUE INDEX username_UNIQUE (username ASC),");
            sql.append("UNIQUE INDEX email_UNIQUE (email ASC),");
            sql.append("PRIMARY KEY (username));");
            stmt.execute(sql.toString());
            sql.setLength(0);
            sql.append("CREATE TABLE IF NOT EXISTS photoworld.orders (");
            sql.append("id INT NOT NULL AUTO_INCREMENT,");
            sql.append("customers_username VARCHAR(16) NOT NULL,");
            sql.append("date_time DATETIME NOT NULL,");
            sql.append("details MEDIUMTEXT NULL,");
            sql.append("PRIMARY KEY (id),");
            sql.append("INDEX fk_orders_customers1_idx (customers_username ASC),");
            sql.append("CONSTRAINT fk_orders_customers1 ");
            sql.append("FOREIGN KEY (customers_username)");
            sql.append("REFERENCES photoworld.customers (username));");
            stmt.execute(sql.toString());
            sql.setLength(0);
            sql.append("CREATE TABLE IF NOT EXISTS photoworld.product_admins (");
            sql.append("username VARCHAR(20) NOT NULL,");
            sql.append("password VARCHAR(20) NOT NULL,");
            sql.append("PRIMARY KEY (username));");
            stmt.execute(sql.toString());
         

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC driver is not in the selected folder");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
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

    public static synchronized DBManager getDbManager(){
        if (dbManager == null){
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public static void executeDBUpdate(String sql){
        try (Statement stmt = DriverManager.getConnection(DB_URL, USER, PASS).createStatement()){
        	System.out.println(sql);
           stmt.execute(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
	public static ResultSet selectData(String sql){
        ResultSet rs = null;
        try (Statement stmt = DriverManager.getConnection(DB_URL, USER, PASS).createStatement()){
          rs = stmt.executeQuery(sql);
          return rs;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
	}
		
	public Connection getConnection(){
		return conn;
	}
}

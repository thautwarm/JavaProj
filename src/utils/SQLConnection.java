package utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
public class SQLConnection {
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Connection getConnection(){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		}
		catch (SQLException e){
		e.printStackTrace();
		}
	
		return conn;
	}
	
}

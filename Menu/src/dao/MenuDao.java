package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class MenuDao {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/menu";
	public static final String USER="root";
    public static final String PWD="root";
    
    Connection getCon() throws ClassNotFoundException,SQLException
    {
    	Class.forName(DRIVER);
		Connection con=DriverManager.getConnection(URL,USER,PWD);
		return con;
    }
    
    public Result getList(String sql)
    {
    	Result result = null;
    	try
    	{
    		Connection con = getCon();
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		result = ResultSupport.toResult(rs);
    	} catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    }
    
    public int update(String sql)
    {
    	int result = 0;
    	try
    	{
    		Connection con = getCon();
    		Statement stmt = con.createStatement();
    		result = stmt.executeUpdate(sql);
    	} catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    }
}

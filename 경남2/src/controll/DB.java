package controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DB {
	public static Statement stmt;
	public static Connection con;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
			stmt = con.createStatement();
			stmt.execute("use parttimecat;");
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void setPre(PreparedStatement p, Object...objects) {
		int i = 0;
		for (Object object : objects) {
			try {
				p.setObject(++i, object);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

package mis.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * �������ݿ�
 * @author ħ��
 *
 */
public class SqlConnection {
	//���ӵ�ַ���û���������
//	private static final String url="jdbc:mysql://47.94.172.191:3306/db_studentmis";
	private static final String url="jdbc:mysql://localhost/db_studentmis";
	private static final String name="root";
	private static final String password="123456";
	private static Connection connection;
	public static Connection getConnection() {
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���ݿ�����
			connection=DriverManager.getConnection(url,name,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}
}

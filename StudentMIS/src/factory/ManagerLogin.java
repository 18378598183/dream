package factory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import mis.tool.SqlConnection;
/**
 * ����Աʵ����
 * �̳нӿڣ�����ʵ�ֵ�¼��֤
 */
public class ManagerLogin extends User implements UserLogin{
	@Override
	public void LoginCheck() {
		//sqlԭ������Ϊʵ�������������ΪaccountҲ��ʵ��������δ��ʼ��������sqlΪ�ա�ͬ��ʵ����Ա���Ҷ�û�г�ʼ����ʵ����Ա��Ҫ�໥����
		String sql="select*from tb_manager where account="+"'"+account+"'";
		if(!account.equals("")&&!password.equals("")) {
			try {
				//�������ݿ�
				Statement state=SqlConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				//��ѯ���
				ResultSet result=state.executeQuery(sql);
				if(result.next()) {
					//��֤����
					if(result.getString("password").equals(password)) {
						card.show(pane,"navigation");
					}else {
						JOptionPane.showMessageDialog(null,"���벻��ȷ,����������");
					}
				}else{
					JOptionPane.showMessageDialog(null,"�����û����Ƿ���ȷ");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null,"�û���������Ϊ��","����",JOptionPane.ERROR_MESSAGE,null);
		}
	}
}

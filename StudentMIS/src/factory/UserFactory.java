package factory;

import java.awt.CardLayout;

import javax.swing.JPanel;

import mis.managerframe.Layout;
/**
 * ��������Ϊ�Ѿ�֪���������û�������ʹ�ü򵥹���
 * �򵥹���(�������������Ϣ���ڷ��������б���)
 * ���������ӿ�����(����)��̬����ת��
 * ����ʵ�ֻ��ǽ���ʵ����
 */
public class UserFactory implements Layout{
	
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	//������Ϣ
	public UserLogin createUser(String user,String account,String password) {
		if(user.equals("ϵͳ����Ա")) {
			//�������󣬾������ٷ����ﴴ��
			ManagerLogin manager=new ManagerLogin();
			manager.setPane(pane);
			manager.setCard(card);
			manager.setAccount(account);
			manager.setPassword(password);
			return manager;
		}else if(user.equals("��ʦ")) {
			TeacherLogin teacher=new TeacherLogin();
			teacher.setPane(pane);
			teacher.setCard(card);
			teacher.setAccount(account);
			teacher.setPassword(password);
			return teacher;
		}else if(user.equals("ѧ��")) {
			StudentLogin student=new StudentLogin();
			student.setPane(pane);
			student.setCard(card);
			student.setAccount(account);
			student.setPassword(password);
			return student;
		}
		return null;
	}
	
	@Override
	public void setPane(JPanel pane) {
		this.pane=pane;
	}

	@Override
	public void setcard(CardLayout card) {
		this.card=card;
	}
}

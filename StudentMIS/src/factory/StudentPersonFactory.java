package factory;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class StudentPersonFactory {
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	
	public StudentPerson createStudentPerson(String major,String number) {
		if(major.equals("���ݿ�ѧ������ݼ���")) {
			StudentPersonData studentData=new StudentPersonData();
			studentData.setPane(pane);
			studentData.setCard(card);
			studentData.setNumber(number);
			return studentData;
		}else if(major.equals("�������ѧ����")) {
			
		}
		return null;
	}
	public CardLayout getCard() {
		return card;
	}
	public void setCard(CardLayout card) {
		this.card = card;
	}
	public JPanel getPane() {
		return pane;
	}
	public void setPane(JPanel pane) {
		this.pane = pane;
	}

}

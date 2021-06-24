package mis.teacherPersonFrame;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mis.managerframe.Layout;

public class TeacherPersonScore implements Layout{
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	String order="���ݿ�ѧ������ݼ���";
	public JPanel scoreMessagePane() {
		String[]majors= {"���ݿ�ѧ������ݼ���","�������ѧ�뼼��","�������"};
		JLabel major=new JLabel("רҵ:");
		JComboBox<String> combo=new JComboBox<>(majors);
		JButton check_button=new JButton("�鿴");
		JButton return_button=new JButton("����");
		JPanel panel=new JPanel();
		panel.add(major);
		panel.add(combo);
		panel.add(check_button);
		panel.add(return_button);
		combo.addItemListener(e->{
			order=(String)combo.getSelectedItem();
		});
		check_button.addActionListener(e->{
			if(order.equals("���ݿ�ѧ������ݼ���")) {
				card.show(pane,"teacherScore");
			}
		});
		return_button.addActionListener(e->{
			card.show(pane,"teacherNavigation");
		});
		return panel;
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

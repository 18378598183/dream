package mis.managerframe;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Navigation implements Layout{
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	
	JPanel panel=new JPanel();
	public JPanel navigationPane() {
		JMenuBar menuBar=new JMenuBar();
		
		JMenu system=new JMenu("ϵͳ����");
		JMenu teacher=new JMenu("��ʦ����");
		JMenu student=new JMenu("ѧ������");
		JMenu course=new JMenu("�γ̹���");
		
		JMenuItem manager_message=new JMenuItem("����Ա��Ϣ");
		JMenuItem manager_add=new JMenuItem("��ӹ���Ա");
		system.add(manager_message);
		system.add(manager_add);
		
		manager_message.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(pane,"managerMessage");
			}
			
		});
		manager_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(pane,"managerAdd");
			}
			
		});
		
		JMenuItem teacher_message=new JMenuItem("��ʦ��Ϣ");
		JMenuItem teacher_browse=new JMenuItem("��ʦ¼��");
		teacher.add(teacher_message);
		teacher.add(teacher_browse);
		
		teacher_message.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(pane,"teacherMessage");
			}
			
		});
		
		teacher_browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(pane,"teacherAdd");
			}
		});
		
		
		JMenuItem student_message=new JMenuItem("ѧ��¼��");
		JMenuItem student_browse=new JMenuItem("ѧ����Ϣ");
		JMenuItem student_score=new JMenuItem("ѧ���ɼ�");
		student.add(student_message);
		student.add(student_browse);
		student.add(student_score);
		
		student_message.addActionListener(e->{
			card.show(pane,"studentAdd");
		});
		student_browse.addActionListener(e->{
			card.show(pane,"studentMessage");
		});
		student_score.addActionListener(e->{
			card.show(pane,"scoreMessage");
		});
		
		JMenuItem course_message=new JMenuItem("�γ���Ϣ");
		JMenuItem course_add=new JMenuItem("����γ�");
		
		course.add(course_message);
		course.add(course_add);
		
		course_message.addActionListener(e->{
			card.show(pane,"courseMessage");
		});
		course_add.addActionListener(e->{
			card.show(pane,"courseAdd");
		});
		
		menuBar.add(system);
		menuBar.add(teacher);
		menuBar.add(student);
		menuBar.add(course);
		
		panel.add(menuBar);
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

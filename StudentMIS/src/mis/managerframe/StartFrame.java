package mis.managerframe;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mis.studentPersonFrame.StudentPersonNavigation;
import mis.teacherPersonFrame.TeacherPersonCourse;
import mis.teacherPersonFrame.TeacherPersonNavigation;
import mis.teacherPersonFrame.TeacherPersonScore;
import mis.teacherPersonFrame.TeacherScore;

/**
 * �����ڣ�ʹ�ÿ�Ƭ����
 * @author ħ��
 *
 */
@SuppressWarnings("serial")
public class StartFrame extends MyFrame{

	//���������ʹ�ÿ�Ƭ���ֹ���ͨ����Ƭ���л�ʵ�ִ������ݵ�ת����ÿ��������嶼��ӵ������ڵ������
	private static CardLayout card=new CardLayout();
	private static JPanel pane=new JPanel(card);
	//���ڳ�ʼ��
	public StartFrame() {
		setTitle("��Ϣ����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//�����������
	static {
		//��¼���
		Login login=new Login();
		login.setPane(pane);
		login.setcard(card);
		//����Ա�������
		Navigation navigation=new Navigation();
		navigation.setPane(pane);
		navigation.setcard(card);
		
		//�Ի���
		LookupDialogManager lookup=new LookupDialogManager();
		lookup.setPane(pane);
		lookup.setcard(card);
		
		ManagerMessage managerMessage=new ManagerMessage();
		managerMessage.setPane(pane);
		managerMessage.setcard(card);
		
		ManagerAdd managerAdd=new ManagerAdd();
		managerAdd.setPane(pane);
		managerAdd.setcard(card);
		managerAdd.setTable(managerMessage.table);
		
		TeacherMessage teacherMessage=new TeacherMessage();
		teacherMessage.setPane(pane);
		teacherMessage.setcard(card);
		
		TeacherAdd teacherAdd=new TeacherAdd();
		teacherAdd.setPane(pane);
		teacherAdd.setcard(card);
		teacherAdd.setTable(teacherMessage.table);
		
		StudentMessage studentMessage=new StudentMessage();
		studentMessage.setPane(pane);
		studentMessage.setcard(card);
		
		StudentAdd studentAdd=new StudentAdd();
		studentAdd.setPane(pane);
		studentAdd.setcard(card);
		studentAdd.setTable(studentMessage.table);
		
		ScoreMessage score=new ScoreMessage();
		score.setPane(pane);
		score.setcard(card);
		
		DataScoreMessage dataScore=new DataScoreMessage();
		dataScore.setPane(pane);
		dataScore.setcard(card);
		
		DataScoreAdd dataAdd=new DataScoreAdd();
		dataAdd.setPane(pane);
		dataAdd.setcard(card);
		dataAdd.setTable(dataScore.table);
		
		CourseMessage course=new CourseMessage();
		course.setPane(pane);
		course.setcard(card);
		
		CourseAdd courseAdd=new CourseAdd();
		courseAdd.setPane(pane);
		courseAdd.setcard(card);
		courseAdd.setTable(course.table);
		
		StudentPersonNavigation studentNavigation=new StudentPersonNavigation();
		studentNavigation.setPane(pane);
		studentNavigation.setcard(card);

		TeacherPersonNavigation teacherNavigation=new TeacherPersonNavigation();
		teacherNavigation.setPane(pane);
		teacherNavigation.setcard(card);
		
		TeacherPersonCourse teacherCourse=new TeacherPersonCourse();
		teacherCourse.setPane(pane);
		teacherCourse.setcard(card);
		
		TeacherPersonScore teacherScore=new TeacherPersonScore();
		teacherScore.setPane(pane);
		teacherScore.setcard(card);
		
		TeacherScore teacherScoreMessage=new TeacherScore();
		teacherScoreMessage.setPane(pane);
		teacherScoreMessage.setcard(card);
		
		//���������������ӵ�����������ϣ���ָ�����ƣ�ʹ�����ͨ�����ƽ�����ת
		pane.add(login.loginPane(),"login");
		pane.add(navigation.navigationPane(),"navigation");
		pane.add(managerMessage.managerMessagePane(),"managerMessage");
		pane.add(managerAdd.managerAdd(),"managerAdd");
		pane.add(teacherMessage.teacherMessagePane(),"teacherMessage");
		pane.add(teacherAdd.teacherAdd(),"teacherAdd");
		pane.add(studentMessage.studentMessagePane(),"studentMessage");
		pane.add(studentAdd.studentAdd(),"studentAdd");
		pane.add(course.courseMessagePane(),"courseMessage");
		pane.add(courseAdd.courseAdd(),"courseAdd");
		pane.add(score.scoreMessagePane(),"scoreMessage");
		pane.add(dataScore.scoreMessagePane(),"dataScoreMessage");
		pane.add(dataAdd.scoreAdd(),"dataScoreAdd");
		pane.add(studentNavigation.navigationPane(),"studentNavigation");
		pane.add(teacherNavigation.navigationPane(),"teacherNavigation");
		pane.add(teacherCourse.courseMessagePane(),"teacherPersonCourse");
		pane.add(teacherScore.scoreMessagePane(),"teacherPersonScore");
		pane.add(teacherScoreMessage.scoreMessagePane(),"teacherScore");
		//Ĭ������ʾ��¼���
		card.show(pane,"login");
	}
	public static void main(String[] args) {
		StartFrame start=new StartFrame();
		start.add(pane);
		start.setVisible(true);
	}
}

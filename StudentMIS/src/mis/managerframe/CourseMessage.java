package mis.managerframe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bean.Course;
import factory.CourseTableFactory;
import factory.TableFactoryAbstract;
import factory.UserTable;
import mis.tool.SqlOperation;

public class CourseMessage implements Layout{
	
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	TableFactoryAbstract factory=new CourseTableFactory();
	UserTable user=factory.createUserTable();
	JTable table=user.createTable();
	
	public JPanel courseMessagePane() {
		
		JScrollPane srollPane=new JScrollPane(table);
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(srollPane,BorderLayout.CENTER);
		JPanel button_pane=new JPanel();
		JButton revise_button=new JButton("�޸�");
		JButton keep_button=new JButton("�༭");
		JButton remove_button=new JButton("ɾ��");
		JButton lookup_button=new JButton("����");
		JButton return_button=new JButton("����");
		revise_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(true);
			}
		});
		//�˴���������ı�������Ū��̬���ˣ������úõģ�ͻȻ�Ͳ����ˣ������ģ��������ڰ���������
		keep_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectRow=table.getSelectedRow();
				if(selectRow>=0) {
					Course course=new Course();
					course.setNumber((String)table.getValueAt(selectRow,0));
					course.setName((String)table.getValueAt(selectRow,1));
					course.setTeacher((String)table.getValueAt(selectRow, 2));
					course.setCredit((double)table.getValueAt(selectRow,3));
					course.setHour((String)table.getValueAt(selectRow, 4));
					LookupResultCourse lookupResult=new LookupResultCourse();
					lookupResult.setTable(table);
					lookupResult.add(lookupResult.checkResultPanel(course));
					lookupResult.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(pane,"����ѡ��༭��");
				}
			}
		});
		remove_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowSelect=table.getSelectedRow();
				if(rowSelect>=0) {
					int order=JOptionPane.showConfirmDialog(pane,"�Ƿ�ɾ��","��ʾ",JOptionPane.OK_CANCEL_OPTION);
					if(order==JOptionPane.OK_OPTION) {
						SqlOperation.deleteCourse((String)table.getModel().getValueAt(rowSelect,0));
						user.plushTable(table);
					}
				}else {
					JOptionPane.showMessageDialog(pane,"����ѡ��������");
				}
			}
		});
		return_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(false);
				card.show(pane,"navigation");
			}
		});
		lookup_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LookupDialogCourse lookup=new LookupDialogCourse();
				lookup.setTable(table);
				lookup.setVisible(true);
			}
		});
		button_pane.add(revise_button);
		button_pane.add(keep_button);
		button_pane.add(remove_button);
		button_pane.add(lookup_button);
		button_pane.add(return_button);
		panel.add(button_pane,BorderLayout.SOUTH);
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

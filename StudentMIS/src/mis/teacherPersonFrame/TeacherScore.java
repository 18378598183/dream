package mis.teacherPersonFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bean.DataScore;
import factory.DataScoreTableFactory;
import factory.TableFactoryAbstract;
import factory.UserTable;
import mis.managerframe.Layout;
import mis.managerframe.LookupDataScore;
import mis.managerframe.LookupResultDataScore;
import mis.tool.SqlOperation;

public class TeacherScore implements Layout{
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	TableFactoryAbstract factory=new DataScoreTableFactory();
	UserTable user=factory.createUserTable();
	JTable table=user.createTable();
	public JPanel scoreMessagePane() {
		
		JScrollPane srollPane=new JScrollPane(table);
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(srollPane,BorderLayout.CENTER);
		JPanel button_pane=new JPanel();
		JButton revise_button=new JButton("�޸�");
		JButton keep_button=new JButton("�༭");
		JButton add_button=new JButton("���");
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
					DataScore score=new DataScore();
					score.setNumber((String)table.getValueAt(selectRow,0));
					score.setName((String)table.getValueAt(selectRow,1));
					score.setMajor((String)table.getValueAt(selectRow,2));
					score.setJava((double)table.getValueAt(selectRow,3));
					score.setEnglish((double)table.getValueAt(selectRow, 4));
					score.setMath((double)table.getValueAt(selectRow, 5));
					score.setPhysical((double)table.getValueAt(selectRow, 6));
					score.setRemark((String)table.getValueAt(selectRow,7));
					LookupResultDataScore lookupResult=new LookupResultDataScore();
					lookupResult.setTable(table);
					lookupResult.add(lookupResult.checkResultPanel(score));
					lookupResult.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(pane,"����ѡ��༭��");
				}
			}
		});
		add_button.addActionListener(e->{
			card.show(pane,"dataScoreAdd");
		});
		remove_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowSelect=table.getSelectedRow();
				if(rowSelect>=0) {
					int order=JOptionPane.showConfirmDialog(pane,"�Ƿ�ɾ��","��ʾ",JOptionPane.OK_CANCEL_OPTION);
					if(order==JOptionPane.OK_OPTION) {
						SqlOperation.deleteDataScore((String)table.getModel().getValueAt(rowSelect,0));
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
				card.show(pane,"teacherPersonScore");
			}
		});
		lookup_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LookupDataScore lookup=new LookupDataScore();
				lookup.setTable(table);
				lookup.setVisible(true);
			}
		});
		button_pane.add(revise_button);
		button_pane.add(keep_button);
		button_pane.add(add_button);
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

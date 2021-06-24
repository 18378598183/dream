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

import bean.Manager;
import factory.ManagerTableFactory;
import factory.TableFactoryAbstract;
import factory.UserTable;
import mis.tool.SqlOperation;

/**
 * ����Ա��Ϣ����
 * @author ħ��
 *
 */
public class ManagerMessage implements Layout{
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	//��ȡ����
	TableFactoryAbstract factory=new ManagerTableFactory();
	//�������
	UserTable userTable=factory.createUserTable();
	JTable table=userTable.createTable();
	
	public JPanel managerMessagePane() {
		//�������ӵ����������
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
		/**
		 * ����������Ū��̬���ˣ�������������³�ͻ��ԭ���úõģ�
		 * ͻȻ�͸������⣬�����ģ��������ڰ��������ˣ���Ϊʹ�öԻ���������ݾ����޸�
		 */
		keep_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectRow=table.getSelectedRow();
				if(selectRow>=0) {
					Manager manager=new Manager();
					manager.setNumber((String)table.getValueAt(selectRow,0));
					manager.setName((String)table.getValueAt(selectRow,1));
					manager.setAccount((String)table.getValueAt(selectRow,2));
					manager.setPassword((String)table.getValueAt(selectRow,3));
					manager.setPhone((String)table.getValueAt(selectRow,4));
					manager.setAddress((String)table.getValueAt(selectRow,5));
					manager.setMail((String)table.getValueAt(selectRow,6));
					manager.setRemark((String)table.getValueAt(selectRow,7));
					//�Ի����ڶԻ����еĿ����޸���Ϣ
					LookupResultManager lookupResult=new LookupResultManager();
					lookupResult.setTable(table);
					lookupResult.add(lookupResult.checkResultPanel(manager));
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
						SqlOperation.deleteManager((String)table.getModel().getValueAt(rowSelect,0));
						//���±�񣬲�����Ҫ֪��Ҫ�������ݿ��е��Ǹ���
						userTable.plushTable(table);
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
				LookupDialogManager lookup=new LookupDialogManager();
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

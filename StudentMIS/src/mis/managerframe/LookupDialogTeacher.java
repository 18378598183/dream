package mis.managerframe;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import bean.Teacher;
import mis.tool.SqlOperation;

@SuppressWarnings("serial")
public class LookupDialogTeacher extends JDialog implements Layout{
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	JTable table=new JTable();
	String item="��ʦ���";
	String sql;
	public LookupDialogTeacher() {
		setTitle("����");
		setSize(300,300);
		setLocationRelativeTo(pane);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(checkDialog());
	}
	public JPanel checkDialog() {
		String[] teacher= {"��ʦ���","����","�绰����","��������"};
		JLabel check_label=new JLabel("��ѯ��Ϣ:");
		JComboBox<String> combo=new JComboBox<>(teacher);
		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
						item=(String)combo.getSelectedItem();
				}
				
			}
		});
		JTextField check_text=new JTextField(10);
		JPanel check_pane=new JPanel();
		check_pane.add(check_label);
		check_pane.add(combo);
		check_pane.add(check_text);
		
		JButton check_button=new JButton("��ѯ");
		check_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(item.equals("��ʦ���")) {
					 sql="select*from tb_teacher where number="+"'"+check_text.getText()+"'";
				}else if(item.equals("����")) {
					sql="select*from tb_teacher where name="+"'"+check_text.getText()+"'";
				}else if(item.equals("�绰����")) {
					sql="select*from tb_teacher where phone="+"'"+check_text.getText()+"'";
				}else {
					sql="select*from tb_teacher where mail="+"'"+check_text.getText()+"'";
				}
				ArrayList<Teacher> teacherList=SqlOperation.queryTeacher(sql);
				if(!teacherList.isEmpty()) {
					setVisible(false);
					LookupResultTeacher lookupResultTeacher=new LookupResultTeacher();
					lookupResultTeacher.setTable(table);
					try {
						lookupResultTeacher.add(lookupResultTeacher.checkResultPanel(teacherList.get(0)));
					}catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
					lookupResultTeacher.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(pane,"���޴���");
				}
			}
		});
		JButton cancel_button=new JButton("ȡ��");
		
		cancel_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel button_pane=new JPanel();
		button_pane.add(check_button);
		button_pane.add(cancel_button);
		
		JPanel panel=new JPanel(new GridLayout(3,1));
		panel.add(check_pane);
		panel.add(button_pane);
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
	public void setTable(JTable table) {
		this.table=table;
	}

}

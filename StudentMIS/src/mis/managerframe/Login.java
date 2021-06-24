package mis.managerframe;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import factory.UserLogin;
import factory.UserFactory;

public class Login implements Layout{
	CardLayout card=new CardLayout();
	JPanel pane=new JPanel(card);
	//�û���¼����
	private static String[] type= {"ϵͳ����Ա","��ʦ","ѧ��"};
	private static String item_type="ϵͳ����Ա";
	JPanel panel=new JPanel(new GridLayout(6,1));
	
	public JPanel loginPane() {
		
		JPanel hello_pane=new JPanel();
		JLabel hello_label=new JLabel("ѧ����Ϣ����ϵͳ");
		hello_label.setFont(new Font(null,Font.BOLD,28));
		hello_pane.add(hello_label);
		
		JPanel type_pane=new JPanel();
		JLabel type_label=new JLabel("�û�����:");
		JComboBox<String> combo=new JComboBox<>(type);
		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					item_type=(String)combo.getSelectedItem();
				}
			}
		});	
		type_pane.add(type_label);
		type_pane.add(combo);
		JPanel name_pane=new JPanel();
		JLabel name_label=new JLabel("�� ��:");
		name_label.setHorizontalAlignment(SwingConstants.LEFT);
		JTextField name_text=new JTextField(20);
		name_pane.add(name_label);
		name_pane.add(name_text);
		
		JPanel password_pane=new JPanel();
		JLabel password_label=new JLabel("��    ��:");
		password_label.setHorizontalAlignment(SwingConstants.LEFT);
		JPasswordField password_text=new JPasswordField(20);
		password_pane.add(password_label);
		password_pane.add(password_text);
		
		JPanel button_pane=new JPanel();
		JButton login_button=new JButton("��¼");
		JButton cancel_button=new JButton("ȡ��");
		button_pane.add(login_button);
		button_pane.add(cancel_button);
	
		panel.add(hello_pane);
		panel.add(type_pane);
		panel.add(name_pane);
		panel.add(password_pane);
		panel.add(button_pane);
		//��¼
		login_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ������˺ź�����
				String account=name_text.getText();
				String password=new String(password_text.getPassword());
				//������¼����
				UserFactory factory=new UserFactory();
				factory.setPane(pane);
				factory.setcard(card);
				//��ȡ��¼�û��Ķ��󣬲���ת��Ϊ�ӿ����á�item_type:��¼�û�����
				UserLogin user=factory.createUser(item_type, account, password);
				/**
				 * ���Ͷ�̬
				 * ����ģʽ��ʹ�ͻ��ˣ���ʹ�ù��ܵ����У������ü�࣬���ؿ�������һ���û����ͽ��е�¼
				 * ���ѷ��ӵĴ���ʵ�ֽ�����������(����ʵ���ࡢ������)
				 * 
				 */
				user.LoginCheck();
				name_text.setText("");
				password_text.setText("");
			}
		});
		cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int order=JOptionPane.showConfirmDialog(pane,"�Ƿ��˳���","��ʾ",JOptionPane.YES_OPTION);
				if(order==JOptionPane.YES_OPTION) {
					System.exit(0);	
				}
			}
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

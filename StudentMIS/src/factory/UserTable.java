package factory;

import javax.swing.JTable;
/**
 * ��������ģʽ����Ҫ�����͸��¸��ָ����ı�����ʹ�ù�������ģʽ
 * @author ħ��
 *
 */
public interface UserTable {
	//�����ݿ��в�ѯ��Ϣ��ʹ���ڴ������Ա�����
	public JTable createTable();
	//����Ϣ���ĺ���и��²���
	public void plushTable(JTable table);

}

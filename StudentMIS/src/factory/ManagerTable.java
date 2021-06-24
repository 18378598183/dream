package factory;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import bean.Manager;
import mis.tool.SqlOperation;
/**
 * ����Ա��Ϣ���ʵ����
 * �����͸���
 * @author ħ��
 */
public class ManagerTable implements UserTable{
	/**
	 * ����һ�����ģ��
	 */
	@Override
	public JTable createTable() {
		String sql="select*from tb_manager";
		JTable table=new JTable();
		//���ģ�ͣ�������������
		DefaultTableModel tableModel=new DefaultTableModel();
		//�����ݿ��в�ѯ����Ϣ
		ArrayList<Manager> managerList=SqlOperation.queryManager(sql);
		//��ͷ
		Object[] column= {"������","����","�˺�","����","�绰����","��������","��ַ","��ע"};
		Object[]rowData=new Object[column.length];
		table=new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		table.setEnabled(false);
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		tableModel.setColumnIdentifiers(column);
		//����Ϣ������ģ��
		for(Manager manager:managerList) {
			rowData[0]=manager.getNumber();
			rowData[1]=manager.getName();
			rowData[2]=manager.getAccount();
			rowData[3]=manager.getPassword();
			rowData[4]=manager.getPhone();
			rowData[5]=manager.getMail();
			rowData[6]=manager.getAddress();
			rowData[7]=manager.getRemark();
			tableModel.addRow(rowData);
		}
		//Ӧ�ñ��ģ��
		table.setModel(tableModel);
		return table;
	}
	/**
	 * ���±�񣺸ı���ģ���е����ݣ��ڽ�ģ��Ӧ�õ������
	 */
	@Override
	public void plushTable(JTable table) {
		//��ȡԭ���ı��ģ��
		DefaultTableModel newTableModel=(DefaultTableModel) table.getModel();
		String sql="select*from tb_manager";
		//�ٴλ�ȡ���ݿ��е���Ϣ
		ArrayList<Manager> managerList=SqlOperation.queryManager(sql);
		Object[] column= {"������","����","�˺�","����","�绰����","��������","��ַ","��ע"};
		Object[][] rowData=new Object[managerList.size()][column.length];
		int i=0;
		//����Ϣ������ģ��
		for(Manager manager:managerList) {
			rowData[i][0]=manager.getNumber();
			rowData[i][1]=manager.getName();
			rowData[i][2]=manager.getAccount();
			rowData[i][3]=manager.getPassword();
			rowData[i][4]=manager.getPhone();
			rowData[i][5]=manager.getMail();
			rowData[i][6]=manager.getAddress();
			rowData[i][7]=manager.getRemark();
			i++;
		}
		//���±��ģ������
		newTableModel.setDataVector(rowData,column);
		//���±�����
		table.updateUI();
	}
}

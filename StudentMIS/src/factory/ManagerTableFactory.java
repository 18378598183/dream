package factory;
/**
 * ����Ա��ľ��幤��
 * @author ħ��
 *
 */
public class ManagerTableFactory implements TableFactoryAbstract{
	@Override
	public UserTable createUserTable() {
		//����һ������Ա��ľ������
		return new ManagerTable();
	}

}

package factory;
/**
 * ���������ݳɼ����ľ��幤����
 * @author ħ��
 *
 */
public class DataScoreTableFactory implements TableFactoryAbstract{

	@Override
	public UserTable createUserTable() {
		return new DataScoreTable();
	}
	
}

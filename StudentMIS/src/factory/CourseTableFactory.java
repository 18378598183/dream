package factory;
/**
 * �γ���Ϣ��ľ��幤����
 * @author ħ��
 *
 */
public class CourseTableFactory implements TableFactoryAbstract{

	@Override
	public UserTable createUserTable() {
		return new CourseTable();
	}
	
}

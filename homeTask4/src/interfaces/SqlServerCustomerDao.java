package interfaces;

public class SqlServerCustomerDao extends BaseCustomerDao implements ICustomerDao, IRepository{

	@Override
	public void add() {						// ICustomerDao dan gelen metod
		System.out.println("Sql Server veritabanưna eklendi");		
	}

	@Override
	public void repostitorysLogger() {		 // IRepository den gelen metod		
	}

}

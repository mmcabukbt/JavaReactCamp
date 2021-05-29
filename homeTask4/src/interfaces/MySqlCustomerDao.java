package interfaces;

public class MySqlCustomerDao extends BaseCustomerDao implements ICustomerDao, IRepository {
	//***********************				  *******************************\\	
// classes; SADECE 1 class extend EDEBÝLÝR, ANCAK 1 den FAZLA interface implement EDEBÝLÝR!
	//***********************				  *******************************//	

	@Override
	public void add() {						// ICustomerDao dan gelen metod
		System.out.println("MySql veritabanýna eklendi");		
	}

	@Override
	public void repostitorysLogger() { 		// IRepository den gelen metod
	}

}
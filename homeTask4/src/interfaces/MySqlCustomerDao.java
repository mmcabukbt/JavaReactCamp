package interfaces;

public class MySqlCustomerDao extends BaseCustomerDao implements ICustomerDao, IRepository {
	//***********************				  *******************************\\	
// classes; SADECE 1 class extend EDEB�L�R, ANCAK 1 den FAZLA interface implement EDEB�L�R!
	//***********************				  *******************************//	

	@Override
	public void add() {						// ICustomerDao dan gelen metod
		System.out.println("MySql veritaban�na eklendi");		
	}

	@Override
	public void repostitorysLogger() { 		// IRepository den gelen metod
	}

}
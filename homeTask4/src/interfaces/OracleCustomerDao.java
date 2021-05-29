package interfaces;

public class OracleCustomerDao extends BaseCustomerDao implements ICustomerDao, IRepository  {
	//***********************				  *******************************\\	
// classes; SADECE 1 class extend EDEBİLİR, ANCAK 1 den FAZLA interface implement EDEBİLİR!
	//***********************				  *******************************//	

	@Override
	public void add() {						// ICustomerDao dan gelen metod
		System.out.println("Oracle veritabanına eklendi");		
	}

	@Override
	public void repostitorysLogger() {		 // IRepository den gelen metod		
	}
}
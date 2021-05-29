package newestGamersCo.Concrete;

import newestGamersCo.Entities.User;

/**
 * METODLARI ERÝÞÝME KAPALI class!... Korumalý altyapý class.
 * Bu class sadece GamerManager için özel baðýmlý operasyonlara altyapýdýr, kendi içindeki;
 * <ul>
 * <li>add(),
 * <li>update()
 * <li>delete()
 * <li>getAll()
 * </ul>
 * metodlarýný tamamen gizleyerek sadece GameManager içerisinden eriþime izin verir
 * ve Gamer adýna User üzerindeki alt veritabaný(Dao) operasyonlarýný yürütür/yürütecektir.
 */
public class UserManager{
	private static int autoId = 250;

	protected int add(User user) throws Exception {
		return addTableGetId(user);
	}
	
	private int addTableGetId(User user) {
		// Add User to USERS Table and return its id // or maybe itself
		System.out.println("User, added to User's table. Id: " + ++autoId); //Db auto incremented Id simulate
		return autoId;
	}

	protected void update(User user) {
		System.out.println("User, updated on User's table.");		
	}

	protected void delete(User user) {
		System.err.println("User, deleted from User's table.!");		
	}
}
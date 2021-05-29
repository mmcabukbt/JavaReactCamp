package newestGamersCo.Concrete;

import newestGamersCo.Entities.User;

/**
 * METODLARI ER���ME KAPALI class!... Korumal� altyap� class.
 * Bu class sadece GamerManager i�in �zel ba��ml� operasyonlara altyap�d�r, kendi i�indeki;
 * <ul>
 * <li>add(),
 * <li>update()
 * <li>delete()
 * <li>getAll()
 * </ul>
 * metodlar�n� tamamen gizleyerek sadece GameManager i�erisinden eri�ime izin verir
 * ve Gamer ad�na User �zerindeki alt veritaban�(Dao) operasyonlar�n� y�r�t�r/y�r�tecektir.
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
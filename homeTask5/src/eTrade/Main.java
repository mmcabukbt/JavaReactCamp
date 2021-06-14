package eTrade;

import eTrade.core.adapters.authorizationProviderServices.googleAuthorizationService.GoogleAuthorizationAdapter;
import eTrade.core.adapters.confirmLinkServices.ConfirmationLinkAdapter1;
import eTrade.core.business.concretes.AuthenticationManager;
import eTrade.core.business.concretes.UserManager;
import eTrade.core.dataAccess.concretes.HibernateUserDao;
import eTrade.core.entities.User;
import eTrade.core.validators.UserInfoValidator;

public class Main {

	// Proeje bir e-Ticaret backendi ve A��rl�kl� olarak �r�nler ile �al���lacakt�r. Ancak Users kay�t, validasyon, yetkilendirme,
//	\\ kabul, kimlik do�rulama proje ba��ms�z oldu�u i�in �ekirde�e (core) ta��nd�.
	public static void main(String[] args) {
// Sonu�lar� daha rahat g�rmek ve Uzun denemelerin bir k�sm�n�n derlenmesini engellemek i�in 
//<<<<< Alttaki 2 b�lme i�aretleri aras�na * koyarak comment/yorum haline getirebilirsiniz! "//invalid >/*/invalid" gibi
		
		HibernateUserDao hibernateUserDao = new HibernateUserDao(); //InMermory data Acces
		UserManager userManager = new UserManager(hibernateUserDao, new UserInfoValidator(),
				new ConfirmationLinkAdapter1(), new GoogleAuthorizationAdapter());
		
		User user1 = new User("Mehmet", "�abuk", "123456", "deneme.mail@cabuk.com");
		User user2 = new User("Mehmet", "�abuk", "123456", "deneme.mail@cabuk.com");
		
		System.out.println(userManager.add(user1).getMessage()); // success
		System.out.println(userManager.add(user1).getMessage()); // same user > User already exists! Error
		System.out.println(userManager.add(user2).getMessage()); // same info another user > User already exists! Error
/*/invalid emails error >> Email is NOT valid!
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "0000:)", "deneme@")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "0000:)", "deneme@bilir")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "0000:)", ".denemedene@bilir")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "0000:)", "deneme.dene@bilir.")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "0000:)", "�.��.�e.dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "0000:)", "@bilir.com")).getMessage()); //*/
//invalid password error>> Password field can not be less 6 digits..		
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "", "dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "", "123456", "dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "0000:)", "�.��.�e.dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "12345", "dene@bilir.com")).getMessage()); //*/
/*/invalid user first last name error>> User First Name and Last Name; can not be Emty or less 2 letters...
		System.out.println(userManager.add(new User("Ay�e", "", "123456", "dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("", "Bilir", "123456", "dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("Ay�e", "B", "123456", "dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("A", "Bilir", "123456", "dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("A", "Bi", "123456", "dene@bilir.com")).getMessage()); //*/
		
		System.out.println(userManager.add(new User("Ay�e", "Bilir", "123456", "dene@bilir.com")).getMessage());
		System.out.println(userManager.add(new User("Ayla", "Bilir", "123456", "adene@gmail.com")).getMessage());
		System.out.println(userManager.add(new User("�mer", "Halisdemir", "123456", "omerhalisdemir@sehit.com")).getMessage());
		
//GoogleAuthorizationService 
		System.out.println(userManager.addFromService().getMessage());
		
		
//List InMemory Database
		System.out.println("\n<> -----------------<> InMemory Db Member List <>------------------------");
		System.out.println("id\tName\t\t\tPassword\tEmail");
		for (User user : userManager.getAll().data) { 
			System.out.println(user.getId() + "\t" + user.getFirstName() + " " + user.getLastName()+ "\t\t" +
					user.getPassword() + "\t\t" + user.getEmail());
		}
		System.out.println("\n<> Authentication <>--------------------------------");
//Authenticate > �mer Halisdemir
		AuthenticationManager authenticationManager = new AuthenticationManager(hibernateUserDao);
		System.out.println(	authenticationManager.authenticateUser(
				new User("", "", "123456", "omerhalisdemir@sehit.com")).getMessage());
//Someone who is not in db...
		System.out.println(	authenticationManager.authenticateUser(
				new User("", "", "000000", "kirk@ayak.com")).getMessage());
//lastone
		System.out.println(	authenticationManager.authenticateUser(
				new User("", "", "123456", "adene@gmail.com")).getMessage());
// delete user
		System.err.println(userManager.delete(user1).getMessage());
// update user
		User _user = userManager.getById(3).data;
		_user.setLastName("Nebilir");
		System.out.println(userManager.update(_user).getMessage());
		
//Last situation in List InMemory Database 
				System.out.println("\n<> -----------------<> InMemory Db Member List <>------------------------");
				System.out.println("id\tName\t\t\tPassword\tEmail");
				for (User user : userManager.getAll().data) { 
					System.out.println(user.getId() + "\t" + user.getFirstName() + " " + user.getLastName()+ "\t\t" +
							user.getPassword() + "\t\t" + user.getEmail());
				}
	}
}
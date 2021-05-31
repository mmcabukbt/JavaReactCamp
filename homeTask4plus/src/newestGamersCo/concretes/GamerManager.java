package newestGamersCo.concretes;

import java.util.Arrays;
import java.util.List;

import newestGamersCo.abstracts.PersonCheckService;
import newestGamersCo.abstracts.oldNoNeeds.GamerService;
import newestGamersCo.entities.Gamer;
import newestGamersCo.entities.User;

public class GamerManager extends UserManager implements GamerService {

	private PersonCheckService personCheckService;

	public GamerManager(PersonCheckService personCheckService) {
		//super();
		this.personCheckService = personCheckService;
	}

	@Override
	public int add(User user) throws Exception {
		if (Gamer.class.isInstance(user)) { // + business rules
			Gamer gamer = (Gamer) user;

			if (personCheckService.checkIfRealPerson(gamer)) {
				gamer.setUserId(super.add(user));
				gamer.setId(gamer.getUserId() - 125);
				System.out.println("<>Gamer added >> id: " + gamer.getId() + ", userId: " + gamer.getUserId()
						+ ", Ad: " + gamer.getFirstName()+" "+gamer.getLastName());
			} else {
				throw new Exception("UYARI! Kiþinin kimlik bilgileri GEÇERSÝZ!");
			}
		} else {
			System.err.println("Not a gamer!, So, could not add!");
		}
		return 0;
	}

	@Override
	public void update(User user) {
		if (Gamer.class.isInstance(user)) { // + business rules
			super.update(user);
			System.out.println("<>Gamer, updated on Gamers's table");
		} else {
			System.err.println("Not a gamer!, So, could not update!");
		}
	}

	@Override
	public void delete(User user) {
		if (Gamer.class.isInstance(user)) { // + business rules
			super.delete(user);
			System.err.println("<>Gamer, deleted from Gamers's table! : ");
		} else {
			System.err.println("Not a gamer!, So, could not delete!!");
		}
	}

	@Override
	public List<User> getAll() {
		System.out.println("All Users table listed");
		return Arrays.asList(new Gamer[] { new Gamer(), new Gamer() });
	}/// *////
}
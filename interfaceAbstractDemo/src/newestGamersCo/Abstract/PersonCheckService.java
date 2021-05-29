package newestGamersCo.Abstract;

import newestGamersCo.Entities.Gamer;

public interface PersonCheckService {
	
	boolean checkIfRealPerson(Gamer gamer) throws Exception ;
}
package newestGamersCo.abstracts;

import newestGamersCo.entities.Gamer;

public interface PersonCheckService {
	
	boolean checkIfRealPerson(Gamer gamer) throws Exception ;
}
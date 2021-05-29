package newestGamersCo.UIs;

import java.util.Date;

import newestGamersCo.Core.ServiceRepo;
import newestGamersCo.Entities.Campaign;
import newestGamersCo.Entities.Game;
import newestGamersCo.Entities.Gamer;
import newestGamersCo.Entities.Sale;

public class MarketingUI {

	private ServiceRepo<Sale> saleService; 

	public MarketingUI(ServiceRepo<Sale> saleService) {
		this.saleService = saleService;
	}
	
	public boolean sell(Gamer gamer, Game game, Campaign campaign) {
		if (campaign.getGameId() == game.getId()) { //is the campaign includes this game?
			double total =  game.getPrice() - (game.getPrice() * campaign.getDiscount() / 100);
			saleService.add(new Sale(155, gamer.getId(), game.getId(), campaign.getId(), new Date(System.currentTimeMillis()), game.getPrice(), total));
			System.out.println("Thank you! " + gamer.getFirstName()+" "+gamer.getLastName() + ", you purchased \""+ game.getName() +
					"\". And with its \"" + campaign.getName() + "\" Campaign "+ campaign.getDiscount() + 
					"% discounted price.\n-------------------------------------------------------------\n\t" +
					"Game Price: " + game.getPrice() + "\tDiscount "+ campaign.getDiscount()+ "%\t Total: "+ total);
			return true;
		}else {
			System.out.println("Thank you! " + gamer.getFirstName()+" "+gamer.getLastName() + ", you purchased \""+ game.getName() +
					"\". We are sorry that this game isn't in any Campaign.\n-------------------------------------------------------------\n\t" +
					"Game Price: " + game.getPrice() + "\tDiscount 0%\t Total: "+ game.getPrice());
			return true;
		}
	}
}
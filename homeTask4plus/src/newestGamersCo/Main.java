package newestGamersCo;

import java.util.Date;

import newestGamersCo.UIs.MarketingUI;
import newestGamersCo.adapters.MernisServiceAdapter;
import newestGamersCo.concretes.CampaignManager;
import newestGamersCo.concretes.GameManager;
import newestGamersCo.concretes.GamerManager;
import newestGamersCo.concretes.SaleManager;
import newestGamersCo.entities.Campaign;
import newestGamersCo.entities.Game;
import newestGamersCo.entities.Gamer;
import newestGamersCo.entities.Sale;

public class Main {

	public static void main(String[] args) {
//GAMER
		GamerManager gamerManager = new GamerManager(new MernisServiceAdapter());

		Gamer gamer1 = new Gamer("12345678", "Muhammed", "Nurdoðdu", 1979, "11111", "muhammed@ilik.com");
		Gamer gamer2 = new Gamer("12345678", "Ahmet", "Ilýk", 1995, "222222", "ahmet@ilik.com");
		Gamer gamer3 = new Gamer("12345678", "Fatma", "Güzel", 1999, "333333", "fguzel@ilik.com");
		Gamer gamer4 = new Gamer("1231211", "Mehmet", "Çabuk", 1972, "4444444", "mcabuk@cabuk.com");

		Gamer[] gamers = { gamer1, gamer2, gamer3, gamer4 };   //	User user = new User(); ulaþýlamaz

		for (Gamer gamer : gamers) {
			try {
				gamerManager.add(gamer);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		gamerManager.delete(gamer4);

// GAME	//---------------------------------------
		Game game1 = new Game(1, "First Shoot", "Be first shooter!", 120.0);
		Game game2 = new Game(2, "Drive it", "Try our new trucks..!", 135.0);

		GameManager gameManager = new GameManager();
		gameManager.add(game1);
		gameManager.update(game1);
		gameManager.delete(game1);

//CAMPAIGN //-------------------------------------
		Campaign campaign1 = new Campaign(1, 1, "First Meet", "Discount to first meet you!", 5.0);

		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(campaign1);
		campaignManager.update(campaign1);
		campaignManager.delete(campaign1);

// SALE //----------------------------------------
		Sale sale = new Sale(1, 3, 5, 2, new Date(System.currentTimeMillis()), 120.0, 102.0);

		SaleManager saleManager = new SaleManager();
		saleManager.add(sale);
		saleManager.update(sale);
		saleManager.delete(sale);

//MARKETING //-------------------------------------
		
		MarketingUI marketingUI = new MarketingUI(saleManager);
		marketingUI.sell(gamer4, game1, campaign1);
		marketingUI.sell(gamer4, game2, campaign1);

	}
}
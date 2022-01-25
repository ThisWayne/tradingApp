package trading.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import trading.app.algorithm.ProductTradingBot;
import trading.app.algorithm.TradingAlgorithm;
import trading.app.model.Price;
import trading.app.model.Trade;

public class TradingAppMain {
	HashMap<String, ProductTradingBot> productNameToTradingBot;

	public static void main(String[] args) {
		TradingAlgorithm algo = new TradingAlgorithm();

		int threadCount = 4;
		for(int i = 0; i < threadCount; i++) {
			new Thread(() -> {
				runTestData(algo);
			}).start();
		}
	}
	
	private static void runTestData(TradingAlgorithm algo) {
		List<Price> testPrices = getTestData();
		for (Price testPrice : testPrices) {
			System.out.println(String.format("%s,%.2f", testPrice.getProductName(), testPrice.getNumericalPrice()));
			Trade trade = algo.buildTrades(testPrice);
			if (trade.isBuy()) {
				System.out.println(String.format("%s,BUY,%.2f,%d", trade.getProductName(), trade.getNumericalPrice(),
						trade.getQuatity()));
			}
		}
	}

	private static List<Price> getTestData() {
//		String[] productNames = new String[]{"C UN", "AAPL UW", "AAL UW"};
//		List<Price> prices = new ArrayList<Price>(100);
//		for (int i = 0; i < 100; i++) {
//			String randomProductName = productNames[(int) (Math.random()* 3)];
//			float randomPrice = (float)(Math.random()*100) + 1;
//			prices.add(new Price(randomProductName, randomPrice));
//		}
		List<Price> prices = Arrays.asList(
				new Price("C UN", 2201.00f), 
				new Price("AAPL UW", 2209.00f),
				new Price("AAL UW", 7.60f), 
				new Price("AAL UW", 7.64f), 
				new Price("AAL UW", 7.61f),
				new Price("AAL UW", 7.67f),
				new Price("AAL UW", 7.5f),
				new Price("AAL UW", 7.4f),
				new Price("AAL UW", 7.3f),
				new Price("AAL UW", 7.2f),
				new Price("AAL UW", 7.1f));
		return prices;
	}
}

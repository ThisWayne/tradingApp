package trading.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import trading.app.algorithm.TradingAlgorithm;
import trading.app.model.Price;
import trading.app.model.Trade;
import trading.app.model.ProductTradingBot;

public class TradingAppMain {
	HashMap<String, ProductTradingBot> productNameToTradingBot;

	public static void main(String[] args) {
		TradingAlgorithm algo = new TradingAlgorithm();

		List<Price> testPrices = getTestData();
		for (Price testPrice : testPrices) {
			Trade trade = algo.buildTrades(testPrice);
			if(trade.isBuy()) {
				System.out.println(
						String.format("%s,BUY,%.2f,%d", 
								trade.getProductName(), trade.getNumericalPrice(), trade.getQuatity()));
			}
		}
	}

	private static List<Price> getTestData() {
		List<Price> prices = Arrays.asList(
				new Price("C UN", 2201.00f),
				new Price("AAPL UW", 2209.00f),
				new Price("AAL UW", 7.60f),
				new Price("AAL UW", 7.64f),
				new Price("AAL UW", 7.61f),
				new Price("AAL UW", 7.67f));
		return prices;
	}
}

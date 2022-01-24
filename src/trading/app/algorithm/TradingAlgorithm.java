package trading.app.algorithm;

import java.util.HashMap;

import trading.app.model.Price;
import trading.app.model.Trade;
import trading.app.model.ProductTradingBot;

public class TradingAlgorithm implements ITradingAlgorithm {
	
	private static int MAX_SIZE = 4;
	private static int BUY_QUANTITY = 1000; 
	HashMap<String, ProductTradingBot> productToTradingBot;
	
	public TradingAlgorithm() {
		productToTradingBot = new HashMap<String, ProductTradingBot>();
	}
	
	@Override
	public Trade buildTrades(Price price) {
		String productName = price.getProductName();
		float numericalPrice = price.getNumericalPrice();
		
		ProductTradingBot tradingBot;
		if(productToTradingBot.containsKey(productName)) {
			tradingBot = productToTradingBot.get(productName);
		} else {
			tradingBot = new ProductTradingBot(productName, TradingAlgorithm.MAX_SIZE, TradingAlgorithm.BUY_QUANTITY);
			productToTradingBot.put(productName, tradingBot);
		}
		return tradingBot.addPrice(numericalPrice);
	}

}

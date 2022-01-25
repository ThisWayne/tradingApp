package trading.app.algorithm;

import java.util.concurrent.ConcurrentHashMap;

import trading.app.model.Price;
import trading.app.model.Trade;

public class TradingAlgorithm implements ITradingAlgorithm {

	private static int MAX_SIZE = 4;
	private static int BUY_QUANTITY = 1000;
	ConcurrentHashMap<String, ProductTradingBot> productToTradingBot;

	public TradingAlgorithm() {
		productToTradingBot = new ConcurrentHashMap<String, ProductTradingBot>();
	}

	@Override
	public Trade buildTrades(Price price) {
		String productName = price.getProductName();
		float numericalPrice = price.getNumericalPrice();

		productToTradingBot.putIfAbsent(productName,
				new ProductTradingBot(productName, TradingAlgorithm.MAX_SIZE, TradingAlgorithm.BUY_QUANTITY));
		ProductTradingBot tradingBot = productToTradingBot.get(productName);

		return tradingBot.addPrice(numericalPrice);
	}

}

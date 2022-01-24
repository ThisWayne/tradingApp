package trading.app.algorithm;

import trading.app.model.Price;
import trading.app.model.Trade;

public interface ITradingAlgorithm {
	/** 

	* Builds a trade to be executed based on the supplied prices. 

	* @param price data 

	* @return trade to execute 

	*/ 

	Trade buildTrades(Price price); 
}

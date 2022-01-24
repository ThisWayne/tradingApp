package trading.app.model;

import java.util.LinkedList;
import java.util.Queue;

public class ProductTradingBot {
	private String productName;
	private float oldest;
	private Queue<Float> prices;
	private int maxSize;
	private int quantity;
	private float sum;
	
	public ProductTradingBot(String productName, int maxSize, int quantity) {
		this.productName = productName;
		this.maxSize = maxSize;
		this.quantity = quantity;
		this.sum = 0;
		prices = new LinkedList<Float>();
		this.oldest = -1;
	}
	
	public Trade addPrice(float price) {
		if(oldest == -1) {
			oldest = price;
		}
		
		if(prices.size() >= this.maxSize) {
			sum -= prices.poll();
		}

		prices.add(price);
		sum += price;
		
		if(prices.size() == this.maxSize) {
			float average = sum / this.maxSize;
			if(average > oldest) {
				return new Trade(this.productName, true, price, this.quantity);
			}
		}
		return new Trade(this.productName, false, 0, 0);
	}
}

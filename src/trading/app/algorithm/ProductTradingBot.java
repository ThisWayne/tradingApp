package trading.app.algorithm;

import java.util.LinkedList;
import java.util.Queue;

import trading.app.model.Trade;

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
		this.prices = new LinkedList<Float>();
		this.oldest = -1;
	}

	public synchronized Trade addPrice(float price) {
//		System.out.println(String.format("------------ adPrice: %s, %f", this.productName, price));
		if (oldest == -1) {
			oldest = price;
		}

		if (prices.size() >= this.maxSize) {
			sum -= prices.poll();
		}

		prices.add(price);
		sum += price;

		if (prices.size() == this.maxSize) {
			float average = sum / this.maxSize;
			
//			printForDebug(average);

			if (average > oldest) {
				return new Trade(this.productName, true, price, this.quantity);
			}
		}
		return new Trade(this.productName, false, 0, 0);
	}
	
	private void printForDebug(float average) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s, ", this.productName));
		for(float p: this.prices) {
			stringBuilder.append(Float.toString(p) + ", ");
		}
		stringBuilder.append(String.format("sum = %f", this.sum));
		System.out.println(String.format("%s\n%s, oldest: %f, average: %f", stringBuilder.toString(), this.productName, this.oldest, average));
		
	}
}

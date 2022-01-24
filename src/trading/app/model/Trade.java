package trading.app.model;

public class Trade {

	String productName;
	boolean isBuy;
	float numericalPrice;
	int quatity;

	public Trade(String productName, boolean isBuy, float numericalPrice, int quatity) {
		this.productName = productName;
		this.isBuy = isBuy;
		this.numericalPrice = numericalPrice;
		this.quatity = quatity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isBuy() {
		return isBuy;
	}

	public void setIsBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	public float getNumericalPrice() {
		return numericalPrice;
	}

	public void setNumericalPrice(float numericalPrice) {
		this.numericalPrice = numericalPrice;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
}

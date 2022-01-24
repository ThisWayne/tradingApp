package trading.app.model;

public class Price {

	String productName;
	float numericalPrice;
	
	public Price(String productName, float numericalPrice) {
		this.productName = productName;
		this.numericalPrice = numericalPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getNumericalPrice() {
		return numericalPrice;
	}

	public void setNumericalPrice(float numericalPrice) {
		this.numericalPrice = numericalPrice;
	}
}

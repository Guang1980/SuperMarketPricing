package product;

public final class Product {

	public String getName() {
		return m_name;
	}

	public double getPrice() {
		return m_price;
	}

	public ProductUnit getUnit() {
		return m_unit;
	}

	private final String m_name;
	private final double m_price;
	private final ProductUnit m_unit;

	public Product(String name, double price, ProductUnit unit) {
		// TODO Auto-generated constructor stub
		m_name = name;
		m_price = price;
		m_unit = unit;
	}

}

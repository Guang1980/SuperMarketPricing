package basket;

import java.math.BigDecimal;

import product.Product;
import product.ProductUnit;
import promotion.PromotionEngine;
import promotion.PromotionResult;

public class ProductAdded {
	private Product m_product;
	private double quantity;
	private double priceBeforeDiscount;
	private String promotionName=null;
	
	private BigDecimal priceAfterDiscount;

	public ProductAdded(Product product) {
		// TODO Auto-generated constructor stub
		m_product = product;
		quantity = 0;
		priceBeforeDiscount = 0;
		
	}
	
	public Double getSavings() {
		// TODO Auto-generated method stub
		//return new BigDecimal(priceBeforeDiscount-priceAfterDiscount.doubleValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		return new BigDecimal(priceBeforeDiscount).subtract(priceAfterDiscount).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public void calculatePromotion(){
		
		PromotionResult result = PromotionEngine.calculatePromotion(m_product,quantity);
		
		promotionName  = result.getPromotionName();
		priceAfterDiscount = new BigDecimal(result.getPriceAfterDiscount()).setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public String getPromotionName() {
		// TODO Auto-generated method stub
		return promotionName;
	}
	
	public Double getPriceAfterDiscount() {

		return priceAfterDiscount.doubleValue();
	}
	

	public String getProductName() {
		return m_product.getName();
	}

	

	public Double getQuanity() {
		return quantity;
	}

	

	public Double getPriceBeforeDiscount() {
		
		return new BigDecimal(priceBeforeDiscount).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void addProduct(double argquantity) {
		// TODO Auto-generated method stub
		quantity += argquantity;
		priceBeforeDiscount += m_product.getPrice()*argquantity;
		
		
	}
    public void updateProduct(double argquantity) {
		// TODO Auto-generated method stub
    	
		quantity = argquantity;
		priceBeforeDiscount = m_product.getPrice()*argquantity;
		
	}

	public ProductUnit getUnit() {
		// TODO Auto-generated method stub
		return m_product.getUnit();
	}

	public double getUnitPrice() {
		// TODO Auto-generated method stub
		return m_product.getPrice();
	}

	
}

package product;


public class ProductCatalog {
	
	
	/**
	 * In the real world scenario, this method should look up product information from
	 * database or product cache.
	 * @param name
	 * @return
	 */
	public static Product getProduct(String name){
		
		
		if(name.equals("Beans")){
			return new Product("Beans", 0.5,ProductUnit.perItem);
		}else if(name.equals("Oranges")){
			return new Product("Oranges", 1.99,ProductUnit.perKg);
		}else if(name.equals("Coke")){
			return new Product("Coke", 0.7,ProductUnit.perItem);
		}
		return null;
	}
	
	
}

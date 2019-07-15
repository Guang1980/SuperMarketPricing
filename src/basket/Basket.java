package basket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import product.Product;
import product.ProductUnit;

public class Basket {
    private HashMap<String, ProductAdded> productMap = new HashMap<String, ProductAdded>();
    
    public ProductAdded getProductAdded(String name){
    	
    	
    	return productMap.get(name);
    }
    
    public void addProduct(Product product,double quantity){
    	ProductAdded productAdded = null;
    	if(productMap.containsKey(product.getName())){
    		
    		productAdded = productMap.get(product.getName());
    		
    	}else{
    		productAdded = new ProductAdded(product);
    		productMap.put(product.getName(), productAdded);
    	}
    	productAdded.addProduct(quantity);
    }
    
    public void updateProduct(Product product,double quantity){
    	ProductAdded productAdded = null;
    	if(productMap.containsKey(product.getName())){
    		
    		productAdded = productMap.get(product.getName());
    		productAdded.updateProduct(quantity);
    	}
    	
    }
    
    public void calcuateBasket(){
    	  double subTotal = 0;
    	  double totalToPay = 0;
    	  double totalSaving = 0;
    	  ArrayList<Double> savings = new ArrayList<Double>();
    	  ArrayList<String> promotionNames = new ArrayList<String>();
    	  Iterator<String> keys =productMap.keySet().iterator();
    	  while(keys.hasNext()){
    		  
    		  String name = keys.next();
    		  ProductAdded productAdded = productMap.get(name);
    		  productAdded.calculatePromotion();
    		  
    		  subTotal += productAdded.getPriceBeforeDiscount();
    		  totalToPay += productAdded.getPriceAfterDiscount();
    		  if(productAdded.getPromotionName()!=null){
    		      savings.add(productAdded.getSavings());
    		      promotionNames.add(productAdded.getPromotionName());
    		      totalSaving += productAdded.getSavings();
    		  }
    		  
    		  printProduct(productAdded);
    	  }
    	  
    	  System.out.println("---------");
    	  System.out.println("Sub-total       "+ subTotal);
    	  System.out.println();
    	  System.out.println("Savings");
    	  
    	  for(int i=0; i< promotionNames.size();i++){
    		  
    		  System.out.print(promotionNames.get(i));
    		  System.out.print("       ");
    		  System.out.println((-savings.get(i)));
    	  }
    	  System.out.println("---------");
    	  
    	  System.out.println("Total savings       "+ (-totalSaving));
    	  System.out.println("---------");
    	  
    	  System.out.println("Total to Pay       "+ (totalToPay));
    	  
    	  
    	  
    }

	private void printProduct(ProductAdded productAdded) {
		// TODO Auto-generated method stub
	     if(productAdded.getUnit().equals(ProductUnit.perItem)){
	    	 Integer quantity = Integer.valueOf(productAdded.getQuanity().intValue());
	    	 for(int i =0;i<quantity;i++){
	    		 System.out.println(productAdded.getProductName()+"              "+productAdded.getUnitPrice());
	    		 
	    	 }
	     }else {
	    	 
	    	 System.out.println(productAdded.getProductName());
	    	 System.out.println(productAdded.getQuanity()+"kg @ "+productAdded.getUnitPrice()+"/kg  " +productAdded.getPriceBeforeDiscount() );
	     }
	}
    
     
    
}

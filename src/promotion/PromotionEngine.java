package promotion;

import product.Product;

public class PromotionEngine {

	public static PromotionResult calculatePromotion(Product product,double quantity) {
		// TODO Auto-generated method stub
		PromotionResult result = new PromotionResult();
		double priceAfterDiscount = 0;
		if((product.getName().equals("Beans"))&&(((int)quantity)>=3)){
			result.setPromotionName("Beans 3 for 2");
			
			int quantityInt = (int)quantity;
			
			int TimesProApplied = quantityInt/3;
			int quantityNotApplied = quantityInt%3;
			
			priceAfterDiscount = product.getPrice()*2*TimesProApplied+product.getPrice()*quantityNotApplied;
			result.setPriceAfterDiscount(priceAfterDiscount);
		}else if(product.getName().equals("Coke")&&(((int)quantity)>=2)){
			
			result.setPromotionName("Coke 2 for 1£");
            int  quantityInt = (int)quantity;
			
			int timesProApplied = quantityInt/2;
			int quantityNotApplied = quantityInt%2;
			
			priceAfterDiscount =  1 * timesProApplied +quantityNotApplied*product.getPrice();
			result.setPriceAfterDiscount(priceAfterDiscount);
		}else{
			result.setPriceAfterDiscount(product.getPrice()*quantity);
		}
		
	    return result;
	}

}

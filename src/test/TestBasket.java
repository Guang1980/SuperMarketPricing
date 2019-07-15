package test;

import org.junit.Test;

import product.ProductCatalog;
import basket.Basket;

public class TestBasket {
	
	@Test
	public void test1(){
		System.out.println("=============Test1================");
		Basket basket = new Basket();
		basket.addProduct(ProductCatalog.getProduct("Beans"), 1);
		basket.addProduct(ProductCatalog.getProduct("Beans"), 3);
		basket.calcuateBasket();
		System.out.println("=============End Of Test1================");
		
	}
	
	@Test
	public void test2(){
		System.out.println("=============Test2================");
		Basket basket = new Basket();
		basket.addProduct(ProductCatalog.getProduct("Beans"), 1);
		basket.addProduct(ProductCatalog.getProduct("Beans"), 2);
		basket.addProduct(ProductCatalog.getProduct("Coke"), 2);
		basket.addProduct(ProductCatalog.getProduct("Oranges"), 0.1);
		basket.addProduct(ProductCatalog.getProduct("Oranges"), 0.1);
		
		basket.calcuateBasket();
		System.out.println("=============End Of Test2================");
		
	}

}

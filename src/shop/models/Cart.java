package shop.models;

import java.util.ArrayList;

public class Cart {
	public String productName;
	public int cost;
	public int quantity;
	public int productId;
	public int totalCost;
	
	public Cart(int productId,String productName,int quantity, int cost,  int totalCost) {
		this.productId = productId;
		this.productName = productName;
		this.cost = cost;
		this.quantity = quantity;
		this.totalCost = totalCost;
		
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%d\t%d\t%d", this.productName, this.cost, this.quantity, this.totalCost);
	}
	public void remove(ArrayList<Cart> cart) {
		// TODO Auto-generated method stub
		
	}
}

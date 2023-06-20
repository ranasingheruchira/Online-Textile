package com.jayasadha.return_refund_management;

public class OrderIDGenerator {
	
	public int getOrderID(int cusID) {
		
		long timeNow = System.currentTimeMillis();
		
		int part2 = (int) (timeNow%10000000);
		
		String id =""+cusID+part2;
		
		int orderID = Integer.parseInt(id);
		
		return orderID;
		
	}

}

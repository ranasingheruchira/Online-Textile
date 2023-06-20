package com.jayasadha.supplier_financial_management;

public class purchase {
	

	protected int pid;
	protected String productid;
	protected int suppid;
	protected String date;
	protected int quantity;
	protected float unitprice;
	protected float total;
	
	
	
	
	
	public purchase( String productid,int suppid, String date, int quantity, float unitprice) {
		super();
		this.productid = productid;
		this.suppid = suppid;
		this.date = date;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}
	public purchase(int pid,String productid, int suppid, String date, int quantity, float unitprice) {
		super();
		this.pid = pid;
		this.productid = productid;
		this.suppid = suppid;
		this.date = date;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}
	public purchase(int pid, String productid, int suppid, String date, int quantity, float unitprice, float total) {
		super();
		this.pid = pid;
		this.productid = productid;
		this.suppid = suppid;
		this.date = date;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.total = total;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public int getSuppid() {
		return suppid;
	}
	public void setSuppid(int suppid) {
		this.suppid = suppid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public float getTotal() {
		
		total = this.quantity * this.unitprice;
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}

	



}

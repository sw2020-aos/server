package com.aos.requestorder;

import java.util.List;

import com.aos.ingredient.Ingredient;
import com.aos.supplier.Supplier;

public interface RequestOrderService {
	public boolean registRequestOrderInfo(int trayNo, double weight);
	public void sendRequestOrderInfo(RequestOrder requestOrder, Supplier supplier, Ingredient ingredient);
	public RequestOrderInfo viewRequestOrder(RequestOrder requestOrder);
	public List<RequestOrderInfo> searchRequestOrder(String date); 
	public List<RequestOrderInfo> requestOrderList();
	
	public void editRequestOrderInfo(String date);
	public StoreInfo getStoreInfo();
}

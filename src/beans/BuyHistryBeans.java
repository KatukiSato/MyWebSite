package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BuyHistryBeans {

	private int id;
	private int user_id;
	private int total_price;
	private int pay_method_id;
	private int delivery_method_id;
	private Date create_date;

	private String total_priceStr;

	private String pay_method_name;
	private String delivery_method_name;
	private int delivery_method_price;

	private ArrayList<BuyDetailBeans> buyDetailBeans;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getPay_method_id() {
		return pay_method_id;
	}
	public void setPay_method_id(int pay_method_id) {
		this.pay_method_id = pay_method_id;
	}
	public int getDelivery_method_id() {
		return delivery_method_id;
	}
	public void setDelivery_method_id(int delivery_method_id) {
		this.delivery_method_id = delivery_method_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}


	//日時の形式を変える。
	public String getFormatDate() {
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return dformat.format(create_date);
	}

	//必要かどうか不明
	public String getTotal_priceStr() {
		return total_priceStr;
	}
	public void setTotal_priceStr(String total_priceStr) {
		this.total_priceStr = total_priceStr;
	}
	public String getPay_method_name() {
		return pay_method_name;
	}
	public void setPay_method_name(String pay_method_name) {
		this.pay_method_name = pay_method_name;
	}
	public String getDelivery_method_name() {
		return delivery_method_name;
	}
	public void setDelivery_method_name(String delivery_method_name) {
		this.delivery_method_name = delivery_method_name;
	}
	public int getDelivery_method_price() {
		return delivery_method_price;
	}
	public void setDelivery_method_price(int delivery_method_price) {
		this.delivery_method_price = delivery_method_price;
	}
	public ArrayList<BuyDetailBeans> getBuyDetailBeans() {
		return buyDetailBeans;
	}
	public void setBuyDetailBeans(ArrayList<BuyDetailBeans> buyDetailBeans) {
		this.buyDetailBeans = buyDetailBeans;
	}

}

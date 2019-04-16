package beans;

import java.io.Serializable;

public class CartBeans implements Serializable{

	private int id;
	private String login_id;
	private int quality;
	private int item_id;

	private int price;
	private String name;
	private String file_name;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public int getQuality() {
		return quality;
	}
	public String getQualityStr() {
		return String.format("%,d", quality);
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getPrice() {
		return price;
	}
	public String getPriceStr() {
		return  String.format("%,d", price);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public void setUp( String loginId, int quality, int item_id) {
		this.login_id = loginId;
		this.quality = quality;
		this.item_id = item_id;
	}
	public int getTotalprice() {
		return price * quality;
	}

	public String getTotalpriceStr() {
		return String.format("%,d",  price * quality);
	}

	public String getTotalpricetest() {
		return String.format("%,c",  price * quality);
	}

}

package beans;

import java.io.Serializable;

public class ItemBeans implements Serializable{

	private int id;
	private String name;
	private String detail;
	private int price;
	private String file_name;

	private int tagId;
	private String tagName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public String getPriceStr() {
		return String.format("%,d", price);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFileName() {
		return file_name;
	}
	public void setFileName(String file_name) {
		this.file_name = file_name;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}

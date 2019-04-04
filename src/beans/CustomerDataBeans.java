package beans;

public class CustomerDataBeans {

	private int id;
	private String login_id;
	private String name;
	private String mail;
	private String phone;
	private String address;
	private String login_password;
//	private Date create_date;

	// コンストラクタ
	public CustomerDataBeans() {
		this.login_id = "";
		this.name = "";
		this.mail = "";
		this.phone = "";
		this.address = "";
		this.login_password = "";
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}

//	public Date getCreate_date() {
//		return create_date;
//	}
//
//	public void setCreate_date(Date create_date) {
//		this.create_date = create_date;
//	}
}
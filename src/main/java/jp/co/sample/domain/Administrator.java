package jp.co.sample.domain;

/**
 * administratorsテーブルを表すドメイン . 
 * 
 * @author kyoichiro.tomatsu
 * 
 */
public class Administrator {

	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** メールアドレス */
	private String mailAddress;
	/** パスワード */
	private String password;

	public Administrator() {
	}

	public Administrator(Integer id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mailAddress = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String email) {
		this.mailAddress = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", email=" + mailAddress + ", password=" + password + "]";
	}

}

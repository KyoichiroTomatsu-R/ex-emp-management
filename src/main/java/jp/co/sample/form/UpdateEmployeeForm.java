package jp.co.sample.form;

/**
 * 従業員情報を更新するときに使用するフォーム.
 * @author kyoichiro.tomatsu
 *
 */
public class UpdateEmployeeForm {
	/** 従業員ID */
	private String id;
	/** 扶養人数 */
	private String dependentsCont;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCont() {
		return dependentsCont;
	}

	public void setDependentsCont(String dependentsCont) {
		this.dependentsCont = dependentsCont;
	}

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCont=" + dependentsCont + "]";
	}

}

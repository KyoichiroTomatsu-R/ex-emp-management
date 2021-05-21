package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * EmployeeRepositoryクラスです. repository目的で使用してください。
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Repository
public class EmployeeRepository {
	String allData = "id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count";

	@Autowired
	private NamedParameterJdbcTemplate template;

	/** MAPPER */
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);

	/**
	 * findAllメソッド. 全ての従業員を返します。
	 * 
	 * @return
	 */
	public List<Employee> findAll() {
		String sql = "SELECT " + allData + " FROM employees ORDER BY hire_date DESC";

		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);

		return employeeList;
	}

	/**
	 * loadメソッド. 引数で渡されたIDのレコードを返します。
	 * 
	 * @param id
	 * @return
	 */
	public Employee load(Integer id) {
		String sql = "SELECT " + allData + " FROM employees WHERE id=:id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

		return employee;

	}

	/**
	 * updateメソッド。 引数で渡されたレコードに上書きします。
	 * 
	 * @param employee
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);

		String sql = "UPDATE employees SET" + " name=:name," + "image=:image," + "gender=:gender,"
				+ "hire_date=:hireDate," + "mail_address=:mailAddress," + "zip_code=:zipCode," + "address=:address,"
				+ "telephone=:telephone," + "salary=:salary," + "characteristics=:characteristics,"
				+ "dependents_count=:dependentsCount" + "WHERE " + "id=:id;";
		template.update(sql, param);

	}

}

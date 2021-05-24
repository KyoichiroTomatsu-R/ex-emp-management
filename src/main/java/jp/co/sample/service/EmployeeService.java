package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員のリポジトリを使うサービスクラスです.
 * @author kyoichiro.tomatsu
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;
	
	
	/**
	 * 全件検索.
	 * 
	 * @return リポジトリのfindAll()
	 */
	public List<Employee> showList(){
		return employeerepository.findAll();
	}
	
	
	
}

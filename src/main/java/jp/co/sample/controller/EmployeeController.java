package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員を操作するクラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute
	public UpdateEmployeeForm SetUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
	
	/**
	 * 従業員一覧の出力.
	 * @param model　リクエストスコープ
	 * @return 従業員一覧画面にフォワード
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		
		model.addAttribute("employeeList", employeeService.showList());
		
		return "employee/list";
		
	}
	
	/**
	 * 従業員詳細の出力.
	 * @param id　従業員ID
	 * @param model　リクエストスコープ
	 * @return　従業員詳細画面にフォワード
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
		
	}
	
	/**
	 * 従業員情報の更新.
	 * @param form フォーム
	 * @return 従業員一覧画面にフォワード
	 */
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		
		Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
				
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		
		employeeService.update(employee);
		
		return "redirect:/employee/showList";
	}
	
	
}

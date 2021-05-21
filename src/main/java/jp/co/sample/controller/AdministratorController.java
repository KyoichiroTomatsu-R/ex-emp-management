package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratoerService;

/**
 * AdministratorのControllerクラスです.
 * AdministratorのControllerとして利用してください。
 * @author kyoichiro.tomatsu
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	AdministratoerService administratorService;
	
	/**
	 * AdministratorのFormを返すメソッドです.
	 * Administratorのformが返り値として呼ばれます
	 * @return
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministrator() {
		return new InsertAdministratorForm();
	}
	
	/**フォワードするためのtoInsertメソッドです.
	 * administrator/Insertにフォワードされます。
	 * @return
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/Insert";
	}
	
	/**insertメソッドです.
	 * 受け取ったフォームをドメインにしてserviceのinsertメソッドに送ります。
	 * @param form
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		
		Administrator administrator = new Administrator();
		administrator.setName(form.getName());
		administrator.setMailAddress(form.getMailAddress());
		administrator.setPassword(form.getPassword());
		System.out.println(administrator);
		
		administratorService.insert(administrator);
		
		return "redirect:/";
	}
	
	
	
}

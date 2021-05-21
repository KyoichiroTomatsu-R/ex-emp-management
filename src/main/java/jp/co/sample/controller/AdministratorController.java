package jp.co.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratoerService;

/**
 * Administratorを操作するクラス.
 * @author kyoichiro.tomatsu
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	AdministratoerService administratorService;
	
	/**
	 * AdministratorのFormを返すメソッド.
	 * @return
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministrator() {
		return new InsertAdministratorForm();
	}
	
	/**
	 * フォワードするためのtoInsertメソッド.
	 * administrator/Insertにフォワードされます。
	 * @return
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	/**
	 * 引き値の管理者情報を登録.
	 * 受け取ったフォームをドメインにしてserviceのinsertメソッドに送ります。
	 * @param form
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
			
		administratorService.insert(administrator);
		
		return "redirect:/";
	}
	
	/**
	 * Modelオブジェクトに自動格納するためのメソッド.
	 * @return
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	/**
	 * リダイレクトのためのメソッド.
	 * insertからリダイレクトされた時によばれ、loginにフォワードします。
	 * @return
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	
	
	
}

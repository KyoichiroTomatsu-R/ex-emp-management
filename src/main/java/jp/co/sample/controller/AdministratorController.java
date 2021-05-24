package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratoerService;

/**
 * 管理者を操作するコントローラークラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratoerService administratorService;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * AdministratorのFormを返すメソッド.
	 * @return 従業員情報登録フォーム
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministrator() {
		return new InsertAdministratorForm();
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
	 * 従業員登録画面に遷移する.

	 * @return 従業員登録画面にフォワード
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	/**
	 * 管理者情報を登録.

	 * @param form フォーム
	 * @return　ログイン画面にリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
			
		administratorService.insert(administrator);
		
		return "redirect:/";
	}
	
	
	/**
	 * リダイレクトのためのメソッド.
	 * insertからリダイレクトされた時によばれ、loginにフォワードします。
	 * @return ログイン画面にフォワード
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	
	/**
	 * 入力された情報でログイン処理.
	 * @param form 入力された情報
	 * @param model request
	 * @return フォワード
	 */
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if(administrator == null) {
			model.addAttribute("loginFailed", "メールアドレスまたはパスワードが不正です。");
			return "administrator/login";
		}
		session.setAttribute("administratirName", administrator.getName());
		
		return "foward:/employee/showList";
	}
	
	
	
	
}

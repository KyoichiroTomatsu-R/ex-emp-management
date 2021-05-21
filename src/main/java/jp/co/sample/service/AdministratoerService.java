package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * Administratorのリポジトリを使うサービスクラスです.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Service
@Transactional
public class AdministratoerService {
	@Autowired
	AdministratorRepository administratorRepository;

	/**
	 * 引数の管理者データを追加. AdministratorRepositoryのinsertメソッドを利用しています。
	 * 
	 * @param administrator 追加する管理者データ
	 */
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}

	/**
	 * ログイン処理.
	 * @param mailAddress　メールアドレス
	 * @param password　パスワード
	 * @return　成功したログイン管理者情報
	 */
	public Administrator login(String mailAddress,String password) {
		
		return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
		
	}
	
}

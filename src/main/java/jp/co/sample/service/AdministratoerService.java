package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * Administratorのサービスクラスです. Administratorのサービスを使いたい時に利用してください
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
	 * AdministratorServiceのinsertメソッドです.
	 * AdministratorRepositoryのinsertメソッドを利用しています。
	 * 
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}

}

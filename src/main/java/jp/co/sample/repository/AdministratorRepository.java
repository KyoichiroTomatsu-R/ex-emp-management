package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * Administratorsテーブルを操作するリポジトリ.
 * @author kyoichiro.tomatsu
 *
 */
@Repository
public class AdministratorRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	/** ROW_MAPPER */
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs,i) ->{
		Administrator admin = new Administrator();
		
		admin.setId(rs.getInt("id"));
		admin.setName(rs.getString("name"));
		admin.setMailAddress(rs.getString("mail_Address"));
		admin.setPassword(rs.getString("password"));
		return admin;
	};
	
	/**
	 * 管理者情報を登録.
	 * @param administrator　管理者情報
	 */
	public void insert(Administrator administrator) {
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		String insertSql = "INSERT INTO administrators (name,mail_address,password) VALUES(:name,:mailAddress,:password)";
		template.update(insertSql, param);
		
	}
	
	/**
	 * メールアドレスとパスワードが一致するドメインをAdministratorsテーブルから取得.
	 * 
	 * @param mailAddress メールアドレス
	 * @param password パスワード
	 * @return 検索結果
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress,String password) {
		String findSql = "SELECT id,name,mail_address,password FROM administrators WHERE mail_address=:mailAddress AND password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		
		List<Administrator> administratorList = template.query(findSql, param, ADMINISTRATOR_ROW_MAPPER);
		
		if(administratorList.size() == 0) {
			return null;
		}
		
		return administratorList.get(0);
	}
	
	
}

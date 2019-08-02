package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//ポイント１：@Repository データベースのクラスに付ける
@Repository
public class HelloRepository {
	//ポイント２：jdbcTemplate Springが用意したJDBC接続クラス。使う場合は@Autowiredをつけてインスタンスを取得する
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String,Object>findOne(int id){
		//SELECT文
		String query = "select id,name,age from springtest where id=?";
//				+" id,"
//				+" name,"
//				+" age"
//				+"from springtest"
//				+"where id=?";
		Map<String, Object> springtest = jdbcTemplate.queryForMap(query,id);
		System.out.println(springtest);
		return springtest;

	}

}

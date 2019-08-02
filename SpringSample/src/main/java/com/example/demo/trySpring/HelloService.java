package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//ポイント１：@Service
@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;

	public Ao findOne(int id) {

		//1件検索実行
		Map<String, Object>map = helloRepository.findOne(id);

		//Mapから値を取得
		int aoId = (Integer)map.get("id");
		String aoName = (String)map.get("name");
		int age = (Integer)map.get("age");

		//aoクラスに値をセット
		Ao ao = new Ao();

		ao.setAoId(aoId);
		ao.setAoName(aoName);
		ao.setAge(age);

		return ao;
	}
}

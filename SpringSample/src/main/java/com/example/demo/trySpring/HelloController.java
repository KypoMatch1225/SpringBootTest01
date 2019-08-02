package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//ポイント1：@Controller
@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;

	//ポイント２：＠GetMapping HTTPからGetメソッドが送られた時に呼ばれる
	@GetMapping("/hello")
	public String getHello() {
		//returnでhtmlに画面遷移
		return "hello";
	}

	//@RequestParamをつけると画面から入力された値を受け取ることができる
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String s,Model m) {

		//ポイント３：model.addAttribute
		//画面から受け取った文字列をmodelに登録
		m.addAttribute("sample",s);

		//helloResponseに遷移
		return "helloResponse";
		}
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String s, Model m) {
		//Stringからint型に変換
		int id = Integer.parseInt(s);

		//1件検索
		Ao ao = helloService.findOne(id);
		//検索結果をModelに登録
		m.addAttribute("id",ao.getAoId());
		m.addAttribute("name",ao.getAoName());
		m.addAttribute("age",ao.getAge());

		//helloResponseDB.htmlに遷移
		return "helloResponseDB";

	}


}



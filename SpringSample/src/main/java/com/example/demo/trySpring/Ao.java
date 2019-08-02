package com.example.demo.trySpring;

import lombok.Data;

//domainクラス（リポジトリクラスとサービスクラスなどの間で引き渡すクラスのこと）
@Data
public class Ao {

		private int aoId;
		private String aoName;
		private int age;

}

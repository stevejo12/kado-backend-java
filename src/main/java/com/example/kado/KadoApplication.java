package com.example.kado;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.example.kado.InsertUsers;

@SpringBootApplication
public class KadoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(KadoApplication.class, args);
		System.out.println("Hello World!");
		
		InsertUsers insertUserExample = new InsertUsers();
		insertUserExample.insertRecord("joo11@gmail.com","asdf", "aabbcc", "https://images.pexels.com/photos/1310524/pexels-photo-1310524.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
	}

}

package infnet.sisam.teste;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

	public static void main(String[] args) {
		String senha = new BCryptPasswordEncoder().encode("123456");
		System.out.println(senha);
	}
	
}

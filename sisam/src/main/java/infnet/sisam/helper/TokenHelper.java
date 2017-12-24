package infnet.sisam.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import infnet.sisam.dto.TokenDTO;
import infnet.sisam.helper.encryption.TextEncryptor;

@Component
public class TokenHelper {

	@Qualifier("hex")
	@Autowired
	private TextEncryptor encryptor;

	public TokenDTO getClearText(String msgCodificada) {
		try {
			String msgDecodificada = decrypt(msgCodificada);
			TokenDTO dto = new TokenDTO();
			int index = msgDecodificada.indexOf(":");
			dto.setAvaliacaoId(Integer.parseInt(msgDecodificada.substring(0, index)));
			dto.setAlunoId(Integer.parseInt(msgDecodificada.substring(index + 1, msgDecodificada.length())));
			return dto;
		} catch (Exception e) {
			return null;
		}
	}

	public String encrypt(TokenDTO dto) {
		return encryptor.encrypt(dto.getAvaliacaoId().toString() + ":" + dto.getAlunoId().toString());

	}

	private String decrypt(String msg) {
		return encryptor.decrypt(msg);
	}
}

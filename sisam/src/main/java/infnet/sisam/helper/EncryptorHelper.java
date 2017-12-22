package infnet.sisam.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import infnet.sisam.dto.HashAvaliacaoRespostaDTO;
import infnet.sisam.helper.encryption.TextEncryptor;

@Component
public class EncryptorHelper {
	
	@Qualifier("hex")
	@Autowired
	private TextEncryptor encryptor;
	
	public HashAvaliacaoRespostaDTO getClearText(String msgCodificada) {
		String msgDecodificada = decrypt(msgCodificada);
		HashAvaliacaoRespostaDTO dto = new HashAvaliacaoRespostaDTO();
		int index = msgDecodificada.indexOf(":");
		dto.setAvaliacaoId(Integer.parseInt(msgDecodificada.substring(0, index)));
		dto.setAlunoId(Integer.parseInt(msgDecodificada.substring(index + 1, msgDecodificada.length())));
		return dto;
	}

	public String encrypt(HashAvaliacaoRespostaDTO dto) {
		return encryptor.encrypt(dto.getAvaliacaoId().toString() + ":" + dto.getAlunoId().toString());
		
//		String msg = dto.getAvaliacaoId().toString() + ":" + dto.getAlunoId().toString();
//		return new Base64().encodeToString(msg.getBytes());
	}

	private String decrypt(String msg) {
		return encryptor.decrypt(msg);
//		return new String(new Base64().decode(msg));
	}
}

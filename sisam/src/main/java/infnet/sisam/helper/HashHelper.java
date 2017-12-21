package infnet.sisam.helper;

import org.springframework.stereotype.Component;

import infnet.sisam.dto.HashAvaliacaoRespostaDTO;
import infnet.sisam.helper.encryption.Algorithm;
import infnet.sisam.helper.encryption.factory.AlgorithmFactory;

@Component
public class HashHelper {

	public HashAvaliacaoRespostaDTO decodificaBase64(String msgCodificada) {
		String msgDecodificada = decodificaBase64Decoder(msgCodificada);
		HashAvaliacaoRespostaDTO dto = new HashAvaliacaoRespostaDTO();
		int index = msgDecodificada.indexOf(":");
		dto.setAvaliacaoId(Integer.parseInt(msgDecodificada.substring(0, index)));
		dto.setAlunoId(Integer.parseInt(msgDecodificada.substring(index + 1, msgDecodificada.length())));
		return dto;
	}

	public String codificaBase64(HashAvaliacaoRespostaDTO dto) {
		
		Algorithm alg = AlgorithmFactory.getInstance("OCTAL");
		String cifrado = alg.encrypt(dto.getAvaliacaoId().toString() + ":" + dto.getAlunoId().toString());
		return cifrado;
		
//		String msg = dto.getAvaliacaoId().toString() + ":" + dto.getAlunoId().toString();
//		return new Base64().encodeToString(msg.getBytes());
	}

	private String decodificaBase64Decoder(String msg) {
		
		Algorithm alg = AlgorithmFactory.getInstance("OCTAL");
		String textoClaro = alg.decrypt(msg);
		return textoClaro;
		
//		return new String(new Base64().decode(msg));
	}
}

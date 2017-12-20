package infnet.sisam.helper;

import org.apache.tomcat.util.codec.binary.Base64;

import infnet.sisam.dto.HashAvaliacaoRespostaDTO;

public class HashHelper {

	public HashAvaliacaoRespostaDTO decodificaBase64(String msgCodificada) {
		String msgDecodificada = decodificaBase64Decoder(msgCodificada);
		HashAvaliacaoRespostaDTO dto = new HashAvaliacaoRespostaDTO();
		int index = msgDecodificada.indexOf(":");
		dto.setAvaliacaoId(Integer.parseInt(msgDecodificada.substring(0, index)));
		dto.setAlunoId(Integer.parseInt(msgDecodificada.substring(index + 1, msgDecodificada.length())));
		return dto;
	}

	public static String codificaBase64(HashAvaliacaoRespostaDTO dto) {
		String msg = dto.getAvaliacaoId().toString() + ":" + dto.getAlunoId().toString();
		return new Base64().encodeToString(msg.getBytes());
	}

	private static String decodificaBase64Decoder(String msg) {
		return new String(new Base64().decode(msg));
	}
}

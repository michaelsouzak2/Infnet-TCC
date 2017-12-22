package infnet.sisam.helper.encryption;

/**
 * Interface para encriptação e decriptação de texto em claro em cifrado e vice-versa.
 * Implementações: HexEncryptor e OctalEncryptor.
 * 
 * @author Michael Santos
 */
public interface TextEncryptor {
	
	String encrypt(String paramString);

	String decrypt(String paramString);

}

package infnet.sisam.helper.encryption;

import java.lang.reflect.Method;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
abstract class EngineEncryptor implements TextEncryptor {

	private Integer numChars;
	private Integer base;
	private Method converter;

	public EngineEncryptor(Integer numChars, Integer base, Method converter) {
		super();
		this.numChars = numChars;
		this.base = base;
		this.converter = converter;
	}
	
	private int createKey() {
		return new Random().nextInt(34);
	}

	private String toBase(Integer value) {
		try {
			String base = (String) converter.invoke(Integer.class, value.intValue());
			while (base.length() < numChars)
				base = "0" + base;
			return base;
		} catch (Exception e) {
			return null;
		}
	}

	private String inverter(String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++)
			result = result + text.charAt(text.length() - i - 1);
		return result;
	}

	public String encrypt(String clearText) {
		String encryptedText = "";
		Integer key = Integer.valueOf(createKey());
		for (int i = 0; i < clearText.length(); i++)
			encryptedText = encryptedText + toBase(Integer.valueOf(clearText.charAt(i) - key.intValue()));
		return inverter(encryptedText += toBase(key));
	}

	public String decrypt(String encryptedText) {
		String clearText = "";
		encryptedText = inverter(encryptedText);
		Integer key = Integer.valueOf(Integer.parseUnsignedInt(encryptedText.substring(encryptedText.length() - numChars), base));
		String partialEncryptedText = encryptedText.substring(0, encryptedText.length() - numChars);
		for (int i = 0; i < partialEncryptedText.length(); i += numChars) {
			clearText = clearText + Character.toString(
					(char) (Integer.parseUnsignedInt(partialEncryptedText.substring(i, i + numChars), base) + key.intValue()));
		}
		return clearText;
	}
	
}

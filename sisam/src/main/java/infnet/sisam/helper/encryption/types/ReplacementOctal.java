package infnet.sisam.helper.encryption.types;

import java.util.Random;

import infnet.sisam.helper.encryption.Algorithm;

public final class ReplacementOctal implements Algorithm {
	private static final int NUM_CHARS = 3;
	private static final int BASE = 8;

	public ReplacementOctal() {
	}

	public int createKey() {
		return new Random().nextInt(34);
	}

	public String toBase(Integer value) {
		String hex = Integer.toOctalString(value.intValue());
		while (hex.length() < 3)
			hex = "0" + hex;
		return hex;
	}

	public String inverter(String text) throws NullPointerException {
		String result = "";
		for (int i = 0; i < text.length(); i++)
			result = result + text.charAt(text.length() - i - 1);
		return result;
	}

	public String encrypt(String clearText) throws NullPointerException {
		String encryptedText = "";
		Integer key = Integer.valueOf(createKey());
		for (int i = 0; i < clearText.length(); i++)
			encryptedText = encryptedText + toBase(Integer.valueOf(clearText.charAt(i) - key.intValue()));
		return inverter(encryptedText += toBase(key));
	}

	public String decrypt(String encryptedText) throws NullPointerException {
		String clearText = "";
		encryptedText = inverter(encryptedText);
		Integer key = Integer.valueOf(Integer.parseUnsignedInt(encryptedText.substring(encryptedText.length() - 3), 8));
		String partialEncryptedText = encryptedText.substring(0, encryptedText.length() - 3);
		for (int i = 0; i < partialEncryptedText.length(); i += 3) {
			clearText = clearText + Character.toString(
					(char) (Integer.parseUnsignedInt(partialEncryptedText.substring(i, i + 3), 8) + key.intValue()));
		}
		return clearText;
	}
}

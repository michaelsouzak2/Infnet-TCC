package infnet.sisam.helper.encryption.types;

import java.util.Random;

import infnet.sisam.helper.encryption.Algorithm;

public final class ReplacementHex implements Algorithm {
	private static final int NUM_CHARS = 2;
	private static final int BASE = 16;

	public ReplacementHex() {
	}

	public int createKey() {
		return new Random().nextInt(34);
	}

	public String toBase(Integer value) {
		String hex = Integer.toHexString(value.intValue());
		while (hex.length() < 2)
			hex = "0" + hex;
		return hex;
	}

	public String inverter(String text) {
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
		Integer key = Integer
				.valueOf(Integer.parseUnsignedInt(encryptedText.substring(encryptedText.length() - 2), 16));
		String partialEncryptedText = encryptedText.substring(0, encryptedText.length() - 2);
		for (int i = 0; i < partialEncryptedText.length(); i += 2) {
			clearText = clearText + Character.toString(
					(char) (Integer.parseUnsignedInt(partialEncryptedText.substring(i, i + 2), 16) + key.intValue()));
		}
		return clearText;
	}
}

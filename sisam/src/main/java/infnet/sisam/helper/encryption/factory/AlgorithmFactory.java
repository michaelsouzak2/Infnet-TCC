package infnet.sisam.helper.encryption.factory;

import infnet.sisam.helper.encryption.Algorithm;
import infnet.sisam.helper.encryption.types.ReplacementHex;
import infnet.sisam.helper.encryption.types.ReplacementOctal;

public abstract class AlgorithmFactory {
	public AlgorithmFactory() {
	}

	public static Algorithm getInstance(String type) {
		if ("HEX".equalsIgnoreCase(type))
			return new ReplacementHex();
		if ("OCTAL".equalsIgnoreCase(type)) {
			return new ReplacementOctal();
		}
		return null;
	}
}

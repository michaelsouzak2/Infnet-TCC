package infnet.sisam.helper.encryption;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("hex")
@Component
public final class HexEncryptor extends EngineEncryptor {
	private static final int NUM_CHARS = 2;
	private static final int BASE = 16;

	public HexEncryptor() throws Exception {
		super(NUM_CHARS, BASE, Integer.class.getMethod("toHexString", int.class));
	}

}

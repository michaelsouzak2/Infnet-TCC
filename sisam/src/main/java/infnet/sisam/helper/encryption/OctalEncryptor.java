package infnet.sisam.helper.encryption;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("octal")
@Component
public final class OctalEncryptor extends EngineEncryptor {
	private static final int NUM_CHARS = 3;
	private static final int BASE = 8;

	public OctalEncryptor() throws Exception {
		super(NUM_CHARS, BASE, Integer.class.getMethod("toOctalString", int.class));
	}
	
	
}

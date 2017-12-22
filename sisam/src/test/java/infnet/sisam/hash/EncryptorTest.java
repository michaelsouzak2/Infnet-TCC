package infnet.sisam.hash;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import infnet.sisam.helper.encryption.HexEncryptor;
import infnet.sisam.helper.encryption.OctalEncryptor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HexEncryptor.class, OctalEncryptor.class})
@ActiveProfiles("dev")
public class EncryptorTest {
	
	@Autowired
	private HexEncryptor encryptor;

	@Test
	public void execute() {
		
		String textoClaro = "52:2887";

		String cifrado = encryptor.encrypt(textoClaro);
		String retorno = encryptor.decrypt(cifrado);
		
		Assert.assertEquals(retorno, textoClaro);
		
	}

}

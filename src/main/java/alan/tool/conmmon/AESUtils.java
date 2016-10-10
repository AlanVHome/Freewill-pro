package alan.tool.conmmon;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;



/**
 * AES加密与解密
 * @author Lamen 2016-01-19
 */
public class AESUtils {
//	private static final Logger logger = LoggerFactory.getLogger(AESUtils.class);
	/**
	 * 加密
	 * @param content 要加密的内容
	 * @param encryptKey 加密密钥
	 * @return
	 */
	public static String aesEncrypt(String content, String encryptKey) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG"); 
			secureRandom.setSeed(encryptKey.getBytes("utf8"));                      
			kgen.init(128, secureRandom);
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
			
			return Base64.encodeBase64String(cipher.doFinal(content.getBytes("utf8")));
			
		} catch (Exception e) {
//			logger.error("encryption content in aesEncrypt() error!", e);
			return null;
		}
	}
	/**
	 * 解密
	 * @param encryptStr 要解密的内容
	 * @param decryptKey 解密密钥
	 * @return
	 */
	public static String aesDecrypt(String encryptStr, String decryptKey) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(decryptKey.getBytes("utf8"));                      
			kgen.init(128, secureRandom);
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
			
			return new String(cipher.doFinal(Base64.decodeBase64(encryptStr)),"utf8");
			
		} catch (Exception e) {
//			logger.error("decode encryptStr in aesDecrypt() error!", e);
			return null;
		}
	}
}

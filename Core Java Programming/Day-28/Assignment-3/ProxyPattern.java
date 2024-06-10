package Day_28;

class SensitiveObject {
	private String secretKey;

	public SensitiveObject(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getSecretKey() {
		return secretKey;
	}
}

class SensitiveObjectProxy {
	private SensitiveObject sensitiveObject;
	private String correctPassword;

	public SensitiveObjectProxy(String secretKey, String correctPassword) {
		this.sensitiveObject = new SensitiveObject(secretKey);
		this.correctPassword = correctPassword;
	}

	public String getSecretKey(String password) {
		if (password.equals(correctPassword)) {
			return sensitiveObject.getSecretKey();
		} else {
			return "Access Denied: Incorrect Password";
		}
	}
}

public class ProxyPattern {
	public static void main(String[] args) {
		SensitiveObjectProxy proxy = new SensitiveObjectProxy("1234-5678-9101-1121", "password123");
		System.out.println(proxy.getSecretKey("password123")); // Correct password
		System.out.println(proxy.getSecretKey("wrongPassword")); // Incorrect password
	}
}
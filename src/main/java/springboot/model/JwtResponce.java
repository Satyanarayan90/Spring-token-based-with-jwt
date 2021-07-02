package springboot.model;

public class JwtResponce {
	String Token;

	
	
	
	public JwtResponce(String token) {
		super();
		Token = token;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	@Override
	public String toString() {
		return "JwtResponce [Token=" + Token + "]";
	}
	
	
}

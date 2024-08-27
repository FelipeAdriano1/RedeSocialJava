package redeSocial;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	
	public boolean validarEmail(String email) {
		Pattern pat = Pattern.compile(EMAIL_REGEX);
		Matcher mat = pat.matcher(email);
		return mat.matches();
	}
}

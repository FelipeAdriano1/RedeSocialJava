package redeSocial;

import java.util.ArrayList;
import java.util.List;

public class RedeSocial {
	List<Usuario> users = new ArrayList<>();
	
	public RedeSocial() {}
	
	public boolean isRegistrado(String email, String senha) {
		for(Usuario u : users) {
			if(u.getEmail().equals(email) && u.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	public String addUsuario(String nome, String senha, String email, String tipo) {
		Regex reg = new Regex();

		switch(tipo) {
		case "Comum": 
			if (reg.validarEmail(email) && nome != null) {
				Usuario user = new UsuarioComum(nome, email, senha, tipo);
				users.add(user);
				return "\nCadastro comum efetuado com sucesso !";
			}
		
		case "Premium":
			if (reg.validarEmail(email) && nome != null) {
				Usuario user = new UsuarioPremium(nome, email, senha, tipo);
				users.add(0,user);
				return "\nCadastro premium efetuado com sucesso !";
			}
			
			
		case "Admin": 
			if (reg.validarEmail(email) && nome != null) {
				Usuario user = new UsuarioAdmin(nome, email, senha, tipo);
				users.add(user);
				return "\nCadastro admin efetuado com sucesso !";
			}
			
		}
		return "\nNão foi possível efetuar o cadastro.";
	}
	
	public List<Usuario> getUsuarios(){
		return users;
	}
	
	public Usuario getUsuario(String email) {
		for(Usuario u : users) {
			if(u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}
}

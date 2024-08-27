package redeSocial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

abstract class Usuario {
	private String nome;
	private String email;
	private String senha;
	private String tipo;
	private int uid;
	private List<Postagens> posts = new ArrayList<>(); 
	Random rnd = new Random();
	
	public Usuario(String nome, String email, String senha, String tipo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		uid = rnd.nextInt(1000);
		this.tipo = tipo;
	}
	
	abstract String adicionarPostagens(String titulo, String conteudo);
	abstract String removerPostagens(int PID);
	abstract String banirUsuario(int UID);
	
	public String curtir(int pid, int uid) {
	    for (Postagens post : posts) {
	        if (post.getPID() == pid) {
	            return post.curtir(pid, uid);
	        }
	    }
	    return "Postagem não encontrada";
	}
	
	public String setNome(String novoNome) {
		if(novoNome != null && novoNome != this.nome) {
			this.nome = novoNome;
			return "\nNome de usuário alterado com sucesso !";
		}
		else {
			return "\nNão foi possível alterar o nome de usuário";
		}
	}
	
	public String setSenha(String novaSenha) {
		if(novaSenha != null && novaSenha != this.senha) {	
			this.senha = novaSenha;
			return "\nSenha alterada com sucesso !";
		}
		else {
			return "\nNão foi possível alterar a senha";
		}
	}
	
	public String setEmail(String novoEmail) {
		if(novoEmail != null && novoEmail != this.email) {
			this.email = novoEmail;
			return "\nEmail alterado com sucesso !";
		}
		else {
			return "\nNão foi possível alterar o email";
		}
	}
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public int getUID() {
		return uid;
	}
	public List<Postagens> getPostagens() {
		return posts;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

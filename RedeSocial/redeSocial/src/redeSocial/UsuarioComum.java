package redeSocial;
import java.util.List;

public class UsuarioComum extends Usuario {
	
	public UsuarioComum(String nome, String email, String senha, String tipo) {
		super(nome, email, senha, tipo);
	}
	
	public String adicionarPostagens(String titulo, String conteudo) {
		if(titulo != null && conteudo != null) {
			List<Postagens> posts = getPostagens();
			
			Postagens post = new PostagemComum(titulo, conteudo);
			
			posts.add(post);
			return "\nPublicação adicionada com sucesso !";
		}
		else {
			return "\nNão foi possível adicionar publicação.";
		}
	}
	
	public String removerPostagens(int PID) {
		return "false";
	}
	
	public String banirUsuario(int UID) {
		return "false";
	}
}

package redeSocial;
import java.util.List;
import java.util.Map;

public class PostagemComum extends Postagens{
	
	public PostagemComum(String titulo, String conteudo) {
		super(titulo, conteudo);
	}
	
	public boolean adicionarComentario(Integer pid, Integer uid, String Comentario) {
		List<Comentarios> coment = getComentarios();
		
		Comentarios comentario = new Comentarios(pid, uid, Comentario);
		
		coment.add(comentario);
		return false;
	}
}

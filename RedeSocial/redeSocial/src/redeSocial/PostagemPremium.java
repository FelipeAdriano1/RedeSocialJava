package redeSocial;

import java.util.List;
import java.util.Map;

public class PostagemPremium extends Postagens{
	public PostagemPremium(String titulo, String conteudo) {
		super(titulo, conteudo);
	}
	
	public boolean adicionarComentario(Integer pid, Integer uid, String Comentario) {
		List<Comentarios> coment = getComentarios();
		
		Comentarios comentario = new Comentarios(pid, uid, Comentario);
		
		coment.add(comentario);
		return false;
	}
	
	@Override
	public String curtir(int PID, int UID) {
		curtidas.put(PID, UID);
		return "Postagem curtida";
	}
}

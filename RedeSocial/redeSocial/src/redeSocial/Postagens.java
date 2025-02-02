package redeSocial;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

abstract class Postagens implements Curtivel {
	private int pid;
	private String titulo;
	private String conteudo;
	private Date dataCriacao;
	private List<Comentarios> comentarios = new ArrayList<>();
	public Map<Integer, Integer> curtidas = new HashMap<>();
	Random rnd = new Random();
	
	public Postagens(String titulo, String conteudo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
		pid = rnd.nextInt(1000);
		dataCriacao = new Date();
	}
	
	abstract boolean adicionarComentario(Integer pid, Integer uid, String comentario);
	
	@Override
	public String curtir(int pid, int uid) {
	    curtidas.put(uid, pid);
	    return "Postagem curtida";
	}
	
	@Override
	public Map<Integer, Integer> getCurtidas() {
		return curtidas;
	}
	
	public String setTitulo(String titulo) {
		if(titulo != null || titulo != this.titulo) {
			this.titulo = titulo;
			return "\nTítulo da publicação alterado com sucesso !";
		}
		else {
			return "\nTítulo inválido. Tente novamente";
		}
	}
	
	public String setConteudo(String conteudo) {
		if(conteudo != null || conteudo != this.conteudo) {
			this.conteudo = conteudo;
			return "\nConteúdo da postagem alterado com sucesso !";
		}
		else {
			return "\nNão foi possível alterar o conteúdo da postagem";
		}
	}
	
	//MÉTODOS GETTERS
	public int getPID() {
		return pid;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public Date getData() {
		return dataCriacao;
	}
	public List<Comentarios> getComentarios() {	
		return comentarios;
	}
}

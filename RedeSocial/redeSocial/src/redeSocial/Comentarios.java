package redeSocial;
import java.util.Random;

public class Comentarios {
	private int uid; //Usuário ID
	private int pid; //Postagem ID
	private int cid; //Comentário ID
	private String comentario;
	Random rnd = new Random();
	
	public Comentarios(Integer pid, Integer uid, String comentario) {
		this.pid = pid;
		this.uid = uid;
		cid = rnd.nextInt(1000);
		this.comentario = comentario;
	}
}

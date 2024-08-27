package redeSocial;

import java.util.Map;

interface Curtivel {
	public String curtir(int pid, int uid);
	
	public Map<Integer, Integer> getCurtidas();
}

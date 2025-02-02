package redeSocial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		RedeSocial rede = new RedeSocial();
		
		//VARIÁVEIS PARA CADASTRO DE USUÁRIO
		String email;
		String senha;
		String nome;
		String tipo;
		
		//VARIÁVEIS PARA CADASTRO DE UMA NOVA PUBLICAÇÃO
		String titulo;
		String conteudo;
		
		//VARIÁVEIS PARA LÓGICA DO LOOP E ESCOLHAS DE USUÁRIO
		boolean logado = false;
		boolean saida = false;
		int escolha = 0;
		int isRegistrado = 0;
		int delPubli = 0;
		int delUser = 0;
		int like = 0;

		do {
			System.out.println("Bem vindo ao LinkUp !!");
			System.out.println("\nVocê tem login em nossa plataforma ?\n1 - SIM | 2 - NÃO");
			isRegistrado = Integer.parseInt(reader.readLine());
			
			switch (isRegistrado) {
			case 1:
				System.out.println("\nDigite seu email: ");
				email = reader.readLine();

				System.out.println("\nDigite sua senha: ");
				senha = reader.readLine();

				if (rede.isRegistrado(email, senha) == true) {
					
					Usuario usuario = rede.getUsuario(email);
					System.out.println("\nVocê está logado !");
					logado = true;

					while (logado == true) {
						
						switch (usuario.getTipo()) {
						case "Comum":
							System.out.println("\nOpções para Conta Comum:");
							System.out.println("1 - Adicionar publicações");
							System.out.println("2 - Ver publicações");
							System.out.println("3 - Curtir publicação");
							System.out.println("4 - Sair");
							
							escolha = Integer.parseInt(reader.readLine());
							
							switch(escolha) {
							case 1: 
								System.out.println("\nDigite o título da publicação:");
								titulo = reader.readLine();
								
								System.out.println("Digite o conteúdo da publicação:");
								conteudo = reader.readLine();
								
								usuario.adicionarPostagens(titulo, conteudo);
								break;
							
							case 2:
								for(Usuario u : rede.getUsuarios()) {
									for(Postagens p : u.getPostagens()) {
										System.out.println("\n------------------------------");
										System.out.println("Publicação " + p.getPID());
										System.out.println("Autor: " + u.getNome());
										System.out.println("Título: " + p.getTitulo());
										System.out.println("Conteúdo: " + p.getConteudo());
										System.out.println("Curtidas " + p.getCurtidas());
										System.out.println("------------------------------");
									}	
								}
								break;
							
							case 3: 
								for(Usuario u : rede.getUsuarios()) {
									for(Postagens p : u.getPostagens()) {
										System.out.println("\n------------------------------");
										System.out.println("Publicação " + p.getPID());
										System.out.println("Autor: " + u.getNome());
										System.out.println("Título: " + p.getTitulo());
										System.out.println("Conteúdo: " + p.getConteudo());
										System.out.println("Curtidas " + p.getCurtidas());
										System.out.println("------------------------------");
									}	
								}
								
								System.out.println("\nDigite o ID da publicação que quer curtir: ");
								like = Integer.parseInt(reader.readLine());
								
								usuario.curtir(like, 1);
								break;
								
							case 4:
								logado = false;
								break;
							}
							break;
							
						case "Premium":
							System.out.println("\nOpções para Conta Premium:");
							System.out.println("\n1 - Adicionar publicações em destaque");
							System.out.println("2 - Publicações em destaque");
							System.out.println("3 - Curtir publicações");
							System.out.println("4 -Sair");
							
							escolha = Integer.parseInt(reader.readLine());
							
							switch(escolha) {
							case 1: 
								System.out.println("\nDigite o título da publicação:");
								titulo = reader.readLine();
								
								System.out.println("Digite o conteúdo da publicação:");
								conteudo = reader.readLine();
								
								usuario.adicionarPostagens(titulo, conteudo);
								break;
							
							case 2:
								for(Usuario u : rede.getUsuarios()) {
									for(Postagens p : u.getPostagens()) {
										System.out.println("\n------------------------------");
										System.out.println("Publicação " + p.getPID());
										System.out.println("Autor: " + u.getNome());
										System.out.println("Título: " + p.getTitulo());
										System.out.println("Conteúdo: " + p.getConteudo());
										System.out.println("Curtidas " + p.getCurtidas());
										System.out.println("------------------------------");
									}	
								}
								break;
								
							case 3: 
								for(Usuario u : rede.getUsuarios()) {
									for(Postagens p : u.getPostagens()) {
										System.out.println("\n------------------------------");
										System.out.println("Publicação " + p.getPID());
										System.out.println("Autor: " + u.getNome());
										System.out.println("Título: " + p.getTitulo());
										System.out.println("Conteúdo: " + p.getConteudo());
										System.out.println("Curtidas " + p.getCurtidas());
										System.out.println("------------------------------");
									}	
								}
								
								System.out.println("\nDigite o ID da publicação que quer curtir: ");
								like = Integer.parseInt(reader.readLine());
								
								usuario.curtir(like, 1);
								break;
							
							case 4:
								logado = false;
								break;
							}
							break;
							
						case "Admin":
							System.out.println("\nOpções para Conta Admin:");
							System.out.println("\n1 - Remover outros usuários");
							System.out.println("2 - Remover qualquer publicação");
							System.out.println("3 - Sair");
							
							escolha = Integer.parseInt(reader.readLine());
							
							switch(escolha) {
							case 1:
								System.out.println("\nListando Usuários...\n");
								for(Usuario u : rede.getUsuarios()) {
									System.out.println("\n------------------------------");
									System.out.println("UID: " + u.getUID());
									System.out.println("Nome: " + u.getNome());
									System.out.println("------------------------------");
								}
								
								System.out.println("\nDigite o id do usuário de quer excluir: ");
								delUser = Integer.parseInt(reader.readLine());
								
								System.out.println(usuario.banirUsuario(delUser));
								break;
							
							case 2:
								System.out.println("\nListando publicações ...\n");
								for(Usuario u : rede.getUsuarios()) {
									for(Postagens p : u.getPostagens()) {
										System.out.println("\n------------------------------");
										System.out.println("Publicação " + p.getPID());
										System.out.println("Autor: " + u.getNome());
										System.out.println("Título: " + p.getTitulo());
										System.out.println("Conteúdo: " + p.getConteudo());
										System.out.println("Curtidas " + p.getCurtidas());
										System.out.println("------------------------------");
									}	
								}
								
								System.out.println("\nDigite o id da publicação de quer excluir: ");
								delPubli = Integer.parseInt(reader.readLine());
								
								System.out.println(usuario.removerPostagens(delPubli));
								break;
								
							case 3:
								logado = false;
								break;
							}
						}
					}
				} else {
					System.out.println("\nCadastro não encotrado em nossa plataforma");
					saida = false;
				}

				break;
			// CASO O USUÁRIO NÃO FOR CADASTRADO
			case 2:
				System.out.println("\nQue tipo de acesso deseja ter ?");
				System.out.println("\n\u001B[32mComum: \n-Adicionar publicações\n-Não pode remover publicações");
				System.out.println("\n\u001B[33mPremium:\n-Adicionar publicações\n-Remover próprias publicações\n-Publicações em destaque");
				System.out.println("\n\u001B[35mAdmin:\n-Pode remover outros usuários\n-Pode remover qualquer publicação.");
				System.out.println("\u001B[0m");

				tipo = reader.readLine();
				if (tipo.equals("1")) {
					tipo = "Comum";
				} 
				else if (tipo.equals("2")) {
					tipo = "Premium";
				} 
				else {
					tipo = "Admin";
				}

				System.out.println("\nVamos realizar seu cadastro, para isso;");

				System.out.println("\nDigite seu nome: ");
				nome = reader.readLine();

				System.out.println("\nDigite seu email: ");
				email = reader.readLine();

				System.out.println("\nDigite uma senha: ");
				senha = reader.readLine();

				if (rede.isRegistrado(email, senha) == true) {
					System.out.println("\nVocê já é cadastrado.");
					break;
				} 
				else {
					System.out.println(rede.addUsuario(nome, senha, email, tipo));
					saida = false;
					
				}
				break;
			}
		} while (!saida);
	}
}

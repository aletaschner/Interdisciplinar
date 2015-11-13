package model;

public class Usuario {
	
	/*UsuarioNivel 
	 * 	0 -> Acesso Normal
	 * 	1 -> Acesso Administrador
	 */
	
	private int Usuarioid, UsuarioNivel,AlunoId;
	private String UsuarioNome,UsuarioSenha;
	
	public int getUsuarioid() {
		return Usuarioid;
	}
	public void setUsuarioid(int usuarioid) {
		Usuarioid = usuarioid;
	}
	public int getUsuarioNivel() {
		return UsuarioNivel;
	}
	public void setUsuarioNivel(int usuarioNivel) {
		UsuarioNivel = usuarioNivel;
	}
	public int getAlunoId() {
		return AlunoId;
	}
	public void setAlunoId(int alunoId) {
		AlunoId = alunoId;
	}
	public String getUsuarioNome() {
		return UsuarioNome;
	}
	public void setUsuarioNome(String usuarioNome) {
		UsuarioNome = usuarioNome;
	}
	public String getUsuarioSenha() {
		return UsuarioSenha;
	}
	public void setUsuarioSenha(String usuarioSenha) {
		UsuarioSenha = usuarioSenha;
	}

}

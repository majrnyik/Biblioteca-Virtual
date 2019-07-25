package usuario;

public abstract class Usuario {
	private String Nome, Sobrenome, Email;
	private int iD, senha;
	
	//construtor da classe abstrata usuario
	public Usuario (String Nome, String Sobrenome, String Email, int iD, int senha) {
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.Email = Email;
		this.iD = iD;
		this.senha = senha;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String newNome) {
		this.Nome = newNome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String newSobrenome) {
		this.Sobrenome = newSobrenome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String newEmail) {
		this.Email = newEmail;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
}

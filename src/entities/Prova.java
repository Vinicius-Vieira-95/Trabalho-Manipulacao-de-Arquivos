package entities;

public class Prova {

	private String aluno;
	private String res;

	public Prova(String aluno, String res) {
		this.aluno = aluno;
		this.res = res;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return aluno + ", " + res ;
	}
	
	

}

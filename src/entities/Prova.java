package entities;

public class Prova implements Comparable<Prova> {

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
	public int compareTo(Prova o) {
		return aluno.compareTo(o.getAluno());
	}

	@Override
	public String toString() {
		return aluno + ", " + res ;
	}
	
	

}

package webservicesdisciplinas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disciplina {
	@Id
	private String codigo;
	private String nome;
	private String descricao;
	private String professor;

	public Disciplina(String string, String string2, String string3, String string4) {
		this.codigo=string;
		this.nome=string2;
		this.descricao=string3;
		this.professor=string4;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

}

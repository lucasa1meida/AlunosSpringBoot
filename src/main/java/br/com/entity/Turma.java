package br.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="turma")
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTurma;
	@Column(unique=true)
	private String nomeTurma;
	@OneToMany(mappedBy="turma", fetch= FetchType.EAGER, cascade = { CascadeType.ALL})
	private List<Aluno> alunos;
	
	public Turma() {
	}
	
	public Turma(Integer idTurma, String nomeTurma, List<Aluno> alunos) {
		super();
		this.idTurma = idTurma;
		this.nomeTurma = nomeTurma;
		this.alunos = alunos;
	}
	
	public Turma(String nomeTurma) {
		super();
		this.nomeTurma = nomeTurma;
	}

	@Override
	public String toString() {
		return "Turma [idTurma=" + idTurma + ", nomeTurma=" + nomeTurma + ", alunos=" + alunos + "]";
	}	
	
	public Integer getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

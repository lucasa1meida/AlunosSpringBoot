package br.com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAluno;
	@Column(length=50)
	private String nome;	
	@Column
	private Double nota1;
	@Column
	private Double nota2;
	@Column
	private Double media;
	@Column
	private String situacao;	
	@ManyToOne
	@JoinColumn(name = "id_turma", referencedColumnName ="idTurma")
	private Turma turma;
	
	public Aluno() {
	}

	public Aluno(Long idAluno, String nome, Double nota1, Double nota2) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	public Aluno(String nome, Double nota1, Double nota2) {
		super();
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	public Aluno(Long idAluno, String nome, Double nota1, Double nota2, Double media, String situacao) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", nota1=" + nota1 + ", nota2="
				+ nota2 + ", media=" + media + ", situacao=" + situacao + "]";
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void gerarMedia() {
		this.media = (this.nota1 + this.nota2) / 2;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void gerarSituacao() {
		if(this.media>=7) {
			this.situacao = "Aprovado";
		}else{
			this.situacao = "Reprovado";
		}
	}

}

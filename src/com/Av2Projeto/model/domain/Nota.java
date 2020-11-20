package com.Av2Projeto.model.domain;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Nota {
	private Integer id_nota;
	private float av1;
	private float av2;
	private float av3;
	private float aps_1;
	private float aps_2;
	private float media;
	private Integer id_aluno;
	private Integer id_turma;

	public Nota() {
		super();
	}

	

		public Nota(Integer id_nota, float av1, float av2, float av3, float aps_1, float aps_2, float media,
			Integer id_aluno, Integer id_turma) {
		super();
		this.id_nota = id_nota;
		this.av1 = av1;
		this.av2 = av2;
		this.av3 = av3;
		this.aps_1 = aps_1;
		this.aps_2 = aps_2;
		this.media = media;
		this.id_aluno = id_aluno;
		this.id_turma = id_turma;
	}



	public int getId_nota() {
		return id_nota;
	}

	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}

	public float getAv1() {
		return av1;
	}

	public void setAv1(float av1) {
		this.av1 = av1;
	}

	public float getAv2() {
		return av2;
	}

	public void setAv2(float av2) {
		this.av2 = av2;
	}

	public float getAv3() {
		return av3;
	}

	public void setAv3(float av3) {
		this.av3 = av3;
	}

	public float getAps_1() {
		return aps_1;
	}

	public void setAps_1(float aps_1) {
		this.aps_1 = aps_1;
	}

	public float getAps_2() {
		return aps_2;
	}

	public void setAps_2(float aps_2) {
		this.aps_2 = aps_2;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public int getId_turma() {
		return id_turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}

}

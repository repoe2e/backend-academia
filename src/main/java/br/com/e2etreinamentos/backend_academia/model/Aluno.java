package br.com.e2etreinamentos.backend_academia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    private Long id;

    private String nome;

    private String email;

    private Integer idade;

    private String whatsapp;

    public Aluno(Long id,
            String nome,
            String email,
            Integer idade,
            String whatsapp) {

   this.id = id;
   this.nome = nome;
   this.email = email;
   this.idade = idade;
   this.whatsapp = whatsapp;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	
    
}
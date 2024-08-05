package app;

import javax.swing.JOptionPane;

public class Aluno extends PessoaFisica{

	private String matricula, 
	       curso;
	
	public Aluno(String nome, String cpf, String email, String matricula, String curso) throws CampoEmBrancoException {
		super(nome, cpf, email);
		
	     try {
	            setNome(nome);
	        } catch (CampoEmBrancoException e) {
	        	System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Nome em branco.");
	        }
	        try {
	            setMatricula(matricula);
	        } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Matricula em branco.");
	        }
	        try {
	            setEmail(email);
	        } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Email em branco.");
	        }
	        try {
	            setCurso(curso);
	        } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Curso em branco.");
	        }
	        try {
	        	setCpf(cpf);
	        }catch (CampoEmBrancoException e) {
	        	System.out.println(e.getMessage());
	        	JOptionPane.showMessageDialog(null, "Cpf em branco.");
	        }
	    }
	
	public boolean validarAluno() {
	    try {
	        setNome(nome);
	        setMatricula(matricula);
	        setEmail(email);
	        setCurso(curso);
	        setCpf(cpf);
	        return true;
	    } catch (CampoEmBrancoException e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CampoEmBrancoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("O campo 'nome' está em branco.");
        }
        this.nome = nome;
    }

    public final String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws CampoEmBrancoException {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new CampoEmBrancoException("O campo 'matrícula' está em branco.");
        }
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws CampoEmBrancoException {
        if (email == null || email.trim().isEmpty()) {
            throw new CampoEmBrancoException("O campo 'email' está em branco.");
        }
        this.email = email;
    }

    public final String getCurso() {
        return curso;
    }

    public void setCurso(String curso) throws CampoEmBrancoException {
        if (curso == null || curso.trim().isEmpty()) {
            throw new CampoEmBrancoException("O campo 'curso' está em branco.");
        }
        this.curso = curso;
    }
    
    public String getCpf() {
    	return cpf;
    }
    
    public void setCpf(String cpf) throws CampoEmBrancoException {
    	if (cpf == null || cpf.trim().isEmpty()) {
    		throw new CampoEmBrancoException("O campo 'cpf' está branco."); 
    	}
    	this.cpf = cpf;
    }

	
	protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	
	public String toString() {
		String resposta = "ALUNO\n";
		resposta += "NOME: " + nome + '\n';
		resposta += "CPF: " + cpf + '\n'; 
		resposta += "EMAIL: " + email + '\n';
		resposta += "MATRICULA: " + matricula + '\n';
		resposta += "CURSO: " + curso + '\n';
		return resposta;
	}

}
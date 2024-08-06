package app;

import javax.swing.JOptionPane;

public class Professor extends PessoaFisica{
	
	private String areaFormacao, 
	       matriculaFUB; 
	
	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB) throws CampoEmBrancoException {
		super(nome, cpf, email);

		 try {
	            setNome(nome);
	        } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Nome em branco.");
	        }
	        try {
	            setMatriculaFUB(matriculaFUB);
	        } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Matricula FUB em branco.");

	        }
	        try {
	            setEmail(email);
	        } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Email em branco.");

	        }
	        try {
	            setAreaFormacao(areaFormacao);
	        } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Area de formacao em branco.");

	        }
	        try {
	        	setCpf(cpf);
	        }catch (CampoEmBrancoException e) {
	        	System.out.println(e.getMessage());
	        	JOptionPane.showMessageDialog(null, "Cpf em branco.");
	        }
	    }
    
	public boolean validarProfessor() {
	    try {
	        setNome(nome);
	        setMatriculaFUB(matriculaFUB);
	        setEmail(email);
	        setAreaFormacao(areaFormacao);
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

	    public final String getMatriculaFUB() {
	        return matriculaFUB;
	    }

	    public void setMatriculaFUB(String matriculaFUB) throws CampoEmBrancoException {
	        if (matriculaFUB == null || matriculaFUB.trim().isEmpty()) {
	            throw new CampoEmBrancoException("O campo 'matrícula FUB' está em branco.");
	        }
	        this.matriculaFUB = matriculaFUB;
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

	    public final String getAreaFormacao() {
	        return areaFormacao;
	    }

	    public void setAreaFormacao(String areaFormacao) throws CampoEmBrancoException {
	        if (areaFormacao == null || areaFormacao.trim().isEmpty()) {
	            throw new CampoEmBrancoException("O campo 'área de formação' está em branco.");
	        }
	        this.areaFormacao = areaFormacao;
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
	

	
	public String toString() {
		String resposta = "PROFESSOR\n";
		resposta += "NOME: " + nome + '\n';
		resposta += "CPF: " + cpf + '\n'; 
		resposta += "EMAIL: " + email + '\n';
		resposta += "Area de Formacao: " + areaFormacao + '\n';
		resposta += "Matricula: " + matriculaFUB + '\n';
		return resposta;
	}
	
}
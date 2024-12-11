import java.time.LocalDate;

import br.senac.criancaemfoco.modelo.dao.contato.ContatoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.endereco.EnderecoDAO;
import br.senac.criancaemfoco.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.papel.PapelDAOImpl;
import br.senac.criancaemfoco.modelo.dao.pessoa.aluno.AlunoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.escola.EscolaDAOImpl;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.responsavel.ResponsavelDAOImpl;
import br.senac.criancaemfoco.modelo.dao.turma.TurmaDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.responsavel.Responsavel;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;

public class Main {
	public static void main(String[] args) {

		AlunoDAOImpl alunoDAO = new AlunoDAOImpl();
		Aluno aluno = new Aluno();
		
		aluno.setTurma(null);
		aluno.setResponsavel(null);
		
		aluno.setMatricula(12);
		aluno.setNomeId("Maria");
		aluno.setIdFiscal("cccc");
		aluno.setSobrenome("Eugenia");
		aluno.setDataNascimento(LocalDate.of(2004, 1, 23));
		
		alunoDAO.inserirAluno(aluno);
		

		
	}
}
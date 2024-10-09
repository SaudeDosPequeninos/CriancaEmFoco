import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.senac.criancaemfoco.modelo.dao.agendamento.AgendamentoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.insumo.InsumoDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento;
import br.senac.criancaemfoco.modelo.entidade.insumo.Insumo;

public class Main {
	public static void main(String[] args) {
		InsumoDAOImpl usuarioDAO = new InsumoDAOImpl();
		Insumo usuario = new Insumo();
		LocalDate data = LocalDate.parse("2026-02-05");
		//LocalTime horario = LocalTime.parse("15:30:00");
		//LocalTime duracao = LocalTime.parse("00:10:00");
		usuario.setDataValidade(data);
		usuario.setNomeInsumo("Paracetamol");
		usuario.setDescricao("faz coisas boas pro corpo");
		usuarioDAO.inserirInsumo(usuario);
		
		List<Insumo> usuarios = usuarioDAO.recuperarInsumo();
		for (Insumo usuario1 : usuarios) {
			System.out.println(usuario1);
		}
		
	}
}
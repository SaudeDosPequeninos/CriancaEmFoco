package br.senac.criancaemfoco.modelo.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {
		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.endereco.Endereco.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola.Escola.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.estoque.Estoque.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.insumo.Insumo.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.pessoa.Pessoa.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.responsavel.Responsavel.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.turma.Turma.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.contato.Contato.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.papel.Papel.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario.class);
		configuracao.addAnnotatedClass(br.senac.criancaemfoco.modelo.entidade.foto.Foto.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}

}
package br.com.acme.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.utils.JPAUtil;

public class ContatoDaoImpl implements ContatoDao {

	public void salvar(Contato contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(contato);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<Contato> listarContatos() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Query consulta = entityManager.createQuery("SELECT c FROM Contato c");
		List<Contato> listaDeContatosDoBancoDeDados = consulta.getResultList();
		return listaDeContatosDoBancoDeDados;
	}

	public void remover(Long idContato) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contato = entityManager.find(Contato.class, idContato);
		entityManager.remove(contato);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public Contato buscarPorIdContato(Long idContato) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contato = entityManager.find(Contato.class, idContato);
		entityManager.getTransaction().commit();
		entityManager.close();
		return contato;
	}

	public void editarContato(Long idContato, Contato contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contatoQueTavaNoBanco = entityManager.find(Contato.class, idContato);
		contatoQueTavaNoBanco.setAtivo(contato.isAtivo());
		contatoQueTavaNoBanco.setEmail(contato.getEmail());
		contatoQueTavaNoBanco.setTelefone(contato.getTelefone());
		contatoQueTavaNoBanco.setNome(contato.getNome());

		entityManager.merge(contatoQueTavaNoBanco);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}

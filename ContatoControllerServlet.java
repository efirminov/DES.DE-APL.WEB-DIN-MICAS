package br.com.acme.agenda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;

@WebServlet("/contatoControllerServlet")
public class ContatoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Contato contato;
	private ContatoService service;

	public ContatoControllerServlet() {
		this.contato = new Contato();
		this.service = new ContatoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.contato.setNome("Evandro Firmino");
		this.contato.setEmail("Evandro@gmail.com");
		this.contato.setTelefone("83 99999-9999");
		this.contato.setAtivo(true);
		this.service.salvar(this.contato);
		/// List<Contato> cotatos = this.service.listarContatos();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

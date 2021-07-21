package br.com.caelum.goodbuy.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.model.Produto;

public class RemocaoDeProduto {
	public static void main(String[] args) {
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		
		// carrega o produto do banco de dados
		Produto produto = new ProdutoDao(session).carrega(1L);
		new ProdutoDao(session).remove(produto);
	}
}

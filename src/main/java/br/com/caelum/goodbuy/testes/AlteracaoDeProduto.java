package br.com.caelum.goodbuy.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.model.Produto;

public class AlteracaoDeProduto {
	public static void main(String[] args) {
		
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		
		//carrega produto do banco de dados
		Produto produto = new ProdutoDao(session).carrega(2L);
		produto.setPreco(42.50);
		new ProdutoDao(session).atualiza(produto);
		
	}
}

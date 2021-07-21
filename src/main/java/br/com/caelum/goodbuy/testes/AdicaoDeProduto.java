package br.com.caelum.goodbuy.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.model.Produto;

public class AdicaoDeProduto {
	public static void main(String[] args) {
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		
		Produto produto = criaProduto();
		new ProdutoDao(session).salva(produto);
		
	}

	private static Produto criaProduto() {
		Produto produto = new Produto();
		produto.setId((long) 1);
		produto.setNome("Copo");
		produto.setDescricao("Um copo para beber agua");
		produto.setPreco(15.00);
		return produto;
	}


}

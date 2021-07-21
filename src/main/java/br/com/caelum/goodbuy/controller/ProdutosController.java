package br.com.caelum.goodbuy.controller;

import java.util.List;
import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.model.Produto;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import static br.com.caelum.vraptor.view.Results.json;

@Resource
public class ProdutosController {

	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get
	@Path("/produtos/novo")
	public void formulario() {
	}

	@Get
	@Path("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}

	@Post
	@Path("/produtos")
	public void adiciona(final Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(ProdutosController.class).formulario();
		dao.salva(produto);
		result.redirectTo(this).lista();
	}

	@Get
	@Path("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}

	@Put
	@Path("/produtos/{produto.id}")
	public void altera(Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(ProdutosController.class).edita(produto.getId());

		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}

	@Delete
	@Path("/produtos/{id}")
	public void remove(Long id) {
		Produto produto = dao.carrega(id);
		dao.remove(produto);
		result.redirectTo(this).lista();
	}

	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	@Get @Path("/produtos/busca.json")
	public void buscaJson(String q) {
		System.out.println("entrou");
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id", "descricao").serialize();
	}
}

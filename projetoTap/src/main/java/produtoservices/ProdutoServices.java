package produtoservices;

import java.util.List;

import webserviceprodutos.Produto;

public interface ProdutoServices {
	Produto salvar(Produto produto);
	Produto gePorId(int id);
	List<Produto> listarTodos();

}

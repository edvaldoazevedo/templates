package produtoservices;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import produtosrepository.ProdutoRepository;
import webserviceprodutos.Produto;

@Service
@Validated
public class ProdutoServicesImpl implements ProdutoServices {

	@Autowired
	private final ProdutoRepository repositorio;

	public ProdutoServicesImpl(final ProdutoRepository repository) {
		this.repositorio = repository;
	}

	@Transactional
	public Produto salvar(@NotNull @Valid final Produto produto) {

		Produto existente = repositorio.findById(produto.getId());
		if (existente != null) {
			System.out.println("Produto já Existe em Nosso BD");
		}

		return repositorio.save(produto);
	}

	
	public Produto gePorId(int id) {
		return repositorio.findById(id);

	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}

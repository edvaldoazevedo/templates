package produtosrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import webserviceprodutos.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
	
	public Produto findById(int id);

}

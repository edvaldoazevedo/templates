package webserviceprodutos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import produtoservices.ProdutoServices;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	private final ProdutoServices produtoServices;

	@Autowired
	public ProdutoController(final ProdutoServices produtoServices) {
		this.produtoServices = produtoServices;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listarTodos() {
		return new ResponseEntity<List<Produto>>(produtoServices.listarTodos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> criarProduto(@RequestBody Produto produto) {
		try {
			produtoServices.salvar(produto);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
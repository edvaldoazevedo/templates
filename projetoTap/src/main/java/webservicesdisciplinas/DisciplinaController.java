package webservicesdisciplinas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> todasDisciplinas() {

		disciplinas.add(new Disciplina("23333", "Algebra Linear", "Matemática", "Gilson Lucena"));
		disciplinas.add(new Disciplina("23321", "Lógica Aplicada", "Lógica Sem Lógica", "Hamurabi Medeiros"));
		disciplinas.add(new Disciplina("2221", "TAP", "Tópicos Avançados em Programaçã", "Daniel Abella"));
		return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> disciplinaPorCod(@PathVariable (value="codigo")String codigo) {
		Disciplina disc = new Disciplina("13", "Sistemas Operacionais", "Entendimento Profundo de SO",
				"Esther Brasileiro");
		
		return new ResponseEntity<Disciplina>(disc, HttpStatus.OK);

	}
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<String> criarDisciplina(@RequestBody Disciplina disciplina) {

		try {
			disciplinas.add(disciplina);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}

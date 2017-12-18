package infnet.sisam.service;

import static infnet.sisam.helper.Constantes.PATH_TURMAS;
import static infnet.sisam.helper.Constantes.URI_REST_INFNET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import infnet.sisam.dao.TurmaDao;
import infnet.sisam.model.Turma;

@Service
@Transactional
public class TurmaService {

	@Autowired
	private TurmaDao turmaDao;
	@Autowired
	private RestTemplate restTemplate;

	public void salvar(Turma turma) {
		turmaDao.salvar(turma);
	}

	@SuppressWarnings("unchecked")
	public List<Turma> listar() {
//		return restTemplate.getForObject(URI_REST_INFNET.concat(PATH_TURMAS), List.class);
		return restTemplate.getForObject("http://www.mocky.io/v2/5a372d332f00000b23127b46", List.class);
	}

	public void atualizar(Turma turma) {

		turmaDao.atualizar(turma);
	}

	public Turma buscar(Integer id) {
		return turmaDao.buscar(id);
	}

	public void remover(Integer id) {
		turmaDao.excluir(turmaDao.buscar(id));
	}

}

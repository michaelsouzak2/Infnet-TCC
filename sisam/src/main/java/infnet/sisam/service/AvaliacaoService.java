package infnet.sisam.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.AvaliacaoDao;
import infnet.sisam.dto.HashAvaliacaoRespostaDTO;
import infnet.sisam.helper.HashHelper;
import infnet.sisam.model.Aluno;
import infnet.sisam.model.AlunoAvaliacao;
import infnet.sisam.model.Avaliacao;

@Service
@Transactional
public class AvaliacaoService {

	@Autowired
	private AvaliacaoDao avaliacaoDao;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AlunoAvaliacaoService alunoAvaliacaoService;

	@Autowired
	private HashHelper helper;

	public List<Avaliacao> listar() {
		return avaliacaoDao.findAll();
	}

	public void salvar(Avaliacao avaliacao) {

		avaliacaoDao.salvar(avaliacao);

		avaliacao.getTurmas().forEach(turma -> {
			turma = turmaService.buscar(turma.getId());// obtém turma com alunos
			turma.setAvaliacao(avaliacao);
			turmaService.salvar(turma);

			List<Aluno> alunos = turma.getAlunos();
			for (Aluno aluno : alunos) {
				aluno.setTurma(turma);
				alunoService.getAlunoDao().salvar(aluno);
			}
		});

	}

	public Avaliacao buscar(Integer id) {
		return avaliacaoDao.buscar(id);
	}

	public void atualizar(Avaliacao avaliacao) {
		avaliacaoDao.atualizar(avaliacao);
	}

	public void remover(Integer id) {
		avaliacaoDao.excluir(avaliacaoDao.buscar(id));
	}

	public AlunoAvaliacao verificaAcessoAvaliacaoAluno(String hashAvaliacaoId) {
		HashAvaliacaoRespostaDTO dto = helper.decodificaBase64(hashAvaliacaoId);
		Aluno aluno = alunoService.buscar(dto.getAlunoId());
		Avaliacao avaliacao = buscar(dto.getAvaliacaoId());
		AlunoAvaliacao alunoAvaliacao = new AlunoAvaliacao();
		if (verificaAcessoAluno(aluno, avaliacao, alunoAvaliacao)) {
			alunoAvaliacao = verificaAvaliacaoRespondida(aluno, avaliacao);
		}
		return alunoAvaliacao;
	}

	@SuppressWarnings("unchecked")
	private boolean verificaAcessoAluno(Aluno aluno, Avaliacao avaliacao, AlunoAvaliacao alunoAvaliacao) {
		List<Aluno> alunoPermitido = alunoService.getAlunoDao().getEm()
				.createNamedQuery("Aluno.verificaAcessoAvaliacao").setParameter("idAluno", aluno.getId())
				.getResultList();
		if (alunoPermitido.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private AlunoAvaliacao verificaAvaliacaoRespondida(Aluno aluno, Avaliacao avaliacao) {
		AlunoAvaliacao alunoAvaliacao = obterAlunoAvaliacao(aluno.getId(), avaliacao.getId());
		if (alunoAvaliacao != null) {
			return alunoAvaliacao;
		} else {
			alunoAvaliacao = new AlunoAvaliacao();
			alunoAvaliacao.setAluno(aluno);
			alunoAvaliacao.setAvaliacao(avaliacao);
			alunoAvaliacao.setAvaliacaoRespondida(false);
			alunoAvaliacaoService.salvar(alunoAvaliacao);
			return alunoAvaliacao;
		}
	}

	private AlunoAvaliacao obterAlunoAvaliacao(Integer idAluno, Integer idAvaliacao) {
		try {
			AlunoAvaliacao alunoAvaliacao = (AlunoAvaliacao) alunoAvaliacaoService.getAlunoAvaliacaoDao().getEm()
					.createNamedQuery("AlunoAvaliacao.buscaAlunoAvaliacao").setParameter("idAluno", idAluno)
					.setParameter("idAvaliacao", idAvaliacao).getSingleResult();
			return alunoAvaliacao;
		} catch (NoResultException nre) {
			return null;
		}
	}
}

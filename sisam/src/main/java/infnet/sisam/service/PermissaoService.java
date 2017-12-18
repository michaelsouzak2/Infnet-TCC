package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.PermissaoDao;
import infnet.sisam.model.Permissao;

@Service
@Transactional
public class PermissaoService {

	@Autowired
	private PermissaoDao permissaoDao;
	
	public void salvar(Permissao permissao) {
		permissaoDao.salvar(permissao);
	}
	
	public List<Permissao> listar() {
		return permissaoDao.findAll();
	}

	public Permissao buscar(Integer id) {
		return permissaoDao.buscar(id);
	}


}

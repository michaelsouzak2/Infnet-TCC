package infnet.sisam.dao;

public interface Dao<T> {

	void salvar(T entity);

	void atualizar(T entity);

	T buscar(Integer id);

	void excluir(T entity);

}

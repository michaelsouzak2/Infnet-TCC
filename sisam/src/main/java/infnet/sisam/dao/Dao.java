package infnet.sisam.dao;

public interface Dao<T> {

	void salvar(T entity);

	void atualizar(T entity);

	T buscar(T entity);
	
	void excluir(T entity);

}

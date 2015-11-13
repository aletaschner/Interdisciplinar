package DAO;

import java.sql.SQLException;
import java.util.List;

public interface IAbstractDao<E> {
	
	//selecionar
	//inserir
	//alterar
	//excluir
	
	List<E> getListar() throws SQLException;
	void setInserir(E objeto) throws SQLException;
	void setAlterar(E objeto) throws SQLException;
	void setExcluir(E objeto) throws SQLException;
	E getDetalhe(int codigo) throws SQLException;

}

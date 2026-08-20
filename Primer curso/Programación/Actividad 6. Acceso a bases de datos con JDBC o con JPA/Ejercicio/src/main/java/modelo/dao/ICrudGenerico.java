package modelo.dao;

import java.util.List;

public interface ICrudGenerico <E,ID> {
	E  findById(ID atributoPk);
	int insert(E refEntidad);
	int update(E atributoPK);
	int deletebyId(ID atributoPk);
	List<E> findAll();

}

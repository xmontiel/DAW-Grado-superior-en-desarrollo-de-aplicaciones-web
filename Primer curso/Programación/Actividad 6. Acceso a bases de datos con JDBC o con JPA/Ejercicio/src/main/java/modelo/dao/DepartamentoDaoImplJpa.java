package modelo.dao;

import java.util.List;

import modelo.entities.Departamento;

public class DepartamentoDaoImplJpa extends AbsConexionJpa implements DepartamentoDao{

	@Override
	public Departamento findById(Integer idDepar) {
		return em.find(Departamento.class, idDepar);
	}

	@Override
	public int insert(Departamento departamento) {
		filas = 0;
		try {
		tx.begin();
			em.persist(departamento);
		tx.commit();
		filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int update(Departamento departamento) {
		filas = 0;
	    try {
	    tx.begin();
	        	em.merge(departamento);
	    tx.commit();
	    filas = 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        filas = 0;
	    }
	    return filas;
	}

	@Override
	public int deletebyId(Integer idDepar) {
		filas = 0;
		Departamento departamento = null;
		try {
		departamento = findById(idDepar);
		if(departamento != null){
			tx.begin();
			em.remove(departamento);
			tx.commit();
			filas = 1;}
		else {
			filas = 0;}
		}catch(Exception e) {
			System.err.println("Error en eliminar Departamento");
			filas = -1;
		}
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findAll() {
		jpql = "from Departamento d";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}

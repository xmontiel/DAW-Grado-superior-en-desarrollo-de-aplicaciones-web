package modelo.dao;

import java.util.List;

import modelo.entities.Perfil;

public class PerfilDaoImplJpa extends AbsConexionJpa implements PerfilDao{

	@Override
	public Perfil findById(Integer idPerfil) {
		return em.find(Perfil.class, idPerfil);
	}

	@Override
	public int insert(Perfil perfil) {
		filas = 0;
		try {
		tx.begin();
			em.persist(perfil);
		tx.commit();
		filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int update(Perfil perfil) {
		filas = 0;
	    try {
	    tx.begin();
	        	em.merge(perfil);
	    tx.commit();
	    filas = 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        filas = 0;
	    }
	    return filas;
	}

	@Override
	public int deletebyId(Integer idPerfil) {
		filas = 0;
		Perfil perfil = null;
		try {
		perfil = findById(idPerfil);
		if(perfil != null){
			tx.begin();
			em.remove(perfil);
			tx.commit();
			filas = 1;}
		else {
			filas = 0;}
		}catch(Exception e) {
			System.err.println("Error en eliminar Perfil");
			filas = -1;
		}
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> findAll() {
		jpql = "from Perfil p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}

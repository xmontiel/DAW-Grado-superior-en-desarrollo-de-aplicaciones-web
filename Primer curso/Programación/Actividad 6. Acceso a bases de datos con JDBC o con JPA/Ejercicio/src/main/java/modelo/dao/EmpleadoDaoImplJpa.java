package modelo.dao;

import java.util.List;

import jakarta.persistence.Query;
import modelo.entities.Empleado;

public class EmpleadoDaoImplJpa extends AbsConexionJpa implements EmpleadoDao {

	@Override
	public Empleado findById(Integer idEmpl) {
		return em.find(Empleado.class, idEmpl);
	}

	@Override
	public int insert(Empleado empleado) {
		filas = 0;
		try {
		tx.begin();
			em.persist(empleado);
		tx.commit();
		filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int update(Empleado empleado) {
		filas = 0;
	    try {
	    tx.begin();
	        	em.merge(empleado);
	    tx.commit();
	    filas = 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        filas = 0;
	    }
	    return filas;
	}

	@Override
	public int deletebyId(Integer idEmpl) {
		filas = 0;
		Empleado empleado = null;
		try {
		empleado = findById(idEmpl);
		if(empleado != null){
			tx.begin();
			em.remove(empleado);
			tx.commit();
			filas = 1;}
		else {
			filas = 0;}
		}catch(Exception e) {
			System.err.println("Error en eliminar Empleado");
			filas = -1;
		}
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findAll() {
		jpql = "from Empleado e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		jpql = "from Empleado e where e.departamento.idDepar = :dep";
		query = em.createQuery(jpql);
		query.setParameter("dep",idDepar);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByGenero(String sexo) {
		jpql = "from Empleado e where e.genero = :gen";
		query = em.createQuery(jpql);
		query.setParameter("gen",sexo);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql = "from Empleado e where e.apellidos = :ape";
		query = em.createQuery(jpql);
		query.setParameter("ape",subcadena);
		return query.getResultList();
	}

	@Override
	public double salarioTotal() {
		jpql = "select sum(e.salario) from Empleado e";
		query = em.createQuery(jpql);
		return (double)query.getSingleResult();
	}

	@Override
	public double salarioTotal(int idDepar) {
		jpql = "select sum(e.salario) from Empleado e where e.departamento.idDepar = :dep";
		query = em.createQuery(jpql);
		query.setParameter("dep",idDepar);
		return (double)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByIdPerfil(int idPerfil) {
		jpql = "from Empleado e where e.perfil.idPerfil = :per";
		query = em.createQuery(jpql);
		query.setParameter("per",idPerfil);
		return query.getResultList();
	}

}

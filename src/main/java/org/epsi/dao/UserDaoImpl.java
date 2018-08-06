package org.epsi.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.epsi.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> getUsers() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		final Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		final TypedQuery<User> lTypedQuery = entityManager.createQuery(criteriaQuery);

		return lTypedQuery.getResultList();
	}
	
	public Optional<User> findUserByUserName(String userName)
	{
		Optional<User> res = Optional.empty();
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		final Root<User> user = criteriaQuery.from(User.class);
		criteriaQuery.where(criteriaBuilder.equal(user.get("userName"), userName));
		final TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		List<User> users = typedQuery.getResultList();
		if(!users.isEmpty())
		{
			res = Optional.of(users.get(0));
		}
		return res;
	}


}

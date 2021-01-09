package com.example.webday7.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday7.entity.Book;
import com.example.webday7.repository.BookRepository;

@Repository
public class BookRepositoryHibernate implements BookRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public BookRepositoryHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Book> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
		Root<Book> root = criteriaQuery.from(Book.class);
		criteriaQuery.select(root);
		Query<Book> query = session.createQuery(criteriaQuery);
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public Book findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Book.class, id);
	}

	@Override
	public void insert(Book b) {
		Session session = sessionFactory.getCurrentSession();
		session.save(b);
	}

	@Override
	public void update(Book b) {
		Session session = sessionFactory.getCurrentSession();
		session.update(b);
	}

	@Override
	public void delete(Book b) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(b);
	}

}

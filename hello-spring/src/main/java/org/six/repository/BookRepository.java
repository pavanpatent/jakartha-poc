package org.six.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.six.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAll() {
        CriteriaQuery<Book> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Book.class);
        criteriaQuery.from(Book.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void save(Book book) {
//        if (book.getId() == null) {
//            entityManager.persist(book);
//        } else {
            entityManager.persist(book);
//        }
    }

    public void deleteById(Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }
}

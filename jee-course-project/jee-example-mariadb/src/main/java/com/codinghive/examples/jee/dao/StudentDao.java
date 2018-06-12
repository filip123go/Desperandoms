package com.codinghive.examples.jee.dao;

import com.codinghive.examples.jee.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name="StudentDAO")
public class StudentDao implements StudentDaoLocal {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDao.class);

    protected static final String STUDENT_PU = "mariaDB-eclipselink";

    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;

    public void addStudent(Student student) {
    	em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        LOGGER.info("Created Student:" + student);
    }

    public void editStudent(Student student) {
        em.merge(student);
    }

    public void deleteStudent(int studentId) {
        em.remove(getStudent(studentId));
    }

    public Student getStudent(int studentId) {
        return em.find(Student.class, studentId);
    }

    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.getAll").getResultList();
    }

}

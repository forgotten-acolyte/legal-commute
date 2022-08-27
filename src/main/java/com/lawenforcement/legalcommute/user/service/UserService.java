package com.lawenforcement.legalcommute.user.service;

import com.lawenforcement.legalcommute.user.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    public List getUserDetails() {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(User.class);

        return criteria.list();
    }
}

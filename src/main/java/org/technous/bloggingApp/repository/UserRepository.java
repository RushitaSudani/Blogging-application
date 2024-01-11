package org.technous.bloggingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technous.bloggingApp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}

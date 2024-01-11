package org.technous.bloggingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technous.bloggingApp.models.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,Integer> {

}

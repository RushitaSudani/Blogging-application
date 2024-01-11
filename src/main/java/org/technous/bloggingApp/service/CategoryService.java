package org.technous.bloggingApp.service;

import org.technous.bloggingApp.dto.CategotyDTO;
import org.technous.bloggingApp.models.Categories;

import java.util.List;

public interface CategoryService {
    public CategotyDTO craeteCategories(CategotyDTO categotyDTO);
    public CategotyDTO updateCategory(CategotyDTO categotyDTO,int id);
    public void deleteCategory(int cid);
    public CategotyDTO getById(int id);
    public List<CategotyDTO> getall();


}

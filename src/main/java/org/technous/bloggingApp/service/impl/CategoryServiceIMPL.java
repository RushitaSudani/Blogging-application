package org.technous.bloggingApp.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technous.bloggingApp.dto.CategotyDTO;
import org.technous.bloggingApp.exception.ResourceNotFoundException;
import org.technous.bloggingApp.models.Categories;
import org.technous.bloggingApp.repository.CategoryRepository;
import org.technous.bloggingApp.service.CategoryService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceIMPL implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    public CategotyDTO categoriestoDto(Categories categories) {
        CategotyDTO c1=this.modelMapper.map(categories, CategotyDTO.class);
        return c1;
    }
    public Categories dtotoCategory(CategotyDTO categotyDTO){
        Categories c1=this.modelMapper.map(categotyDTO,Categories.class);
        return c1;
    }
    @Override
    public CategotyDTO craeteCategories(CategotyDTO categotyDTO) {
        Categories c1=dtotoCategory(categotyDTO);
        Categories save=categoryRepository.save(c1);
        return categoriestoDto(save);
    }
    @Override
    public CategotyDTO updateCategory(CategotyDTO categotyDTO, int cid) {
       Categories c1=categoryRepository.findById(cid)
               .orElseThrow(()-> new ResourceNotFoundException("categoryid","categoryid",cid));
       c1.setCategorytitle(categotyDTO.getCategorytitle());
       c1.setCategorydescription(categotyDTO.getCategorydescription());
       Categories save=categoryRepository.save(c1);
       return categoriestoDto(save);
    }
    @Override
    public void deleteCategory(int cid) {
        Categories c1=categoryRepository.findById(cid).orElseThrow(()->new ResourceNotFoundException("categories not found","categoryid",cid));
        this.categoryRepository.delete(c1);
    }
    @Override
    public CategotyDTO getById(int cid) {
        Categories c1=categoryRepository.findById(cid).orElseThrow(()->new ResourceNotFoundException("Categoies not found","categoryid",cid));
        return categoriestoDto(c1);
    }
    @Override
    public List<CategotyDTO> getall() {
        List<Categories> c1=categoryRepository.findAll();
        List<CategotyDTO> categotyDTOS=c1.stream().map(categories->this.categoriestoDto(categories)).collect(Collectors.toList());
        return categotyDTOS;
    }
}

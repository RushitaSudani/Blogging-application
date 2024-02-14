package org.technous.bloggingApp.controller;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technous.bloggingApp.dto.CategotyDTO;
import org.technous.bloggingApp.service.CategoryService;
import org.technous.bloggingApp.util.ApiResponse;
import java.util.List;

@RestController
@RequestMapping("api/category")
@CrossOrigin("http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("createcategory")
    public ResponseEntity<CategotyDTO> createCategory(@Valid @RequestBody CategotyDTO categotyDTO)
    {
            CategotyDTO c1=categoryService.craeteCategories(categotyDTO);
            return new ResponseEntity<CategotyDTO>(c1, HttpStatus.CREATED);
    }
    @PutMapping("updatecategory/{cid}")
    public ResponseEntity<CategotyDTO> updateCategory(@Valid @RequestBody CategotyDTO categotyDTO,@PathVariable("cid") int cid)
    {
        CategotyDTO c1=categoryService.updateCategory(categotyDTO,cid);
        return new ResponseEntity<>(c1,HttpStatus.OK);
    }
    @GetMapping("getallcategory")
    public List<CategotyDTO> getAll(){
        List<CategotyDTO> c1=categoryService.getall();
        return c1;
    }
    @GetMapping("getbyid/{cid}")
    public ResponseEntity<CategotyDTO> getById(@PathVariable("cid") int cid) {
        CategotyDTO c1=categoryService.getById(cid);
        return new ResponseEntity<CategotyDTO>(c1,HttpStatus.OK);
    }
    @DeleteMapping("deletedbyid/{cid}")
    public ApiResponse deleteCategory(@PathVariable("cid") int cid) {
        categoryService.deleteCategory(cid);
        return new ApiResponse("Category deleted", true);
    }

}

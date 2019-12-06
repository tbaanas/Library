package pl.sda.service;

import pl.sda.entities.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private CategoryRepository categoryRepository=new CategoryRepository();

    public List<Category> show(){

        return  categoryRepository.show();
    }

    public void save(Category category){
        categoryRepository.save(category);
    }

}

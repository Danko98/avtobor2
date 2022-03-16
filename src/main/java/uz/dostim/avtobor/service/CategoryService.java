package uz.dostim.avtobor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.dto.CategoryDto;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.entity.Category;
import uz.dostim.avtobor.entity.ProfileEntity;
import uz.dostim.avtobor.repository.BrandRepository;
import uz.dostim.avtobor.repository.CarRepository;
import uz.dostim.avtobor.repository.CategoryRepository;
import uz.dostim.avtobor.repository.ProfileRepository;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ProfileRepository profileRepository;

    public ApiResponse addCategory(CategoryDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto.getName())) {
            return new ApiResponse("This already exists name",false);
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new ApiResponse("Successfully saved",true);
    }

    public ApiResponse editCategory(CategoryDto categoryDto, Long id) {

        if (categoryRepository.existsByName(categoryDto.getName())) {
            return new ApiResponse("This already exists category name",false);
        }
        if (!categoryRepository.existsById(id)) {
            return new ApiResponse("Not fount category",false);
        }
        if (categoryRepository.existsByName(categoryDto.getName())) {
            return new ApiResponse("This already exists name",false);
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new ApiResponse("Successfully edited",true);
    }

}

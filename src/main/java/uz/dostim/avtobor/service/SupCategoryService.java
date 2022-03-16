package uz.dostim.avtobor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.dto.SupCategoryDto;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.entity.ProfileEntity;
import uz.dostim.avtobor.entity.SupCategory;
import uz.dostim.avtobor.repository.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SupCategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SupCategoryRepository supCategoryRepository;


   public ApiResponse addSupCategory(SupCategoryDto supCategoryDto) {
       if (supCategoryRepository.existsByName(supCategoryDto.getName())) {
           return new ApiResponse("This already exists",false);
       }
       SupCategory supCategory = new SupCategory();
       supCategory.setName(supCategoryDto.getName());
       supCategoryRepository.save(supCategory);
       return new ApiResponse("Successfully saved",true);
   }

   public ApiResponse editSupCategory(SupCategoryDto supCategoryDto, Long id) {
       if (!supCategoryRepository.existsById(id)) {
           return new ApiResponse("Not found category");
       }
       if (supCategoryRepository.existsByName(supCategoryDto.getName())) {
           return new ApiResponse("This already exists",false);
       }
       SupCategory supCategory = new SupCategory();
       supCategory.setName(supCategoryDto.getName());
       supCategoryRepository.save(supCategory);
       return new ApiResponse("Successfully saved",true);
   }

   public ApiResponse getSupCategoryById(Long id) {
       if (!supCategoryRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }

       Optional<SupCategory> optionalSupCategory = supCategoryRepository.findById(id);
       return new ApiResponse(optionalSupCategory.get());
   }

   public List<SupCategory> getSupCategoryList() {
       return supCategoryRepository.findAll();
   }

   public ApiResponse deleteSupCategoryById(Long id) {
       if (!supCategoryRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }
       supCategoryRepository.deleteById(id);
       return new ApiResponse("Successfully deleted",true);
   }
}

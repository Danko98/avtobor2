package uz.dostim.avtobor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.BrandDto;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.repository.BrandRepository;
import uz.dostim.avtobor.repository.CarRepository;
import uz.dostim.avtobor.repository.ModelRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

   @Autowired
   private BrandRepository brandRepository;

   @Autowired
   private ModelRepository modelRepository;

   public ApiResponse addBrand(BrandDto brandDto) {
       if (!modelRepository.existsById(brandDto.getModelId())) {
           return new ApiResponse("Not found model",false);
       }

       Brand brand = new Brand();
       brand.setName(brandDto.getName());

       brandRepository.save(brand);
       return new ApiResponse("Successfully saved",true);
   }

    public ApiResponse editBrand(BrandDto brandDto, Long id) {

       if (!brandRepository.existsById(id)) {
           return new ApiResponse("Not found brand",false);
       }

        if (!modelRepository.existsById(brandDto.getModelId())) {
            return new ApiResponse("Not found model",false);
        }

        Optional<Brand> optionalBrand = brandRepository.findById(id);
        Brand brand = optionalBrand.get();
        brand.setName(brandDto.getName());

        brandRepository.save(brand);
        return new ApiResponse("Successfully edited",true);
    }

    public ApiResponse getBrandById(Long id) {

       if (!brandRepository.existsById(id)) {
           return new ApiResponse("Not found brand",false);
       }

        Optional<Brand> optionalBrand = brandRepository.findById(id);
       if (!optionalBrand.isPresent()) {
           return new ApiResponse("Not found",false);
       }

        Brand brand = optionalBrand.get();
        brand.setModelList(modelRepository.findAllByBrand_Id(brand.getId()));
        return new ApiResponse(brand);
    }

    public List<Brand> getBrandList() {
       return brandRepository.findAll();
    }

    public ApiResponse deleteById(Long id) {
        if (!brandRepository.existsById(id)) {
            return new ApiResponse("Not found brand",false);
        }
        try {
            brandRepository.deleteById(id);
            return new ApiResponse("Successfully deleted",true);
        }catch (Exception e){
            return new ApiResponse("Not deleted",false);
        }
    }



}

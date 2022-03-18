package uz.dostim.avtobor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.RegionDto;
import uz.dostim.avtobor.entity.City;
import uz.dostim.avtobor.entity.Region;
import uz.dostim.avtobor.repository.CityRepository;
import uz.dostim.avtobor.repository.RegionRepository;

import java.util.List;
import java.util.Optional;


@Service
public class RegionService {

   @Autowired
    private RegionRepository regionRepository;

   @Autowired
    private CityRepository cityRepository;


   public ApiResponse addRegion(RegionDto regionDto) {
       if (regionRepository.existsByName(regionDto.getName())) {
           return new ApiResponse("This region name alredy exists",false);
       }
       Region region = new Region();
       region.setName(regionDto.getName());
       regionRepository.save(region);
       return new ApiResponse("Successfully saved",true);

   }

   public ApiResponse editRegion(RegionDto regionDto, Long id) {
       if (!regionRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }
       if (regionRepository.existsByName(regionDto.getName())) {
           return new ApiResponse("This region name already exists",false);
       }
       Region region = new Region();
       region.setName(regionDto.getName());
       regionRepository.save(region);
       return new ApiResponse("Successfully edit",true);

   }

   public ApiResponse getRegionById(Long id) {
       if (!regionRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }
       Optional<Region> optionalRegion = regionRepository.findById(id);
       if (optionalRegion.isPresent()) {
           Region region = optionalRegion.get();
           List<City> cityList = cityRepository.findAllByRegion_Id(id);
           region.setCityList(cityList);
           return new ApiResponse(region);
       }else
           return new ApiResponse("Not found in database",false);
   }

   public List<Region> getRegionList() {
       return regionRepository.findAll();
   }

   public ApiResponse deleteById(Long id) {
       if (!regionRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }

       regionRepository.deleteById(id);
       return new ApiResponse("Seccessfully delted",true);
   }


}

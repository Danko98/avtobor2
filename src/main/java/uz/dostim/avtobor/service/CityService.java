package uz.dostim.avtobor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CityDto;
import uz.dostim.avtobor.entity.City;
import uz.dostim.avtobor.repository.CityRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class CityService {

   @Autowired
    CityRepository cityRepository;

   public ApiResponse addCity(CityDto cityDto) {
       if (cityRepository.existsByName(cityDto.getName())) {
           return new ApiResponse("This city name already exists",false);
       }

       City city = new City();
       city.setName(cityDto.getName());
       cityRepository.save(city);
       return new ApiResponse("Successfully saved",true);
   }

   public ApiResponse editCity(CityDto cityDto, Long id) {
       if (!cityRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }

       if (cityRepository.existsByName(cityDto.getName())) {
           return new ApiResponse("This city name already exists",false);
       }
       Optional<City> optionalCity = cityRepository.findById(id);

       City city = optionalCity.get();
       city.setName(cityDto.getName());
       cityRepository.save(city);

       return new ApiResponse("Successfully edited",true);

   }

   public ApiResponse getCityBy(Long id) {
       if (!cityRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }
       Optional<City> optionalCity = cityRepository.findById(id);
       return new ApiResponse(optionalCity.get());
   }

   public List<City> getCityList() {
       return cityRepository.findAll();
   }

   public ApiResponse deleteCityById(Long id) {
       if (!cityRepository.existsById(id)) {
           return new ApiResponse("Not found",false);
       }
       cityRepository.deleteById(id);
       return new ApiResponse("Successfully deleted",true);
   }
}

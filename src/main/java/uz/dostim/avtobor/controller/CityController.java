package uz.dostim.avtobor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.dto.CityDto;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.entity.City;
import uz.dostim.avtobor.service.CarService;
import uz.dostim.avtobor.service.CityService;

import java.util.List;


@RestController
@RequestMapping("city/")
@Api(tags = "City Control", value = "Bu Controllerni faqat ADMIN aka ishlata oladi")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping
    @ApiOperation(value = "Create a New City", notes = "Create a New City for User")
    public ResponseEntity<?> addCity(@RequestBody CityDto cityDto){
        ApiResponse apiResponse = cityService.addCity(cityDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edited a New City", notes = "Edited a New City for User")
    public ResponseEntity<?> editCar(@RequestBody CityDto cityDto, @PathVariable Long id){
        ApiResponse apiResponse = cityService.editCity(cityDto,id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get City by id", notes = "Get City id for User")
    public ResponseEntity getById(@PathVariable Long id) {
        ApiResponse apiResponse = cityService.getCityBy(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get City list", notes = "Get City list for User")
    public ResponseEntity<List<City>> getCarPage() {
        List<City> cityList = cityService.getCityList();
        return ResponseEntity.ok(cityList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete City by id", notes = "Delete City by id for User")
    public ResponseEntity deleteById(@PathVariable Long id) {
        ApiResponse apiResponse = cityService.deleteCityById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}

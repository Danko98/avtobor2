package uz.dostim.avtobor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.service.CarService;


@RestController
@RequestMapping("car/")
@Api(tags = "Profile Control", value = "Bu Controllerni faqat ADMIN aka ishlata oladi")
public class CityController {

    @Autowired
    CarService carService;

    @PostMapping
    @ApiOperation(value = "Create a New Car", notes = "Create a New Car for User")
    public ResponseEntity<?> addCar(@RequestBody CarDto carDto){
        ApiResponse apiResponse = carService.addCar(carDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edited a New Car", notes = "Edited a New Car for User")
    public ResponseEntity<?> editCar(@RequestBody CarDto carDto, @PathVariable Long id){
        ApiResponse apiResponse = carService.editCar(carDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get car by id", notes = "Get car by id for User")
    public ResponseEntity getById(@PathVariable Long id) {
        ApiResponse apiResponse = carService.getById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get car page", notes = "Get car page for User")
    public ResponseEntity<Page<Car>> getCarPage(@RequestParam int page) {
        Page<Car> carPage = carService.getCarList(page);
        return ResponseEntity.ok(carPage);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete car by id", notes = "Delete car by id for User")
    public ResponseEntity deleteById(@PathVariable Long id) {
        ApiResponse apiResponse = carService.deleteCarById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}

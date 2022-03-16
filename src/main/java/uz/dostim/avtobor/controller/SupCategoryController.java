package uz.dostim.avtobor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.dto.SupCategoryDto;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.entity.SupCategory;
import uz.dostim.avtobor.service.CarService;
import uz.dostim.avtobor.service.SupCategoryService;

import java.util.List;


@RestController
@RequestMapping("car/")
@Api(tags = "Super Category Control", value = "Bu Controllerni faqat ADMIN aka ishlata oladi")
public class SupCategoryController {

    @Autowired
    SupCategoryService supCategoryService;

    @PostMapping
    @ApiOperation(value = "Create a New super category", notes = "Create a New super category for User")
    public ResponseEntity<?> addSupCategory(@RequestBody SupCategoryDto supCategoryDto){
        ApiResponse apiResponse = supCategoryService.addSupCategory(supCategoryDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edited a New super category", notes = "Edited a New super category for User")
    public ResponseEntity<?> editCar(@RequestBody SupCategoryDto supCategoryDto, @PathVariable Long id){
        ApiResponse apiResponse = supCategoryService.editSupCategory(supCategoryDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get super category by id", notes = "Get super category by id for User")
    public ResponseEntity getById(@PathVariable Long id) {
        ApiResponse apiResponse = supCategoryService.getSupCategoryById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get car page", notes = "Get car page for User")
    public ResponseEntity<List<SupCategory>> getCarPage() {
        List<SupCategory> supCategoryList = supCategoryService.getSupCategoryList();
        return ResponseEntity.ok(supCategoryList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete super category by id", notes = "Delete super category by id for User")
    public ResponseEntity deleteById(@PathVariable Long id) {
        ApiResponse apiResponse = supCategoryService.deleteSupCategoryById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}

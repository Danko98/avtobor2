package uz.dostim.avtobor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.BrandDto;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.service.BrandService;
import uz.dostim.avtobor.service.CarService;

import java.util.List;


@RestController
@RequestMapping("brand/")
@Api(tags = "Brand Control", value = "Bu Controllerni faqat ADMIN aka ishlata oladi")
public class BrandController {

    @Autowired
    BrandService brandService;

    @PostMapping
    @ApiOperation(value = "Create a New Brand", notes = "Create a New Brand for User")
    public ResponseEntity<?> addBrand(@RequestBody BrandDto brandDto){
        ApiResponse apiResponse = brandService.addBrand(brandDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edited a New Brand", notes = "Edited a New Brand for User")
    public ResponseEntity<?> editBrand(@RequestBody BrandDto brandDto, @PathVariable Long id){
        ApiResponse apiResponse = brandService.editBrand(brandDto,id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Brand by id", notes = "Get Brand by id for User")
    public ResponseEntity getBrandById(@PathVariable Long id) {
        ApiResponse apiResponse = brandService.getBrandById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get Brand list", notes = "Get Brand list for User")
    public ResponseEntity<List<Brand>> getBrandPage() {
        List<Brand> brandList = brandService.getBrandList();
        return ResponseEntity.ok(brandList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Brand by id", notes = "Delete Brand by id for User")
    public ResponseEntity deleteBrandById(@PathVariable Long id) {
        ApiResponse apiResponse = brandService.deleteById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}

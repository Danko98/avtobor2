package uz.dostim.avtobor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CategoryDto;
import uz.dostim.avtobor.entity.Category;
import uz.dostim.avtobor.service.CategoryService;

import java.util.List;


@RestController
@RequestMapping("category/")
@Api(tags = "Category Control", value = "Bu Controllerni faqat ADMIN aka ishlata oladi")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    @ApiOperation(value = "Create a New category", notes = "Create a New category for User")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        ApiResponse apiResponse = categoryService.addCategory(categoryDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edited a New category", notes = "Edited a New category for User")
    public ResponseEntity<?> editCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long id){
        ApiResponse apiResponse = categoryService.editCategory(categoryDto,id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get category by id", notes = "Get category by id for User")
    public ResponseEntity getCategoryById(@PathVariable Long id) {
        ApiResponse apiResponse = categoryService.getCategoryById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get category list", notes = "Get category for User")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = categoryService.getCategoryList();
        return ResponseEntity.ok(categoryList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete category by id", notes = "Delete category by id for User")
    public ResponseEntity deleteCategoryById(@PathVariable Long id) {
        ApiResponse apiResponse = categoryService.deleteCategoryById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}

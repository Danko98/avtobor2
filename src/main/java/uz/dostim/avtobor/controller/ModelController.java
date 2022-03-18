package uz.dostim.avtobor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.dto.ModelDto;
import uz.dostim.avtobor.entity.Car;

import uz.dostim.avtobor.entity.Model;
import uz.dostim.avtobor.service.ModelService;

import java.util.List;


@RestController
@RequestMapping("model/")
@Api(tags = "Model Control", value = "Bu Controllerni faqat ADMIN aka ishlata oladi")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping
    @ApiOperation(value = "Create a model Car", notes = "Create a New model for User")
    public ResponseEntity<?> addCar(@RequestBody ModelDto modelDto){
        ApiResponse apiResponse = modelService.addModel(modelDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edited a New model", notes = "Edited a New model for User")
    public ResponseEntity<?> editCar(@RequestBody ModelDto modelDto, @PathVariable Long id){
        ApiResponse apiResponse = modelService.editModel(modelDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get model by id", notes = "Get model by id for User")
    public ResponseEntity getModelById(@PathVariable Long id) {
        ApiResponse apiResponse = modelService.getModelById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get model list", notes = "Get model list for User")
    public ResponseEntity<List<Model>> getCarPage() {
        List<Model> modelList = modelService.getModelList();
        return ResponseEntity.ok(modelList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete model by id", notes = "Delete model by id for User")
    public ResponseEntity deleteById(@PathVariable Long id) {
        ApiResponse apiResponse = modelService.deleteBYId(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}

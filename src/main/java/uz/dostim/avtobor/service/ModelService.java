package uz.dostim.avtobor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.ModelDto;

import uz.dostim.avtobor.entity.Model;
import uz.dostim.avtobor.repository.BrandRepository;
import uz.dostim.avtobor.repository.ModelRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ModelService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;


    public ApiResponse addModel(ModelDto modelDto) {
        if (modelRepository.existsByName(modelDto.getName())) {
            return new ApiResponse("This alredy exists",false);
        }

        Model model = new Model();
        model.setName(modelDto.getName());
        modelRepository.save(model);
        return new ApiResponse("Successfully saved",true);

    }

    public ApiResponse editModel(ModelDto modelDto, Long id) {
        if (!modelRepository.existsById(id)) {
            return new ApiResponse("Not found",false);
        }

        if (modelRepository.existsByName(modelDto.getName())) {
            return new ApiResponse("This alredy exists",false);
        }

        Model model = new Model();
        model.setName(modelDto.getName());
        modelRepository.save(model);
        return new ApiResponse("Successfully edited",true);

    }

    public ApiResponse getModelById(Long id) {
        if (!modelRepository.existsById(id)) {
            return new ApiResponse("Not found",false);
        }

        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isPresent()) {
            return new ApiResponse(optionalModel.get());
        }else
            return new ApiResponse("Not found",false);
    }

    public List<Model> getModelList() {
        return modelRepository.findAll();
    }

    public ApiResponse deleteBYId(Long id) {
        if (!modelRepository.existsById(id)) {
            return new ApiResponse("Not found",false);
        }
        modelRepository.deleteById(id);
        return new ApiResponse("Successfully deleted",true);
    }


}

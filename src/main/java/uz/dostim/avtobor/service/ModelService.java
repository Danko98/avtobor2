package uz.dostim.avtobor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.repository.BrandRepository;
import uz.dostim.avtobor.repository.CarRepository;

import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse addCar(CarDto carDto){

        if (!brandRepository.existsById(carDto.getBrandId())){
            return new ApiResponse("Not found brand",false);
        }

        if (!userRepository.existsById(carDto.getUserId())) {
            return new ApiResponse("Not found user",false);
        }

        Optional<Brand> optionalBrand = brandRepository.findById(carDto.getBrandId());
        Optional<User> optionalUser = userRepository.findById(carDto.getUserId());

        Car car = new Car();
        car.setAgreement(carDto.isAgreement());
        car.setAutomatic(carDto.isAutomatic());
        car.setBrand(optionalBrand.get());
        car.setUser(optionalUser.get());
        car.setColor(carDto.getColor());
        car.setDescription(carDto.getDescription());
        car.setEnergy(carDto.getEnergy());
        car.setPrice(carDto.getPrice());
        car.setVersion(carDto.getVersion());
        car.setWalking(carDto.getWalking());
        car.setYears(carDto.getYears());
        car.setCreateAt(carDto.getCreatedDate());

        carRepository.save(car);

        return new ApiResponse("Successfully saved",true);
    }

    public ApiResponse editCar(CarDto carDto, Long id){

        if (!carRepository.existsById(id)) {
            return new ApiResponse("Not found",false);
        }

        if (!brandRepository.existsById(carDto.getBrandId())){
            return new ApiResponse("Not found brand",false);
        }

        if (!userRepository.existsById(carDto.getUserId())) {
            return new ApiResponse("Not found user",false);
        }

        Optional<Brand> optionalBrand = brandRepository.findById(carDto.getBrandId());
        Optional<User> optionalUser = userRepository.findById(carDto.getUserId());
        Optional<Car> optionalCar = carRepository.findById(id);

        Car car = optionalCar.get();
        car.setAgreement(carDto.isAgreement());
        car.setAutomatic(carDto.isAutomatic());
        car.setBrand(optionalBrand.get());
        car.setUser(optionalUser.get());
        car.setColor(carDto.getColor());
        car.setDescription(carDto.getDescription());
        car.setEnergy(carDto.getEnergy());
        car.setPrice(carDto.getPrice());
        car.setVersion(carDto.getVersion());
        car.setWalking(carDto.getWalking());
        car.setYears(carDto.getYears());
        car.setCreateAt(carDto.getCreatedDate());

        carRepository.save(car);

        return new ApiResponse("Successfully edited",true);
    }

    public ApiResponse getById(Long id) {
        if (!carRepository.existsById(id)) {
            return new ApiResponse("Not found car",false);
        }
        Optional<Car> optionalCar = carRepository.findById(id);
        return new ApiResponse(optionalCar.get());
    }

    public Page<Car> getCarList(int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Car> carPage = carRepository.findAll(pageable);
        return carPage;
    }

    public ApiResponse deleteCarById(Long id) {
        if (!carRepository.existsById(id)){
            return new ApiResponse("Not found car",false);
        }
        carRepository.deleteById(id);
        return new ApiResponse("Successfully deleted", true);
    }



}

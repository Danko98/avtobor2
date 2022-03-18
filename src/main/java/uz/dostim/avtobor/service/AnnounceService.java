package uz.dostim.avtobor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.AnnounceDto;
import uz.dostim.avtobor.entity.Announce;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.repository.AnnounceRepository;
import uz.dostim.avtobor.repository.CarRepository;

import java.util.Optional;

@Service
public class AnnounceService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    AnnounceRepository announceRepository;

    public ApiResponse addAnnounce(AnnounceDto announceDto){
        if (!carRepository.existsById(announceDto.getCarId())) {
            return new ApiResponse("Not found a car",false);
        }

        Optional<Car> optionalCar = carRepository.findById(announceDto.getCarId());

        Announce announce = new Announce();
        announce.setPhoneNumber(announceDto.getPhoneNumber());
        announce.setCar(optionalCar.get());
        announceRepository.save(announce);
        return new ApiResponse("Successfully saved",true);
    }

    public ApiResponse editAnnounce(AnnounceDto announceDto, Long id){
        if (!announceRepository.existsById(id)) {
            return new ApiResponse("Not found announce",false);
        }

        if (!carRepository.existsById(announceDto.getCarId())) {
            return new ApiResponse("Not found a car",false);
        }

        Optional<Car> optionalCar = carRepository.findById(announceDto.getCarId());
        Optional<Announce> optionalAnnounce = announceRepository.findById(id);

        Announce announce = optionalAnnounce.get();
        announce.setPhoneNumber(announceDto.getPhoneNumber());
        announce.setCar(optionalCar.get());
        announceRepository.save(announce);
        return new ApiResponse("Successfully edited",true);
    }

    public ApiResponse getAnnounceById(Long id) {
        if (announceRepository.existsById(id)) {
            Optional<Announce> optionalAnnounce = announceRepository.findById(id);
            return new ApiResponse(optionalAnnounce.get());
        }else
            return new ApiResponse("Not found announce",false);
    }

    public Page<Announce> getAnnouncePage(int page) {
        Pageable pageable = PageRequest.of(page, 30);
        Page<Announce> allByActive = announceRepository.findAllByActive(true, pageable);
        return allByActive;
    }

    public ApiResponse deleteById(Long id) {
        if (announceRepository.existsById(id)) {
            announceRepository.deleteById(id);
            return new ApiResponse("Successfully deleted",true);
        }else
            return new ApiResponse("Not found");
    }


}

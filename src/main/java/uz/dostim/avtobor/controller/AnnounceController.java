package uz.dostim.avtobor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dostim.avtobor.apiResponse.ApiResponse;
import uz.dostim.avtobor.dto.AnnounceDto;
import uz.dostim.avtobor.dto.CarDto;
import uz.dostim.avtobor.entity.Announce;
import uz.dostim.avtobor.entity.Car;
import uz.dostim.avtobor.repository.AnnounceRepository;
import uz.dostim.avtobor.service.AnnounceService;
import uz.dostim.avtobor.service.CarService;


@RestController
@RequestMapping("announce/")
@Api(tags = "Announce Control", value = "Bu Controllerni faqat ADMIN aka ishlata oladi")
public class AnnounceController {

    @Autowired
    AnnounceService announceService;

    @PostMapping
    @ApiOperation(value = "Create a New announce", notes = "Create a New announce for User")
    public ResponseEntity<?> addAnnounce(@RequestBody AnnounceDto announceDto){
        ApiResponse apiResponse = announceService.addAnnounce(announceDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edited a New announce", notes = "Edited a New announce for User")
    public ResponseEntity<?> editAnnounce(@RequestBody AnnounceDto announceDto, @PathVariable Long id){
        ApiResponse apiResponse = announceService.editAnnounce(announceDto,id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get announce by id", notes = "Get announce by id for User")
    public ResponseEntity getAnnounceById(@PathVariable Long id) {
        ApiResponse apiResponse = announceService.getAnnounceById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get announce page", notes = "Get announce page for User")
    public ResponseEntity<Page<Announce>> getAnnouncePage(@RequestParam int page) {
        Page<Announce> announcePage = announceService.getAnnouncePage(page);
        return ResponseEntity.ok(announcePage);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete announce by id", notes = "Delete announce by id for User")
    public ResponseEntity deleteAnnounceById(@PathVariable Long id) {
        ApiResponse apiResponse = announceService.deleteById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}

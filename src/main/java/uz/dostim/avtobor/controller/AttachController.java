package uz.dostim.avtobor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.dostim.avtobor.entity.AttachContent;
import uz.dostim.avtobor.entity.Attachment;
import uz.dostim.avtobor.repository.AttachContentRepository;
import uz.dostim.avtobor.repository.AttachRepository;
import uz.dostim.avtobor.service.AttachService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/attachment")
public class AttachController {

    @Autowired
    AttachRepository attachRepository;

    @Autowired
    AttachContentRepository attachContentRepository;

    @Autowired
    AttachService attachService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(MultipartHttpServletRequest request) throws IOException {
        String saved = attachService.uploadFile(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/download/{id}")
    public void getFile(@PathVariable Long id, HttpServletResponse response) throws IOException {
        attachService.getFile(id, response);
    }



}

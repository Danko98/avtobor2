package uz.dostim.avtobor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.dostim.avtobor.entity.AttachContent;
import uz.dostim.avtobor.entity.Attachment;
import uz.dostim.avtobor.repository.AttachContentRepository;
import uz.dostim.avtobor.repository.AttachRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachService {

    @Autowired
    AttachRepository attachRepository;

    @Autowired
    AttachContentRepository attachContentRepository;

    public String uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            //File haqida ma'lumot ilish uchun
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();

            String contentType = file.getContentType();
            Attachment attachment = new Attachment();
            attachment.setFileOriginalName(originalFilename);
            attachment.setSize(size);
            attachment.setContentType(contentType);
            Attachment saveAttachment = attachRepository.save(attachment);

            //Fileni contentini(byte[]) Saqlaymiz
            AttachContent attachContent = new AttachContent();
            attachContent.setAsosiyContent(file.getBytes());
            attachContent.setAttachment(saveAttachment);
            attachContentRepository.save(attachContent);
            return "Fayl saqlandi. ID si: "+ saveAttachment.getId();
        }
        return "XAtolik";
    }


    public void getFile(Long id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachRepository.findById(id);
        if (optionalAttachment.isPresent()){
            Attachment attachment = optionalAttachment.get();
            Optional<AttachContent> contentOptional = attachContentRepository.findByAttachment_Id(id);
            if (contentOptional.isPresent()){
                AttachContent attachContent = contentOptional.get();
                response.setHeader("Content-Disposition","attachment; filename=\""+attachment.getFileOriginalName()+"\"");
                response.setContentType(attachment.getContentType());

                FileCopyUtils.copy(attachContent.getAsosiyContent(),response.getOutputStream());


            }
        }
    }


}

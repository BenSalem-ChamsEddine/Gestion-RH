package de.cynapsys.GestionEntretienService.controlleurs;

import java.util.ArrayList;
import java.util.List;

import de.cynapsys.GestionEntretienService.serviceImpl.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by Chams Eddine on 10/07/2017.
 */
@Controller
public class UploadController {

    @Autowired
    StorageService storageService;

    List<String> files = new ArrayList<String>();

    @RequestMapping(value = "/candidats/uploadFile", method = RequestMethod.POST)
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            storageService.store(file);
        } catch (Exception e) {
            e.getMessage();
        }
    }


}

package github.aquan.springbootupload.controller;

import github.aquan.springbootupload.storage.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.stream.Collectors;

/**
 * Aquan 2019-3-11 22:24:23
 */

@Controller
public class FileUploadController {

    private final StorageService storageService;

    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", storageService.loadAll()
                                                     .map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                                                                         .build().toString())
                                                     .collect(Collectors.toList()));
        return "uploadForm";
    }


}

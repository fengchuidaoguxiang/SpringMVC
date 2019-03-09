package com.controller;

import com.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/save")
    public ModelAndView save(Employee e, MultipartFile pic) throws IOException {
        System.out.println(e);
        String filename = pic.getOriginalFilename();
        System.out.println(filename);
        String saveDir= servletContext.getRealPath("/upload");
        System.out.println(saveDir);
        System.out.println(Paths.get(saveDir,filename));
        Files.copy(pic.getInputStream(), Paths.get(saveDir,filename));
        return null;
    }
}

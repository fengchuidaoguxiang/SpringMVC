package com.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class FileDownloadController {

    @RequestMapping("/download")
    public void download1(HttpServletRequest request, HttpServletResponse response,String filename) throws IOException {
        String dir = request.getServletContext().getRealPath("/WEB-INF/down");
        //设置响应头：下载文件
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        //设置建议保存名称
        response.setHeader("Content-Disposition","attachment;filename=" + filename);
        Files.copy(Paths.get(dir, filename), response.getOutputStream());
    }
    @Autowired
    private ServletContext servletContext;
    @RequestMapping("/download2")
    public ResponseEntity<byte[]> download2( String filename ) throws IOException {
        String dir = servletContext.getRealPath("/WEB-INF/down");
        HttpHeaders httpHeaders = new HttpHeaders();
        //设置响应头：下载文件
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //设置建议保存名称
        httpHeaders.setContentDispositionFormData("attachment",filename);
        return new ResponseEntity(FileUtils.readFileToByteArray(new File(dir, filename)),httpHeaders,
        HttpStatus.CREATED);
    }
}

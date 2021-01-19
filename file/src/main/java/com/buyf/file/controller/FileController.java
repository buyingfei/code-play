package com.buyf.file.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @Author buyingfei
 * @Create 2020-12-28 22:16:11
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping("/upload")
    public void upLoad(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("file");
        // inputstream -> BufferedInputStream
        //                        ->InputStreamReader->BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(file.getInputStream())));
        String line = bufferedReader.readLine();
        while(line != null && !line.isEmpty()){
            System.out.println(line);
            line = bufferedReader.readLine();
        }

        if(!file.isEmpty()){
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("G:\\"+file.getOriginalFilename())));
            byte[] bytes = file.getBytes();
            stream.write(bytes);
            stream.close();
        }
        System.out.println("success");
    }
}

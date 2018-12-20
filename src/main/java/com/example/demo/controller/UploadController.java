package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Massage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping()
@CrossOrigin
public class UploadController {

    private String UPLOAD_FOLDER="c://";
    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/updatefile")
    public Massage singleFileUpload(MultipartFile file) {
        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return new Massage(1200,"文件为空");
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            logger.debug("文件写入成功...");
            return new Massage(800,"文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new Massage(1100,"错误");
        }
    }
}

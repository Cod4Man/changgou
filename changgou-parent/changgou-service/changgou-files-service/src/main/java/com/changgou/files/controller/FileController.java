package com.changgou.files.controller;

import com.changgou.files.utils.FastDFSClient;
import com.changgou.files.utils.FastDFSFile;
import entity.Result;
import entity.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/3/4 21:00
 * @version: 1.0
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class FileController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public Result upload(@RequestParam("file")MultipartFile file) throws Exception {
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(), // 1.jpg
                file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename()) // 获取扩展名
        );
        String[] upload = FastDFSClient.upload(fastDFSFile);
        if (upload == null) {
            return new Result(false, StatusCode.ERROR, "文件上传失败！");
        }
        logger.error("文件上传信息", upload[0] + upload[1]);
        return new Result(true, StatusCode.OK, "文件上传成！",
                "http://192.168.1.170:8080/" + upload[0] + "/" + upload[1]);
    }
}

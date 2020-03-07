package com.exafastdfs.demofdfs.controller;

import com.exafastdfs.demofdfs.Mapper.FileInfoMapper;
import com.exafastdfs.demofdfs.bean.FileInfo;
import com.exafastdfs.demofdfs.comm.CommonFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AndroidController {

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private CommonFileUtil fileUtil;

    @Autowired
    private FileInfoMapper fileInfoMapper;


    @RequestMapping("/aduploadFileToFast")
    public String uoloadFileToFast(@RequestParam("fileName") MultipartFile file, String picdesc,
                                   String picname, String piclove, String picson) throws IOException {
        if (file.isEmpty()) {
            logger.info("文件不存在");
        }
        String path = fileUtil.uploadFile(file);
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        FileInfo fileInfo = new FileInfo();
        fileInfo.setPicaddr(path);
        fileInfo.setAddtime(now);
        fileInfo.setPicdesc(picdesc);
        fileInfo.setPicname(picname);
        fileInfo.setPiclove(piclove);
        fileInfo.setPicson(picson);
        fileInfoMapper.insertFile(fileInfo);
        System.out.println(path);
        return "success";
    }


    @RequestMapping("/audiofileup")
    public String upaudioToFast(@RequestParam("fileName") MultipartFile file, String picdesc,
                                String picname, String piclove, String picson) throws IOException {
        if (file.isEmpty()) {
            logger.info("文件不存在");
        }
        String path = fileUtil.uploadFile(file);
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FileInfo fileInfo = new FileInfo();
        fileInfo.setPicaddr(path);
        fileInfo.setAddtime(now);
        fileInfo.setPicdesc(picdesc);
        fileInfo.setPicname(picname);
        fileInfo.setPiclove(piclove);
        fileInfo.setPicson(picson);
        fileInfoMapper.insertFile(fileInfo);
        System.out.println(path);
        return "success";
    }
}

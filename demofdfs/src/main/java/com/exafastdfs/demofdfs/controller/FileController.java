package com.exafastdfs.demofdfs.controller;

import com.exafastdfs.demofdfs.Mapper.FileInfoMapper;
import com.exafastdfs.demofdfs.bean.FileInfo;
import com.exafastdfs.demofdfs.comm.CommonFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class FileController {
    private final static Logger logger = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private CommonFileUtil fileUtil;

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @RequestMapping("/goIndex")
    public String goIndex() {
        logger.info("进入主页面");
        return "/file";
    }

//    @RequestMapping("/fileUpload")
//    public String fileUpload(@RequestParam("fileName") MultipartFile file){
//        String targetFilePath = "E:/opt/uploads/";
//        if(file.isEmpty()){
//            logger.info("this file is empty");
//        }
//        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//        //获取原来文件名称
//        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        if(!fileSuffix.equals(".jpg") || !fileSuffix.equals(".png")){
//            logger.info("文件格式不正确");
//        }
//        //拼装新的文件名
//        String targetFileName = targetFilePath + newFileName + fileSuffix;
//        //上传文件
//        try {
//            FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(targetFileName));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "/success";
//    }
    //使用fastdfs进行文件上传

    @ResponseBody
    @RequestMapping("/uploadFileToFast")
    public String uoloadFileToFast(@RequestParam("fileName") MultipartFile file, String desc) throws IOException {
        if (file.isEmpty()) {
            logger.info("文件不存在");
        }
        String path = fileUtil.uploadFile(file);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();

        FileInfo fileInfo = new FileInfo();
        fileInfo.setPicaddr(path);
        fileInfo.setAddtime(now);
        fileInfo.setFiledesc(desc);
        fileInfo.setFilename("filename");
        fileInfoMapper.insertFile(fileInfo);
        System.out.println(path);
        return "success";
    }
}

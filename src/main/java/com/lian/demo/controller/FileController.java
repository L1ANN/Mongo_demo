package com.lian.demo.controller;

import com.lian.demo.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 下午6:18 2018/9/20
 * @Modified By:
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static final Logger LOGGER = LogManager.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @RequestMapping(value="/upload.action",method= RequestMethod.POST)
    public String upload(HttpServletRequest request, MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        if(!filename.isEmpty()){
            String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/temp/");
            File temp = new File(filePath,filename);
            if(!temp.getParentFile().exists())
                temp.getParentFile().mkdir();
            if(!temp.exists())
                temp.createNewFile();
            try{
                file.transferTo(temp);
            }catch(IllegalStateException e){
                LOGGER.error("文件上传错误:{}",filename);
            }

            /**
             * 对文件临时文件进行读取，操作
             */


            /**
             * 操作完后，删除临时文件
             */
            temp.delete();
        }
        return "success";
    }

    @RequestMapping(value="/download.action",method=RequestMethod.GET)
    public ResponseEntity<byte[]> download(@RequestParam String fileName){
        /**
         * 读取文件
         */

        byte[] body = fileService.downloadFile(fileName);
        LOGGER.info("{},文件读取成功",fileName);
        /**
         * 生成下载文件的响应对象
         */
        return fileService.downloadResponse(body,fileName);
    }

}

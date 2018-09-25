package com.lian.demo.service;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 下午3:38 2018/9/21
 * @Modified By:
 */
@Service
public class FileService {

    private static final String PATH = "/Users/lianpengfei/git/demo/pic/";

    private static Logger LOGGER = LogManager.getLogger(FileService.class);

    public byte[] downloadFile(String fileName){
        byte[] res = new byte[0];
        try{
            File file = new File(PATH,fileName);
            if(file.exists() && !file.isDirectory())
                res = FileCopyUtils.copyToByteArray(file);

        }catch(IOException e){
            LOGGER.error("文件下载错误：{}",PATH+fileName);

        }
        return res;
    }

    public ResponseEntity<byte[]> downloadResponse(byte[] body,String fileName){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String agent = request.getHeader("User-Agent").toUpperCase();
        HttpStatus status = HttpStatus.CREATED;
        try{
            if(agent.contains("MSIE") || agent.contains("TRIDENT") || agent.contains("EDGE")){
                fileName = URLEncoder.encode(fileName,"UTF-8");
                fileName= fileName.replace("+","%20");
                status = HttpStatus.OK;
            }else{
                fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
            }
        }catch(UnsupportedEncodingException e){

        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentLength(body.length);

        return new ResponseEntity<byte[]>(body,headers,status);
    }
}

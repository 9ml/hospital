package com.litbo.hospitalzj.hospital.utils;

import com.litbo.hospitalzj.supplier.controller.ex.FileEmptyException;
import com.litbo.hospitalzj.supplier.controller.ex.FileSizeOutOfLimitException;
import com.litbo.hospitalzj.supplier.controller.ex.FileTypeNotSupportException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUpload {
    /**
     * 上传文件夹的名称
     */
    private static final String UPLOAD_DIR_NAME = "upload";
    /**
     * 上传文件的最大大小
     */
    private static final long FILE_MAX_SIZE = 5 * 1024 * 1024;
    /**
     * 允许上传的文件类型
     */
    private static final List<String> FILE_CONTENT_TYPES = new ArrayList<>();
    /**
     * 初始化允许上传的文件类型的集合
     */
    static {
        FILE_CONTENT_TYPES.add("image/jpeg");
        FILE_CONTENT_TYPES.add("image/png");
        FILE_CONTENT_TYPES.add("image/jpg");
    }
    public static String upload(String filePath, MultipartFile file) {
        // 文件保存的命名空间
        String path = System.getProperty("user.dir");
        // 保存到数据库中的相对路径
        String fileSpace = System.getProperty("user.dir") + "/static_file";
        String uploadPathDB = "/" + UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (file != null) {

                String fileName = file.getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 文件上传的最终保存路径
                    String finalFacePath = fileSpace + filePath +  uploadPathDB;
                    // 设置数据库保存的路径
                    uploadPathDB = "/static_file" + filePath +   uploadPathDB;

                    System.out.println(finalFacePath);
                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        return uploadPathDB;
    }


        //        String newFileName = null;
//        String insertPath = null;
//
//        String PATH = "static/"+filePath;
//        try {
//            //获取跟目录
//            File path = new File(ResourceUtils.getURL("classpath:").getPath());
//            if(!path.exists()) path = new File("");
//            File upload = new File(path.getAbsolutePath(),PATH);
//            System.out.println("EEEEEEEEEEEEEEE"+upload);
//            if(!upload.exists()) upload.mkdirs();
//            insertPath = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//            newFileName =upload.getAbsolutePath()+ File.separator + insertPath;
//            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(newFileName)));
//            out.write(file.getBytes());
//            out.flush();
//            out.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return filePath+insertPath;

    public static String uploadOne(MultipartFile file, HttpSession session) {
        // 检查是否存在上传文件 > file.isEmpty()
        if (file.isEmpty()) {
            // 抛出异常：文件不允许为空
            throw new FileEmptyException(
                    "上传失败！没有选择上传的文件，或选中的文件为空！");
        }
        // TODO 检查文件大小 > file.getSize()
        if (file.getSize() > FILE_MAX_SIZE) {
            // 抛出异常：文件大小超出限制
            throw new FileSizeOutOfLimitException("上传失败！文件过大");
        }
        // TODO 检查文件类型 > file.getContentType()
        return upload("images/upload",file);
//        /*if (FILE_CONTENT_TYPES.contains(
//                file.getContentType())) {
//            // 抛出异常：文件类型限制
//            throw new FileTypeNotSupportException("文件类型不符");
//        }*/
//        String newFileName = null;
//        String insertPath = null;
//       /* String filePath="/images/upload/";
//        String PATH = "static/"+filePath;*/
//
//        String filePath= File.separator +"images"+ File.separator+"upload" + File.separator;
//        String PATH = "static"+ File.separator +filePath;
//        try {
//            //获取跟目录
//            File path = new File(ResourceUtils.getURL("classpath:").getPath());
//            if(!path.exists()) path = new File("");
//            File upload = new File(path.getAbsolutePath(),PATH);
//            System.out.println("EEEEEEEEEEEEEEE"+upload);
//            if(!upload.exists()) upload.mkdirs();
//            insertPath = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//
//
//            newFileName =upload.getAbsolutePath()+ File.separator + insertPath;
//            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(newFileName)));
//            out.write(file.getBytes());
//            out.flush();
//            out.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return filePath+insertPath;
    }
}

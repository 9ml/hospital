package com.litbo.hospitalzj.user.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.hospital.utils.FileDownLoad;
import com.litbo.hospitalzj.hospital.utils.FileUpload;
import com.litbo.hospitalzj.user.bean.Wjsc;
import com.litbo.hospitalzj.user.service.WjscService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//文件上传控制类
@RestController
@RequestMapping("/wjsc")
public class WjscController extends BaseController {
    @Autowired
    private WjscService wjscService;

    @RequestMapping("/insertHtwj")
    public ResponseResult<Void> insertHtwj(Wjsc wjsc, @RequestParam("file") MultipartFile file, HttpSession session) {
        String path = FileUpload.uploadOne(file, session);
        System.out.println(path);
        wjsc.setSourceType(0);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }

    @RequestMapping("/insertDhdj")
    public ResponseResult<Void> insertDhdj(Wjsc wjsc, @RequestParam("file") MultipartFile file, HttpSession session) {
        String path = FileUpload.uploadOne(file, session);
        System.out.println(path);
        wjsc.setSourceType(1);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }


    @RequestMapping("/insertJztp")
    public ResponseResult<Void> insertJztp(Wjsc wjsc, @RequestParam("file") MultipartFile file, HttpSession session) {
        String path = FileUpload.uploadOne(file, session);
        System.out.println(path);
        wjsc.setSourceType(4);
        wjsc.setSourceId(-1);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }

    @RequestMapping("/insertWszl")
    public ResponseResult<Void> insertWszl(Wjsc wjsc, @RequestParam("file") MultipartFile file, HttpSession session) {
        String path = FileUpload.uploadOne(file, session);
        System.out.println(path);
        wjsc.setSourceType(2);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/insertSuWj")
    public ResponseResult<Void> insertSuWj(Wjsc wjsc, @RequestParam("file") MultipartFile file, HttpSession session) {
        String path = FileUpload.uploadOne(file, session);
        System.out.println(path);
        wjsc.setSourceType(3);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }


    @RequestMapping("/delete")
    public ResponseResult<Void> delete(Integer htId) {
        wjscService.delete(htId);
        return new ResponseResult<Void>(SUCCESS);
    }



    //sourceType供应商，验收
    //sourceId来源id，httongid
    //文件类型
    @RequestMapping("/select")
    public ResponseResult<List<Wjsc>> select(@RequestParam("sourceType") Integer sourceType, @RequestParam("sourceId") Integer sourceId, @RequestParam("type") Integer type) {
        List<Wjsc> data = wjscService.select(sourceType, sourceId, type);
        return new ResponseResult<List<Wjsc>>(SUCCESS, data);
    }


    @RequestMapping("/selectLast")
    public ResponseResult<String> selectLast(String type){
        Wjsc wjsc = wjscService.selectLast(4, -1, type);
        return new ResponseResult<>(200, wjsc.getPath());
    }


    @RequestMapping("/selectType")
    public ResponseResult selectType(Integer sourceId){
        List<Wjsc> data0= wjscService.selectByType(0, sourceId);
        List<Wjsc> data2= wjscService.selectByType(2, sourceId);
        List list = new ArrayList();
        list.add(data0);
        list.add(data2);
        return new ResponseResult(200, list);
    }

    //文件下载
    @RequestMapping("/downloadFile")
    private ResponseResult<Void> downloadFile(@RequestParam("filePath") String filePath, HttpServletResponse response, HttpSession session) throws FileNotFoundException, IllegalStateException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println(path);
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), "static" + File.separator);
        System.out.println(upload);
        if (!upload.exists()) upload.mkdirs();
        String path1 = upload.getAbsolutePath() + filePath;
        System.out.println(path1);
        FileDownLoad.downloadFile1(response, path1, filePath);
        return null;
    }
}

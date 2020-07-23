package com.litbo.hospitalzj.zk.controller;


import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.Syb;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.Zsb;
import com.litbo.hospitalzj.checklist.service.DcsjhyService;
import com.litbo.hospitalzj.checklist.service.SybService;
import com.litbo.hospitalzj.checklist.service.ZsbService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/qf")
public class QfChildORManController {

    @Autowired
    private ZsbService zsbService;

    @Autowired
    private SybService sybService;

    @Autowired
    private DcsjhyService dcsjhyService;


    @RequestMapping("/childOrMan/{eqId}/{jcyqId}")
    public ResponseResult<Integer> QfChildOrMan(@PathVariable("eqId") String eqId,
                                                @PathVariable("jcyqId") String jcyqId) {
        Integer jcyq = Integer.parseInt(jcyqId);
        if (jcyq == 3 || jcyq == 4) {
            //生命体征模拟器
            List<Dcsjhy> dcsjhy_c = dcsjhyService.findByEqIdandJcyqId("dcsjhy_c", eqId, jcyqId);
            if(dcsjhy_c.size() == 0){
                return new ResponseResult<>(200, 1);
            }//幼儿
            return new ResponseResult<>(200, 2);
        } else if (jcyq == 7) {
            //输液设备分析仪
            List<Syb> sybs = sybService.findByEqIdandJcyqId(eqId, jcyqId);
            if(sybs.size() == 0){
                //成人
                return new ResponseResult<>(200, 1);
            }
            //幼儿
            return new ResponseResult<>(200, 2);
        } else if (jcyq == 10) {
            //注射设备分析仪
            List<Zsb> zsbs = zsbService.findByEqIdandJcyqId(eqId, jcyqId);
            if(zsbs.size() == 0){
                return new ResponseResult<>(200, 1);
            }
            return new ResponseResult<>(200, 2);
        }else{
            return new ResponseResult<>(200, "0");
        }
    }


}

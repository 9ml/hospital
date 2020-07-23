package com.litbo.hospitalzj.zk.controller;

import com.litbo.hospitalzj.checklist.domain.*;
import com.litbo.hospitalzj.checklist.service.*;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqEq;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.service.YqEqService;
import com.litbo.hospitalzj.zk.service.YqService;
import com.litbo.hospitalzj.zk.vo.YqEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/yqEq")
public class YqEqController extends BaseController {

    @Autowired
    private YqEqService yqEqService;
    @Autowired
    private EqInfoService eqInfoService;
    @Autowired
    YqService yqService;
    @Autowired
    private CcyService ccyService;
    @Autowired
    private GpddService gpddService;
    @Autowired
    private HxjService hxjService;
    @Autowired
    private DcsjhyService dcsjhyService;
    @Autowired
    private SybService sybService;
    @Autowired
    private YepyxService yepyxService;
    @Autowired
    private ZsbService zsbService;
    @Autowired
    private DqjcService dqjcService;



    //根据设备的id和检测仪器的id查询最后一条检测记录
    @RequestMapping("/findByEqIdAndJcyqId/{eqId}/{jcyqId}")
    public ResponseResult<Object> findByEqIdAndJcyqId(@PathVariable("eqId") String eqId,
                                                      @PathVariable("jcyqId") String jcyqId
                                                     ){

        if(Integer.parseInt(jcyqId) == 5){
               Dqjc dqjc =  dqjcService.findByEqIdandJcyqIdLast(eqId, jcyqId);
            return new ResponseResult<>(200, dqjc);
        }

        //根据设备id查询设备对应的品名
        int eqPm = eqInfoService.findEqPm(eqId);
        if(eqPm == 1){
            //心电监护仪
            Dcsjhy dcsjhy = dcsjhyService.findByEqIdandJcyqIdLast("dcsjhy_c",eqId, jcyqId);
            if(dcsjhy == null){
                dcsjhy = dcsjhyService.findByEqIdandJcyqIdLast("dcsjhy_m",eqId, jcyqId);
            }
           return new ResponseResult<>(200, dcsjhy);

        }else if(eqPm == 2){
            //除颤器
            Ccy ccy = ccyService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
           if(ccy == null){
               //心电监护仪
               Dcsjhy dcsjhy = dcsjhyService.findByEqIdandJcyqIdLast("dcsjhy_c",eqId, jcyqId);
               if(dcsjhy == null){
                   dcsjhy = dcsjhyService.findByEqIdandJcyqIdLast("dcsjhy_m",eqId, jcyqId);
               }
               return new ResponseResult<>(200, dcsjhy);
           }

            return new ResponseResult<>(200, ccy);
        }else if(eqPm == 3){
            //高频电刀
            Gpdd gpdd = gpddService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
            return new ResponseResult<>(200, gpdd);
        }else if(eqPm == 4){
            //呼吸机
            Hxj hxj = hxjService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
            return new ResponseResult<>(200, hxj);
        }/*else if(eqPm == 5 || eqPm == 6){
            //输液泵
            SybC syb = sybService.findByEqIdandJcyqIdLast("syb_c", eqId, jcyqId);
            if(syb == null){
                syb = sybService.findByEqIdandJcyqIdLast("syb_m", eqId, jcyqId);
            }
            return new ResponseResult<>(200, syb);

        }*/else if(eqPm == 5 || eqPm == 6){
            //注射泵
            Zsb zsb =zsbService.findByEqIdandJcyqIdLast1(eqId,jcyqId);
//                    findByEqIdandJcyqIdLast("zsb_c", eqId, jcyqId);
            if(zsb == null){
                Syb syb = sybService.findByEqIdandJcyqIdLast1( eqId, jcyqId);
                    return new ResponseResult<>(200, syb);

            }

            return new ResponseResult<>(200, zsb);
        }else if(eqPm == 7){
            //婴儿培养箱
            Yepyx yepyx = yepyxService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
            return new ResponseResult<>(200, yepyx);
        }else {
            //暂无该数据
            return new ResponseResult<>(501, "暂无数据");
        }

    }

    @RequestMapping("/findOtherAndJcshcg/{eqId}")
    public ResponseResult<List<Yq>> findOtherAndJcshcg(@PathVariable String eqId) {
        List<Yq> yqs = yqEqService.selectOtherAndJcshcg(eqId);
        return new ResponseResult<List<Yq>>(200, yqs);
    }


    @RequestMapping("/findDqjcAndJcshcg/{eqId}")
    public ResponseResult<List<Yq>> findDqjcAndJcshcg(@PathVariable String eqId) {
        List<Yq> yqs = yqEqService.selectDqjcAndJcshcg(eqId);
        return new ResponseResult<List<Yq>>(200, yqs);
    }


    @RequestMapping("/findOtherAndJcBtg/{eqId}")
    public ResponseResult<List<Yq>> findOtherAndJcBtg(@PathVariable String eqId) {
        List<Yq> yqs = yqEqService.selectOtherAndJcBtg(eqId);
        return new ResponseResult<List<Yq>>(200, yqs);
    }


    @RequestMapping("/findDqjcAndJcBtg/{eqId}")
    public ResponseResult<List<Yq>> findDqjcAndJcBtg(@PathVariable String eqId) {
        List<Yq> yqs = yqEqService.selectDqjcAndJcBtg(eqId);
        return new ResponseResult<List<Yq>>(200, yqs);
    }


    //待上传
    @RequestMapping("/findOtherAndDsc/{eqId}")
    public ResponseResult<List<Yq>> selectOtherAndDsc(@PathVariable String eqId) {
        List<Yq> yqs = yqEqService.selectOtherAndDsc(eqId);
        return new ResponseResult<List<Yq>>(200, yqs);
    }

    //待上传
    @RequestMapping("/findDqjcAndDsc/{eqId}")
    public ResponseResult<List<Yq>> selectDqjcAndDsc(@PathVariable String eqId) {
        List<Yq> yqList = yqEqService.selectDqjcAndDsc(eqId);
        return new ResponseResult<List<Yq>>(200, yqList);
    }


    //为仪器分配设备pm
    @RequestMapping("/selectYqEq")
    public ResponseResult<List<YqEqVo>> selectYqEq(HttpSession session) {
        String userId = getUserIdFromSession(session);
        List<YqEqVo> data = yqEqService.selectYqEq(userId, 2);
        return new ResponseResult<List<YqEqVo>>(SUCCESS, data);
    }

    //修改状态
    @RequestMapping("/insert")
    public ResponseResult<Integer> insert(@RequestParam("jcyqId") String jcyqId, @RequestParam("eqId") String eqId) {
        int data = yqEqService.insertBatch(eqId, jcyqId);
        return new ResponseResult<Integer>(SUCCESS, data);
    }
//	
//	//删除仪器设备
//	@RequestMapping("/delete")
//	public ResponseResult<Void> delete(String userId,String eyId){
//		YqEq yqEq=new YqEq();
//		yqEq.setJcyqId("1");
//		yqEq.setEqId("6");
//		yqEqService.delete(yqEq);
//		return new ResponseResult<Void>(SUCCESS);
//	}
//	
	
	/*//为仪器分配设备pm
	@RequestMapping("/insertBatch")
	public ResponseResult<Void> insertBatch(YqEq yqEq){
		yqEq.setState(1);
		yqEqService.insertBatch(yqEq);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//删除仪器设备
	@RequestMapping("/deleteBatch/{jcyqId}/{eqId}")
	public ResponseResult<Void> deleteBatch(@PathVariable String jcyqId,@PathVariable String eqId){
		yqEqService.deleteBatch(jcyqId,eqId);
		return new ResponseResult<Void>(SUCCESS);
	}*/
	
	/*//查询所有仪器
	@RequestMapping("/findAllYq")
	public ResponseResult<List<Yq>> findAllYq(){
		List<Yq> yqList=yqService.findAll();
		for(int i=0;i<yqList.size();i++){
			System.out.println(yqList.get(i));
		}
		return new ResponseResult<List<Yq>>(SUCCESS,yqList);
	}*/

    //查询仪器已分配的设备
	/*@RequestMapping("/findByJcyqId/{jcyqId}")
	public ResponseResult<List<EqInfo>> findByJcyqId(@PathVariable String jcyqId){
		List<EqInfo> yqList=eqInfoService.findByJcyqId(jcyqId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}
	
	//查询仪器没有分配的设备
	@RequestMapping("/findNotByJcyqId/{jcyqId}")
	public ResponseResult<List<EqInfo>> findNotByJcyqId(@PathVariable String jcyqId){
		List<EqInfo> yqList=eqInfoService.findNotByJcyqId(jcyqId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}*/
	/*@RequestMapping("/findEqId")
	public ResponseResult<YqEq> findEqId(String jcyqId){
		YqEq yqList=yqEqService.selectEqId(jcyqId);
		return new ResponseResult<YqEq>(SUCCESS,yqList);
	}*/


}

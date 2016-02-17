package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.DateTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.controller.exception.ResourceIsNotExistException;
import cn.ifengkou.gaia.model.Shipping;
import cn.ifengkou.gaia.service.ShippingDocService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
@RestController
@RequestMapping("api/shipping")
public class ShippingDocController {

    @Resource
    ShippingDocService shippingDocService;

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public JsonDto getList(@RequestParam(value = "page",defaultValue = "1")int page,HttpServletRequest request) {
        //id,login,username,usertype
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        PageHelper.startPage(page, _Sys.PAGE_SIZE);
        List<HashMap<String,Object>> shippingDoc = shippingDocService.getCustomerShippingDoc((String) user.get("username"));
        return new JsonDto(true,shippingDoc);
    }

    @RequestMapping(method= RequestMethod.PUT,value = "/{id}/sign",consumes = "application/json")
    @ResponseBody
    public JsonDto signIn(@PathVariable("id")String id,@RequestBody Shipping shipping,HttpServletRequest request) throws ResourceIsNotExistException {
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        Shipping bean = shippingDocService.get(id,(String) user.get("username"));
        if(bean == null){
            //throw new ResourceIsNotExistException();
            return new JsonDto(false,"当前用户下，未找到单号为【"+id+"】的发货单");
        }
        if(shipping.getIsSigned()==1&&shipping.getSignInCube()<0) {
            return new JsonDto(false,"若已签收，则签收方量不能小于0");
        }
        if(bean.getIsSigned()==1) {
            return new JsonDto(false,"该发货单已经被签核");
        }
        String userId = (String)user.get("id");
        bean.setModifier(userId);
        //MyBeanUtils.copyProperties(shipping, bean);
        bean.setIsSigned(shipping.getIsSigned());
        bean.setExceptionInfo(shipping.getExceptionInfo());
        if(shipping.getSignInCube()>=0) {
            bean.setSignInCube(shipping.getSignInCube());
        }

        shippingDocService.sign(bean);
        return new JsonDto(true,"签收成功",bean);
    }

    @RequestMapping(method= RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public JsonDto get(@PathVariable("id")String id,HttpServletRequest request) throws ResourceIsNotExistException {
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        Shipping bean = shippingDocService.get(id,(String) user.get("username"));
        if(bean == null){
            return new JsonDto(false,"当前用户下，未找到单号为【"+id+"】的发货单");
        }
        return new JsonDto(true,"查询单号'"+id+"'成功",bean);
    }

    //站内功能

    /**
     * 出票方量、调度方量统计
     * @param beginTime
     * @param endTime
     * @return
     */
    @RequestMapping(method= RequestMethod.GET,value = "/stat")
    @ResponseBody
    public JsonDto statShippingCubes(Date beginTime,Date endTime) {
        if(beginTime==null){
            beginTime = DateTools.getFirstDayCurrentMonth();
        }
        if(endTime == null){
            endTime = new Date();
        }
        return new JsonDto(true,shippingDocService.statShippingCubes(beginTime,endTime));
    }

    /**
     * 生产方量统计，按工地和砼强度分组
     * @param beginTime
     * @param endTime
     * @return
     */
    @RequestMapping(method= RequestMethod.GET,value = "/list")
    @ResponseBody
    public JsonDto getShippingDocByTime(Date beginTime,Date endTime) {
        if(beginTime==null){
            beginTime = DateTools.getFirstDayCurrentMonth();
        }
        if(endTime == null){
            endTime = new Date();
        }
        return new JsonDto(true,shippingDocService.getShippingDocByTime(beginTime,endTime));
    }
}

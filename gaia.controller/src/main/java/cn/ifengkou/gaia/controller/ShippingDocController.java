package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.controller.exception.ResourceIsNotExistException;
import cn.ifengkou.gaia.model.Shipping;
import cn.ifengkou.gaia.service.ShippingDocService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        Shipping bean = shippingDocService.get(id);
        if(bean == null){
            throw new ResourceIsNotExistException();
        }
        if(shipping.getIsSigned()==1&&shipping.getSignInCube()<0) {
            return new JsonDto(false,"若已签收，则签收方量不能小于0");
        }
        if(bean.getIsSigned()==1) {
            return new JsonDto(false,"该发货单已经被签核");
        }
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
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
        Shipping bean = shippingDocService.get(id);
        if(bean == null){
            throw new ResourceIsNotExistException();
        }
        return new JsonDto(true,"查询单号'"+id+"'成功",bean);
    }
}

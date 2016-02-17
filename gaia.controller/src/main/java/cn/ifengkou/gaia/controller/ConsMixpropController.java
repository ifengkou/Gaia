package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.service.ConsMixpropService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Sloong on 2016/2/17.
 */
@RestController
@RequestMapping("api/consMixprop")
public class ConsMixpropController {

    @Resource
    ConsMixpropService consMixpropService;

    /**
     * 根据生产线id获取未被审核的施工配比单
     * @param productLineId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public JsonDto getTodayDispatchList(@RequestParam(value = "productLineId",defaultValue = "")String productLineId,HttpServletRequest request){
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.ADMIN_KEY);
        if(user == null){
            return new JsonDto(false,"无权限");
        }
        return new JsonDto(true,consMixpropService.getConsMixprops(productLineId));
    }

    /**
     * 根据施工配比ID，获得配比详细材料用量
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/{id}/stuffs")
    @ResponseBody
    public JsonDto getConsMixpropItem(@PathVariable("id")String id,HttpServletRequest request){
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.ADMIN_KEY);
        if(user == null){
            return new JsonDto(false,"无权限");
        }
        return new JsonDto(true,consMixpropService.getConsMixpropItems(id));
    }

    /**
     * 审核施工配比
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}/audit")
    @ResponseBody
    public JsonDto auditConsMixprop(@PathVariable("id")String id,HttpServletRequest request){
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.ADMIN_KEY);
        if(user == null){
            return new JsonDto(false,"无权限");
        }
        int x = consMixpropService.audit(id);
        if(x == 1){
            return new JsonDto(true,"审核["+id+"]成功");
        }
        return new JsonDto(false,"审核失败");
    }

}

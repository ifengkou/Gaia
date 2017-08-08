package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.service.SiloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Sloong on 2016/2/17.
 */
@RestController
@RequestMapping("api/silos")
public class SiloController {

    @Resource
    SiloService siloService;
    private final static Logger LOG = LoggerFactory.getLogger(SiloController.class);
    /**
     * 查询筒仓内原材料库存
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JsonDto querySilo(HttpServletRequest request){
        LOG.info("查询筒仓内原材料库存");
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.ADMIN_KEY);
        if(user == null){
            return new JsonDto(false,"无权限");
        }
        return new JsonDto(true,siloService.querySilo());
    }

}

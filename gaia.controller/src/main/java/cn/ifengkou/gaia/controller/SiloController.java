package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.service.SiloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Sloong on 2016/2/17.
 */
@RestController
@RequestMapping("api/silos")
public class SiloController {

    @Resource
    SiloService siloService;

    /**
     * 查询筒仓内原材料库存
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JsonDto querySilo(){
        return new JsonDto(true,siloService.querySilo());
    }

}

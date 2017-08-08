package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sloong on 2015/12/15.
 */
@RestController
@RequestMapping("api")
public class TestApiController {
    private final static Logger LOG = LoggerFactory.getLogger(TestApiController.class);

    @RequestMapping(method= RequestMethod.GET,value = "/test")
    @ResponseBody
    public JsonDto testServer(){
        LOG.info("测试服务器状态");
        return new JsonDto(true);
    }
}

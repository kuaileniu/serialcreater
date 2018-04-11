package cn.zhsit.controllers;

import cn.zhsit.daos.ZyZybhzbMapper;
import cn.zhsit.models.vo.SerialReq;
import cn.zhsit.models.vo.SerialResp;
import cn.zhsit.services.SerialService;
import cn.zhsit.services.impl.ServiceCollection;
import cn.zhsit.utils.ZhsJsonUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Darren
 *         61947666@qq.com
 * @description
 */
@Controller
@RequestMapping("/serial")
//@ApiIgnore
public class SerialController {
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("serviceCollection")
    protected ServiceCollection serviceCollection;
    @Autowired
    private SerialService serialService;
    //    http://127.0.0.1:8080/serial/give?zuzhi=ct&fenlei=jy&count=2
//    @ApiOperation(value = "请求序号", notes = "根据SerialReq对象返回序号")
//    @RequestMapping(value = "/give", method = RequestMethod.POST)
//    @ResponseBody
//    public void give(HttpServletRequest request, HttpServletResponse resp, SerialReq serial) {
//        try {
//            serviceCollection.getZuZhiService(serial).handle(request, resp, serial);
//        } catch (Exception e) {
//            log.error("请求序号接口异常", e);
//        }
//    }
    //    http://127.0.0.1:8080/serial/give?orgCode=ct&productCode=jy&count=2
    @ApiOperation(value = "请求序号", notes = "根据SerialReq对象返回序号")
//    @GetMapping
//    @PostMapping
    @RequestMapping(value = "/give")
//    @RequestMapping(value = "/give", method = RequestMethod.POST)
    @ResponseBody
    public void give(HttpServletRequest request, HttpServletResponse resp, SerialReq serial) {
        try {
            serialService.handle(request, resp, serial);
        } catch (Exception e) {
            log.error("请求序号接口异常", e);
        }
    }

    @ApiIgnore
    //一次性获取不同组织不同产品的id
    @RequestMapping("/getmany")
    @ResponseBody
    public void getMany(HttpServletRequest request, HttpServletResponse resp, SerialReq[] serial) {

    }

}

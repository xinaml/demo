package com.example.demo.act;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Address;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IconAct {
    @RequestMapping(value = "/icon", method = RequestMethod.GET)
    public String icon(HttpServletRequest request, Model model) {

        return "icon";
    }

    @ApiOperation(value="地址列表", notes="page")
    @ApiImplicitParam(name = "page", value = "地址详细实体address", required = true,paramType = "query", dataType = "String")
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String data(HttpServletRequest request,@RequestParam String page) {
        Map<String,Object> map = new HashMap<>();
        List<Address> data = new ArrayList<>();
        for(int i=0;i<10;i++){
            Address address = new Address();
            address.setAddress("tang"+i);
            address.setId(String.valueOf(i));
            address.setCity("南宁");
            address.setName("guangzhou");
            address.setZipCode("4323352");
            data.add(address);
        }

        map.put("rows",data);
        map.put("total",21);

        return JSON.toJSONString(map);
    }


}

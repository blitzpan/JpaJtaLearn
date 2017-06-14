package com.channelsoft.apiplus.controller;

import com.channelsoft.apiplus.entity.oracle.Test2;
import com.channelsoft.apiplus.entity.mysql.TestOne;
import com.channelsoft.apiplus.service.ITestOneService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by Administrator on 2017-4-26.
 */

@Controller
@RequestMapping(value="/test")
public class TestController {
    @Autowired
    private ITestOneService testOneService;

    private static int defaultType = 0;

    @RequestMapping(value = "/add")
    @ResponseBody
    public void add(String typeStr){
        try{
            int type;
            if(StringUtils.isBlank(typeStr)){
                type = defaultType;
                defaultType++;
                if(defaultType == 12){
                    defaultType = 0;
                }
            }else{
                type = Integer.parseInt(typeStr);
            }
            System.out.println("******************************type=" + type);
            switch(type){
                case 0:
                    testOneService.insert3();
                    break;
                case 1:
                    testOneService.insert3Error();
                    break;
                case 2:
                    testOneService.jtAndMysql();
                    break;
                case 3:
                    testOneService.jtAndMysqlError();
                    break;
                case 4:
                    testOneService.jtAndOracle();
                    break;
                case 5:
                    testOneService.jtAndOracleError();
                    break;
                case 6:
                    testOneService.jtErrorWithMysql();
                    break;
                case 7:
                    testOneService.jtErrorWithOracle();
                    break;
                case 8:
                    testOneService.mysqlErrorWithOracle();
                    break;
                case 9:
                    testOneService.mysqlWithOracle();
                    break;
                case 10:
                    testOneService.mysqlWithOracleError();
                    break;
                case 11:
                    testOneService.insertJt();
                    break;
                default :
                    System.out.println("default");
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

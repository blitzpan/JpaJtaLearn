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

import java.util.Date;
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
    public void add(String typeStr, Boolean delay){
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
            System.out.println(new Date() + "******************************type=" + type + "，delay=" + delay);
            switch(type){
                case 0:
                    testOneService.insert3(delay);//2+1
                    break;
                case 1:
                    testOneService.insert3Error(delay);
                    break;
                case 2:
                    testOneService.jtAndMysql(delay);//2+0
                    break;
                case 3:
                    testOneService.jtAndMysqlError(delay);
                    break;
                case 4:
                    testOneService.jtAndOracle(delay);//1+1
                    break;
                case 5:
                    testOneService.jtAndOracleError(delay);
                    break;
                case 6:
                    testOneService.jtErrorWithMysql(delay);
                    break;
                case 7:
                    testOneService.jtErrorWithOracle(delay);
                    break;
                case 8:
                    testOneService.mysqlErrorWithOracle(delay);
                    break;
                case 9:
                    testOneService.mysqlWithOracle(delay);//1+1
                    break;
                case 10:
                    testOneService.mysqlWithOracleError(delay);
                    break;
                case 11:
                    testOneService.jt(delay);//1+0
                    break;
                case 12:
                    testOneService.oracle(delay);//0+1
                    break;
                case 13:
                    testOneService.mysql(delay);//1+0
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

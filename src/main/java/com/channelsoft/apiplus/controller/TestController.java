package com.channelsoft.apiplus.controller;

import com.channelsoft.apiplus.entity.Test2;
import com.channelsoft.apiplus.entity.TestOne;
import com.channelsoft.apiplus.service.ITestOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/add")
    @ResponseBody
    public void add(){
        try{
            System.out.println("呵呵");
            TestOne test1 = new TestOne();
            test1.setId(new Random().nextInt() + "");
            test1.setName(System.currentTimeMillis() + "");

            testOneService.insert(test1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/add2")
    @ResponseBody
    public void insertTwo(){
        try{
            System.out.println("呵呵");
            TestOne test1 = new TestOne();
            test1.setId(new Random().nextInt() + "");
            test1.setName(System.currentTimeMillis() + "");

            Test2 test2 = new Test2();
            test2.setId(new Random().nextInt() + "");
            test2.setName(System.currentTimeMillis() + "");

            testOneService.insertTwo(test1, test2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/add2Fail")
    @ResponseBody
    public void insertTwoFail(){
        try{
            System.out.println("呵呵");
            TestOne test1 = new TestOne();
            test1.setId(new Random().nextInt() + "");
            test1.setName(System.currentTimeMillis() + "");

            Test2 test2 = new Test2();
            test2.setId(new Random().nextInt() + "");
            test2.setName(System.currentTimeMillis() + "");

            testOneService.insertTwoFail(test1, test2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/add2Fail1")
    @ResponseBody
    public void insertTwoFailOne(){
        try{
            System.out.println("呵呵");
            TestOne test1 = new TestOne();
            test1.setId(new Random().nextInt() + "");
            test1.setName(System.currentTimeMillis() + "");

            Test2 test2 = new Test2();
            test2.setId(new Random().nextInt() + "22222222222222222222222222222");
            test2.setName(System.currentTimeMillis() + "");

            testOneService.insertTwoFailOne(test1, test2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

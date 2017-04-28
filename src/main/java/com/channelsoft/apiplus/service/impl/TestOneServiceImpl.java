package com.channelsoft.apiplus.service.impl;

import com.channelsoft.apiplus.entity.oracle.Test2;
import com.channelsoft.apiplus.entity.mysql.TestOne;
import com.channelsoft.apiplus.repository.mysql.HelloDao;
import com.channelsoft.apiplus.repository.oracle.Hello2Dao;
import com.channelsoft.apiplus.service.ITestOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017-4-25.
 */

@Service
@Component
@Transactional
public class TestOneServiceImpl implements ITestOneService {
    @Autowired
    private HelloDao helloDao;
    @Autowired
    private Hello2Dao hello2Dao;

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    @Transactional
    public void insert(TestOne test1) throws Exception{

        System.out.println("save begin");
        helloDao.save(test1);
        TestOne tempT =  helloDao.findOne(test1.getId());
        System.out.println("查询出来=" + tempT);
        System.out.println("save end");
//        throw new RuntimeException("一个异常！");
    }

    @Override
    public void insertTwo(TestOne test1, Test2 test2) throws Exception {
        helloDao.save(test1);
        hello2Dao.save(test2);
        System.out.println("save end");
    }

    @Override
    public void insertTwoFail(TestOne test1, Test2 test2) throws Exception {
        helloDao.save(test1);
        hello2Dao.save(test2);
        System.out.println("save end");
        throw new RuntimeException("异常");
    }

    @Override
    public void insertTwoFailOne(TestOne test1, Test2 test2) throws Exception {
        helloDao.save(test1);
        hello2Dao.save(test2);
        System.out.println("save end");
    }
}

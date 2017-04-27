package com.channelsoft.apiplus.service.impl;

import com.channelsoft.apiplus.entity.TestOne;
import com.channelsoft.apiplus.repository.mysql.HelloDao;
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
}

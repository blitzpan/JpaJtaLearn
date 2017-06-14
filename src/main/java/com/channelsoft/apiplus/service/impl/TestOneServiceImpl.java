package com.channelsoft.apiplus.service.impl;

import com.channelsoft.apiplus.entity.oracle.Test2;
import com.channelsoft.apiplus.entity.mysql.TestOne;
import com.channelsoft.apiplus.repository.mysql.HelloDao;
import com.channelsoft.apiplus.repository.oracle.Hello2Dao;
import com.channelsoft.apiplus.service.ITestOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private static boolean errorFlag = false;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    private void insertJdbcTemplate( ) throws Exception {
        String sql="insert into test1 values(?,?)";
        int id = new Random().nextInt();
        String text = System.currentTimeMillis() + "";
        jdbcTemplate.update(sql, id, text);
    }
    private void insertJdbcTemplateError(){
        String sql="insert into test1 values(?,?)";
        int id = new Random().nextInt();
        String text = System.currentTimeMillis() + "";
        jdbcTemplate.update(sql, id+"555555555555555555", text);
    }
    private void insertMysql(){
        TestOne test1 = new TestOne();
        test1.setId(new Random().nextInt() + "");
        test1.setName(System.currentTimeMillis() + "");
        helloDao.save(test1);
    }

    private void insertMysqlError(){
        TestOne test1 = new TestOne();
        test1.setId(new Random().nextInt() + "6666666666666666");
        test1.setName(System.currentTimeMillis() + "");
        helloDao.save(test1);
    }
    private void insertOracle(){
        Test2 test2 = new Test2();
        test2.setId(new Random().nextInt() + "");
        test2.setName(System.currentTimeMillis() + "");
        hello2Dao.save(test2);
    }
    private void insertOracleError(){
        Test2 test2 = new Test2();
        test2.setId(new Random().nextInt() + "7777777777777777777");
        test2.setName(System.currentTimeMillis() + "");
        hello2Dao.save(test2);
    }

    @Override
    public void insert3( ) throws Exception {
        this.insertMysql();
        this.insertJdbcTemplate();
        this.insertOracle();
    }

    @Override
    public void insert3Error( ) throws Exception {
        insert3();
        throw new RuntimeException("异常");
    }

    @Override
    public void jtAndMysql( ) throws Exception {
        this.insertJdbcTemplate();
        try {
            System.out.println("2，开始睡2分钟");
            Thread.sleep((long) (1000*60*2));
            System.out.println("2，结束睡2分钟");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.insertMysql();
    }

    @Override
    public void jtAndMysqlError( ) throws Exception {
        this.insertJdbcTemplate();
        this.insertMysqlError();
    }

    @Override
    public void jtAndOracle( ) throws Exception {
        this.insertJdbcTemplate();
        this.insertOracle();
    }

    @Override
    public void jtAndOracleError( ) throws Exception {
        this.insertJdbcTemplate();
        this.insertOracleError();
    }

    @Override
    public void mysqlErrorWithOracle( ) throws Exception {
        this.insertOracle();
        this.insertMysqlError();
    }

    @Override
    public void mysqlWithOracleError( ) throws Exception {
        this.insertMysql();
        this.insertOracleError();
    }

    @Override
    public void mysqlWithOracle( ) throws Exception {
        this.insertMysql();
        System.out.println("开始睡2分钟");
        try {
            Thread.sleep(1000*60*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束睡2分钟");
        this.insertOracle();
    }

    @Override
    public void jtErrorWithMysql( ) throws Exception {
        this.insertMysql();
        this.insertJdbcTemplateError();
    }

    @Override
    public void jtErrorWithOracle( ) throws Exception {
        this.insertOracle();
        this.insertJdbcTemplateError();
    }

    @Override
    public void insertJt( ) throws Exception {
        this.insertJdbcTemplate();
    }
}

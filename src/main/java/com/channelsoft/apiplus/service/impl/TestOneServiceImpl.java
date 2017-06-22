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

    private void insertJdbcTemplate() throws Exception {
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
    public void insert3(boolean delay ) throws Exception {
        this.insertMysql();
        this.insertJdbcTemplate();
        this.insertOracle();
    }

    @Override
    public void insert3Error(boolean delay ) throws Exception {
        insert3(delay);
        throw new RuntimeException("异常");
    }

    @Override
    public void jtAndMysql(boolean delay ) throws Exception {
        this.insertJdbcTemplate();
        try {
            System.out.println("2，开始睡2分钟");
//            Thread.sleep((long) (1000*60*2));
            System.out.println("2，结束睡2分钟");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.insertMysql();
    }

    @Override
    public void jtAndMysqlError(boolean delay ) throws Exception {
        this.insertJdbcTemplate();
        this.insertMysqlError();
    }

    @Override
    public void jtAndOracle(boolean delay ) throws Exception {
        this.insertJdbcTemplate();
        this.insertOracle();
    }

    @Override
    public void oracle(boolean delay) throws Exception {
        this.insertOracle();
    }

    @Override
    public void jtAndOracleError(boolean delay ) throws Exception {
        this.insertJdbcTemplate();
        this.insertOracleError();
    }

    @Override
    public void mysqlErrorWithOracle( boolean delay) throws Exception {
        this.insertOracle();
        this.insertMysqlError();
    }

    @Override
    public void mysqlWithOracleError( boolean delay) throws Exception {
        this.insertMysql();
        this.insertOracleError();
    }

    @Override
    public void mysqlWithOracle(boolean delay) throws Exception {
        this.insertMysql();
        this.delay(delay);
        this.insertOracle();
        /*
        System.out.println("模拟睡2分钟，开始");
        int i = 0;
        while(i++ < 12){
            TestOne one = helloDao.findOne("-702336073");
            System.out.println("第" + i + "次查询=" + one);
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("模拟睡2分钟，结束");
        */

    }

    @Override
    public void jtErrorWithMysql(boolean delay) throws Exception {
        this.insertMysql();
        this.insertJdbcTemplateError();
    }

    @Override
    public void jtErrorWithOracle(boolean delay) throws Exception {
        this.insertOracle();
        this.insertJdbcTemplateError();
    }

    public void jt(boolean delay) throws Exception {
        delay(delay);
        this.insertJdbcTemplate();
    }
    public void mysql(boolean delay) throws Exception{
        delay(delay);
        this.insertMysql();
    }
    private void delay(boolean delay) throws Exception{
        if(delay){
            try{
                System.out.println("睡眠2分钟开始：");
                Thread.sleep(1000*60*2);
                System.out.println("睡眠2分钟结束。");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

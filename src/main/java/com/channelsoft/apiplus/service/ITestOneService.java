package com.channelsoft.apiplus.service;

import com.channelsoft.apiplus.entity.oracle.Test2;
import com.channelsoft.apiplus.entity.mysql.TestOne;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017-4-25.
 */

public interface ITestOneService {
    void insert3(boolean delay) throws Exception;
    void insert3Error(boolean delay) throws Exception;
    void jtAndMysql(boolean delay) throws Exception;
    void jtAndMysqlError(boolean delay) throws Exception;
    void jtAndOracle(boolean delay) throws Exception;
    void jt(boolean delay) throws Exception;
    void mysql(boolean delay) throws Exception;
    void oracle(boolean delay) throws Exception;
    void jtAndOracleError(boolean delay) throws Exception;
    void mysqlErrorWithOracle(boolean delay) throws Exception;
    void mysqlWithOracleError(boolean delay) throws Exception;
    void mysqlWithOracle(boolean delay) throws Exception;
    void jtErrorWithMysql(boolean delay) throws Exception;
    void jtErrorWithOracle(boolean delay) throws Exception;

}

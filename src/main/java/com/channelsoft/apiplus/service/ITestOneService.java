package com.channelsoft.apiplus.service;

import com.channelsoft.apiplus.entity.oracle.Test2;
import com.channelsoft.apiplus.entity.mysql.TestOne;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017-4-25.
 */

public interface ITestOneService {
    void insert3() throws Exception;
    void insert3Error() throws Exception;
    void jtAndMysql() throws Exception;
    void jtAndMysqlError() throws Exception;
    void jtAndOracle() throws Exception;
    void jtAndOracleError() throws Exception;
    void mysqlErrorWithOracle() throws Exception;
    void mysqlWithOracleError() throws Exception;
    void mysqlWithOracle() throws Exception;
    void jtErrorWithMysql() throws Exception;
    void jtErrorWithOracle() throws Exception;
    void insertJt() throws Exception;
}

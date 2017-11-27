package com.example.ebean;

import com.example.ebean.modules.oneToManyTest.entity.Customer;
import com.example.ebean.result.MyPagedList;
import com.example.ebean.test.BaseApiTest;
import com.example.ebean.util.JSONUtil;
import com.example.ebean.util.UuidUtil;
import org.junit.Test;

/**
 * @author yuzk
 * @date 2017/11/8
 */
public class UserTest extends BaseApiTest{

    @Test
    public void serviceTest() {

        for(int i = 0;i<10;i++) {
            System.out.println(i+"      :        "+UuidUtil.randomUUID());
        }
    }

    @Test
    public void test() {
        get("user/findlist")
                .send()
                .bodyText();
    }

    @Test
    public void test1() {
        get("cus/insert")
                .param("name","lucy")
                .param("sex",2)
                .send()
                .bodyText();

    }

    @Test
    public void test2() {
        post("/cus/page")
                .postBody(new MyPagedList<Customer>()
                        .setSkip(1)
                        .setPageSize(2))
                .send()
                .bodyText();
    }

    @Test
    public void parseJson(){
        String jsonString = "[{\"name\":\"lucy\",\"password\":\"110\",\"id\":\"1\"},{\"name\":\"nick\",\"password\":\"123\",\"id\":\"2\"},{\"name\":\"marry\",\"password\":\"789\",\"id\":\"3\"}]";
        System.out.println(JSONUtil.format(jsonString));
    }
}

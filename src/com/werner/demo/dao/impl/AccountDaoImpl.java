package com.werner.demo.dao.impl;

import com.werner.demo.bean.User;
import com.werner.demo.dao.AccountDao;
import com.werner.demo.utils.DbConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * BeanListHandler    将查询结果的每一行封装到user对象，然后再存入List集合
 * ColumnListHandler  将查询结果的指定列的数据封装到List集合中
 * MapHandler         将查询结果的第一行数据封装到map结合（key==列名，value==列值）
 * BeanHandler        将查询结果的第一行数据，封装到user对象
 * <p>
 * ①ArrayHandler：     将查询结果的第一行数据，保存到Object数组中
 * ②ArrayListHandler   将查询的结果，每一行先封装到Object数组中，然后将数据存入List集合
 * ⑥MapHandler         将查询结果的第一行数据封装到map结合（key==列名，value==列值）
 * ⑦MapListHandler     将查询结果的每一行封装到map集合（key==列名，value==列值），再将map集合存入List集合
 * ⑧BeanMapHandler     将查询结果的每一行数据，封装到User对象，再存入mao集合中（key==列名，value==列值）
 * ⑨KeyedHandler     将查询的结果的每一行数据，封装到map1（key==列名，value==列值 ），然后将map1集合（有多个）存入map2集合（只有一个）
 * ⑩ScalarHandler     封装类似count、avg、max、min、sum......函数的执行结果
 */
public class AccountDaoImpl implements AccountDao {

    @Override
    public User findUser(String name) {
        String sql = "select * from  tb_user   where  tusername = ? ";
        User user = null;
        try {
            user = DbConnection.getInstance()
                    .getQueryRunner()
                    .query(sql, new BeanHandler<User>(User.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }



    public int addUser(String name,String password){
        int update = 0;
        User user = findUser(name);
        if(user == null){
            String sql = "Insert into TB_USER(TUID,TUSERNAME,TPASSWORD) values(QUID.nextval,'"+name+"','"+password+"')";

            try {
                update = DbConnection.getInstance().getQueryRunner().update(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        else{
            update = 0;
        }
        return update;


    }

}

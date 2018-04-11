package cn.zhsit.daos;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public abstract class BaseDao {



    public Date current = new Date();

    public abstract void addAll() throws Exception;
}

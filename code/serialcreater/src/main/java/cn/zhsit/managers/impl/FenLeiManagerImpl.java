package cn.zhsit.managers.impl;

import cn.zhsit.managers.FenLeiManager;
import org.springframework.stereotype.Repository;

@Repository
public class FenLeiManagerImpl implements FenLeiManager {

    @Override
    public String caiTuan() {
        return "caituan23";
    }
}

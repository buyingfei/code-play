package com.buyf.activiti;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

public class MysqlTypeConvertCustom extends MySqlTypeConvert implements ITypeConvert {
    @Override
    public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
        String t = fieldType.toLowerCase();
        if (t.contains("tinyint")) {
            return DbColumnType.INTEGER;
        }
        return super.processTypeConvert(config, fieldType);

    }
}

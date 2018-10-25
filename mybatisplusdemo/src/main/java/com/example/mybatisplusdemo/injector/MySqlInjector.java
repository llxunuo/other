package com.example.mybatisplusdemo.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MySqlInjector extends AutoSqlInjector {

    /**
     *
     * @param builderAssistant   mapper对应信息(与xml相关)
     * @param mapperClass   mapper接口信息
     * @param modelClass    实体类对应信息
     * @param table     表信息
     */
    @Override
    public void injectSql(MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
                       Class<?> modelClass, TableInfo table) {
        /* 添加一个自定义方法 */
        selectUser(mapperClass, modelClass, table);
    }

    public void selectUser(Class<?> mapperClass, Class<?> modelClass, TableInfo table) {

        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "select * from " + table.getTableName();

        /* mapper 接口方法名一致 */
        String method = "selectAllUser";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        this.addSelectMappedStatement(mapperClass, method, sqlSource, modelClass, table);
    }

}

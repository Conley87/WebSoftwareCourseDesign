package cn.hnie.service;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * mybatis用来获取Druid的数据源
 */
public class DruidDataSourceFactory implements DataSourceFactory {
    private static DruidDataSource druid;
    private Properties properties;

    @Override
    public void setProperties(Properties props) {
        this.properties = props;
    }

    @Override
    public DataSource getDataSource() {
        druid = new DruidDataSource();
        druid.setUrl(properties.getProperty("url"));
        druid.setUsername(properties.getProperty("username"));
        druid.setPassword(properties.getProperty("password"));
        druid.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
        druid.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
        druid.setMinIdle(Integer.parseInt(properties.getProperty("minIdle")));
        return druid;
    }

    public static void close() {
        druid.close();
    }
}

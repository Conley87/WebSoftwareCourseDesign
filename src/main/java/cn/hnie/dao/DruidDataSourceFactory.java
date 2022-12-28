package cn.hnie.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DruidDataSourceFactory implements DataSourceFactory {
    private Properties properties;
    @Override
    public void setProperties(Properties props) {
        this.properties=props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druid=new DruidDataSource();
        druid.setUrl(properties.getProperty("url"));
        druid.setUsername(properties.getProperty("username"));
        druid.setPassword(properties.getProperty("password"));
        druid.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
        druid.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
        druid.setMinIdle(Integer.parseInt(properties.getProperty("minIdle")));
        return druid;
    }
}

package com.zgjt.yqsl.multiple;

import com.zgjt.yqsl.handler.DataSourceContextHander;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHander.getDataSource();
    }
}

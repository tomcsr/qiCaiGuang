package com.txz.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.txz.Bean.cityBean;
import com.txz.dao.CityDao;
import com.txz.utils.JDBCUtil;

public class CityDaoImpl implements CityDao {

	@Override
	public List<cityBean> findCityByPid(int pid) throws SQLException {
		 QueryRunner   qr=new QueryRunner(JDBCUtil.getDataSource());
		 return qr.query("select * from citys where pid=?", new BeanListHandler<cityBean>(cityBean.class),pid);	 
	}

}

package com.txz.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.txz.Bean.wordBean;
import com.txz.dao.WordDao;
import com.txz.utils.JDBCUtil;

public class WordDaoImpl implements WordDao {

	@Override
	public List<wordBean> findWord(String word) throws SQLException {
		 QueryRunner qr= new QueryRunner(JDBCUtil.getDataSource());
		 return	 qr.query("select word from words where word like ?" , new BeanListHandler<wordBean>(wordBean.class), word+"%");
		 
	}

 
}

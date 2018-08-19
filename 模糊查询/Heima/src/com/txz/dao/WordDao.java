package com.txz.dao;

import java.sql.SQLException;
import java.util.List;

import com.txz.Bean.wordBean;

public interface WordDao {
 
	 List<wordBean> findWord(String word) throws SQLException;
}

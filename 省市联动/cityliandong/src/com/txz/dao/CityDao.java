package com.txz.dao;

import java.sql.SQLException;
import java.util.List;

import com.txz.Bean.cityBean;

public interface CityDao {
 
	/**
	 * 通过pid省份id查找关联城市
	 * @param pid
	 * @return 城市集合
	 */
	List<cityBean>  findCityByPid(int pid) throws SQLException;
}

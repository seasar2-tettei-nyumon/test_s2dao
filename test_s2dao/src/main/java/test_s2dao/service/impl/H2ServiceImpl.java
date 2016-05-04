package test_s2dao.service.impl;


import javax.annotation.Resource;

import org.seasar.framework.log.Logger;

import test_s2dao.service.H2Service;

import test_s2dao.dao.H2tableDao;
import test_s2dao.entity.H2TableBean;

public class H2ServiceImpl implements H2Service {
	
	@Resource
	private H2tableDao h2tableDao;
	
	//public Logger log = org.seasar.framework.log.Logger.getLogger(this.getClass());//●これってなんなんだろう。
	
	public H2TableBean settei(Integer id) {
		H2TableBean bean = h2tableDao.selectById(id);
		return bean;
	}
	
	public int setteiMId(String a) {
		return 1;
	}
}

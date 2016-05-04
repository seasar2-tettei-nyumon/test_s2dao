package test_s2dao.dao;

import org.seasar.dao.annotation.tiger.Arguments;
import org.seasar.dao.annotation.tiger.S2Dao;
import test_s2dao.entity.H2TableBean;

@S2Dao(bean=H2TableBean.class)//２．４の書き方
public interface H2tableDao {

	//DAOとEntityの紐付け
	//public static final Class<H2TableBean> BEAN = H2TableBean.class;	//２．３の書き方
	//public String selectById_ARGS = "id";								//２．３の書き方
	
	@Arguments("id")//２．４の書き方
	public H2TableBean selectById(Integer id);
}

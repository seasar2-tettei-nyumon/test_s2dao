package test_s2dao.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import test_s2dao.entity.H2TableBean;
import test_s2dao.service.H2Service;


public class Main2Test {
	
	@Resource
	private H2Service h2Service;
	
	@Before
	public void setUp() throws Exception {
		SingletonS2ContainerFactory.init();								//「app.dicon」を読み込む。●これを省略できる方法が知りたい。Webアプリは自動的に呼び出すらしいが。
		h2Service  = SingletonS2Container.getComponent("h2Service");	//Smart deployしたときの名前がこれらしい。●コンソールに自動登録したときに名前が出ているので参考にするように。
	}

	@Test
	public void daoのselectのテストの場合() throws Exception {
		//========================
		// SetUp - 初期化
		//========================
		
		//========================
		// Exercise - テストの実行
		//========================
		H2TableBean actual = h2Service.settei(1);//●前回はここでたくさん引数を渡すことになってしまっていた。今回は、インジェクションの知識をつけたので、それを解消するのを目的とする。
		//========================
		// Verify - 検証
		//========================
		assertThat(actual.getText() ,is("テストポスグレ"));
	}
}

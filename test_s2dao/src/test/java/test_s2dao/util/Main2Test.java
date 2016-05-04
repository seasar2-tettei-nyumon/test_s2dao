package test_s2dao.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import test_s2dao.entity.H2TableBean;
import test_s2dao.service.H2Service;
import test_s2dao.service.impl.H2ServiceImpl;


public class Main2Test {
	
	@Resource
	private H2Service h2Service;
	
	@Before
	public void setUp() throws Exception {
		SingletonS2ContainerFactory.init();								//「app.dicon」を読み込む。●これを省略できる方法が知りたい。Webアプリは自動的に呼び出すらしいが。
		h2Service  = SingletonS2Container.getComponent("h2Service");	//Smart deployしたときの名前がこれらしい。●コンソールに自動登録したときに名前が出ているので参考にするように。
	}

	//@Ignore
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
	
	//●すごくmokurokuのミニマルな状況に近づけることに成功した。すごく見やすくてビックリしている。何が起こっているのかだんだんわかってきた。
	@Ignore("mokurokuのやりかた。はじめにぶつかった状態。失敗するので。")
	@Test
	public void mokurokuに近づけたテストの場合() throws Exception {
		//========================
		// SetUp - 初期化
		//========================
		H2ServiceImpl sut = new H2ServiceImpl();//●クラスを直接newしちゃっていた。いかん。
		//========================
		// Exercise - テストの実行
		//========================
		H2TableBean actual = sut.privatetest(1);//●前回はここでたくさん引数を渡すことになってしまっていた。今回は、インジェクションの知識をつけたので、それを解消するのを目的とする。
		//========================
		// Verify - 検証
		//========================
		assertThat(actual.getText() ,is("テストポスグレ"));
	}
	
	//@Ignore("mokurokuのやりかた。排除した状態。")
	@Test
	public void mokurokuに近づけたテストの場合_排除した_現在mokurokuはこの状態() throws Exception {
		//========================
		// SetUp - 初期化
		//========================
		H2ServiceImpl sut = new H2ServiceImpl();//●クラスを直接newしちゃっていた。いかん。
		H2TableBean   a   = new H2TableBean();
		a.setId(1);
		a.setText("テストだよ");
		//========================
		// Exercise - テストの実行
		//========================
		H2TableBean actual = sut.privatetest2(a);//●前回はここでたくさん引数を渡すことになってしまっていた。今回は、インジェクションの知識をつけたので、それを解消するのを目的とする。
		//========================
		// Verify - 検証
		//========================
		assertThat(actual.getText() ,is("テストだよ"));
	}
	
	//●つまりインジェクションが出来ていれば、idとかキーの値をやればいいのだが、newしてしまったら、フィールドのdaoとかが使えないので、事前に準備しなければいけない状況ということ。
	
}

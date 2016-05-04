package test_s2dao.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.experimental.runners.Enclosed;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import test_s2dao.logic.IMessageProviderLogic;


@RunWith(Enclosed.class)
public class MainTest extends Main {

	//●謎。片付けーツールに一番近い環境はこれだが、initの部分がなかった。こっちはinitないと読み込まないのでしょうがなく書いているけど、どうやればいい？
	//それがわかれば、だいぶ近づく。160503
	
	@Resource
	private static IMessageProviderLogic messageProvider;//●ここの命名がProviderとか付いて、違うから、自動バインディングできないのかな？
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		
		//●このときに、diconの読込先をテスト用のやつにするとかすれば柔軟に対応できる感じがする。
		//●こうやると初期化時に読み込むdiconを変更することができる（多分initメソッドを実行するとこの設定が実行されるんだろう）
		//SingletonS2ContainerFactory.setConfigPath("app2.dicon");
		//●これでもテストクラスで、フィールドに入るにははいる。でもこれすらやらないって方法が知りたいんだよな。片付けツールがなぜかそうなっている。どうやって？でもこれでもできなくはないからOKかな。
		SingletonS2ContainerFactory.init();//「app.dicon」を読み込む。
		messageProvider = SingletonS2Container.getComponent(IMessageProviderLogic.class);//インタフェースの型を指定している。
	}
	
	@RunWith(Enclosed.class)
	public static class テスト１ {
		
		@RunWith(Enclosed.class)
		public static class テスト１１ {
			
			public static class テストだ１ {
				
				@Test
				public void testMain() throws Exception{
					assertThat(messageProvider.getMessage(),is("Hello, World!"));
				}
			}
		}
		
		@RunWith(Enclosed.class)
		public static class テスト１２ {
			
			public static class テストだ２ {
				
				@Test
				public void testMain() throws Exception{
					assertThat(messageProvider.getMessage(),is("Hello, World!"));
				}
			}
		}
	}
	
	@RunWith(Enclosed.class)
	public static class テスト２ {
		
		@RunWith(Enclosed.class)
		public static class テスト２１ {
			
			public static class テストだ１ {
				
				@Test
				public void testMain() throws Exception{
					assertThat(messageProvider.getMessage(),is("Hello, World!"));
				}
			}
		}
		
		@RunWith(Enclosed.class)
		public static class テスト２２ {
			
			public static class テストだ２ {
				
				@Test
				public void testMain() throws Exception{
					assertThat(messageProvider.getMessage(),is("Hello, World!"));
				}
			}
		}
	}

}

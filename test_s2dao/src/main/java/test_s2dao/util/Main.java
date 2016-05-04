package test_s2dao.util;

import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import test_s2dao.logic.IMessageProviderLogic;

public class Main {

	/**
	 * このクラスはもう変更を行わない！試したいことがあったら新しいクラスを作ること。
	 * @param args
	 */
	public static void main(String[] args) {
		
		//●こうやると初期化時に読み込むdiconを変更することができる（多分initメソッドを実行するとこの設定が実行されるんだろう）
		//SingletonS2ContainerFactory.setConfigPath("app2.dicon");
		
		SingletonS2ContainerFactory.init();//「app.dicon」を読み込む。●これを省略できる方法が知りたい。Webアプリは自動的に呼び出すらしいが。
		IMessageProviderLogic messageProvider = SingletonS2Container.getComponent(IMessageProviderLogic.class);//インタフェースの型を指定している。
		System.out.println(messageProvider.getMessage());
		SingletonS2ContainerFactory.destroy();
	}
}

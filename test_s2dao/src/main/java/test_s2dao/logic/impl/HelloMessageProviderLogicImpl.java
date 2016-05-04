package test_s2dao.logic.impl;

import javax.annotation.Resource;

import test_s2dao.logic.IMessageProviderLogic;
import test_s2dao.logic.IMessageTargetLogic;

public class HelloMessageProviderLogicImpl implements IMessageProviderLogic{

	@Resource//このアノテーション付けたら、セッターインジェクションがなくても（実装のため存在は必要だけど）nullにならないのを確認できた。●このアノテーションをコメントアウトすると、ヌルポが出るのも確認できた。
	private IMessageTargetLogic messageTarget;
	//public IMessageTargetLogic messageTarget;//●2.4.17以降は、@Resourceアノテーションをやらなくても、publicでインタフェースであったら自動バインディングされる。実際できたのを確認した。

//	@Override//●こいつは別に消しても（そのときはインタフェースのほうも消すことだ）、フィールドにインジェクションされる。
//	public void setMessageTarget(IMessageTargetUtil messageTarget) {
//	//	this.messageTarget = messageTarget;
//	}

	public String getMessage() {
		return "Hello, " + messageTarget.getName() + "!";
	}
}

package test_s2dao.logic.impl;

import test_s2dao.logic.IMessageTargetLogic;

public class SeasarMessageTargetLogicImpl //implements IMessageTargetLogic//●Smart deployをやるとき、インタフェースを複数の実装クラスがあったら「TooMany」が出る。ので実装をやめたらちゃんとSmart deployで動いた。
{

	public String getName() {
		return "Seasar2";
	}
}

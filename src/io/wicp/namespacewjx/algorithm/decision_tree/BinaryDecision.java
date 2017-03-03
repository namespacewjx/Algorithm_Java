package io.wicp.namespacewjx.algorithm.decision_tree;

/**
 * Created by 吴俊贤 on 2016/10/24.
 */
public class BinaryDecision implements Decision {
	private Object[] op1;
	private Object[] op2;

	public BinaryDecision(Object[] option1, Object[] option2) {
		op1 = option1;
		op2 = option2;
	}

	@Override
	public int makeDicision(Object value) {
		for (int i = 0; i < op1.length; i++) {
			if (value.equals(op1[i])) {
				return 0;
			}
		}
		for (int i = 0; i < op2.length; i++) {
			if (value.equals(op2[i])) {
				return 1;
			}
		}
		return NO_RESULT;
	}
}

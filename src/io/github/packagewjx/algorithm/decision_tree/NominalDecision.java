package io.github.packagewjx.algorithm.decision_tree;

/**
 * Created by 吴俊贤 on 2016/10/24.
 */
public class NominalDecision implements Decision{
	private String[] options;

	public NominalDecision(String[] options) {
		this.options = options;
	}


	@Override
	public int makeDicision(Object value) {
		for (int i = 0; i < options.length; i++) {
			if (options[i].equals(value))
				return i;
		}
		return NO_RESULT;
	}
}

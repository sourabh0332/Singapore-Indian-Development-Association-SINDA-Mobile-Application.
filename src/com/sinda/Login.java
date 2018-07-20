package com.sinda;

import java.util.HashMap;
import java.util.Map;

public class Login {
	Map<String, Integer> ud = new HashMap<String, Integer>();
	Map<String, String> up = new HashMap<String, String>();

	public Map<String, Integer> getUd() {
		return ud;
	}

	public void setUd(Map<String, Integer> ud) {
		this.ud = ud;
	}

	public Map<String, String> getUp() {
		return up;
	}

	public void setUp(Map<String, String> up) {
		this.up = up;
	}

	Login() {
		up.put("prateek", "agrawal");
		ud.put("prateek", 2);
		up.put("supra", "joshi");
		ud.put("supra", 1);
		up.put("sourabh", "parekh");
		ud.put("sourabh", 1);
		up.put("alisha", "ahmad");
		ud.put("alisha", 1);

	}
}

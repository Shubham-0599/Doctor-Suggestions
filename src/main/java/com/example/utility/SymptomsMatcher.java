package com.example.utility;

import java.util.HashMap;
import java.util.Map;

public class SymptomsMatcher {
	public static Map<String, String> map=new HashMap<>();
	static {
		map.put("ARTHRITIS","ORTHOPEDIC");
		map.put("BACKPAIN","ORTHOPEDIC");
		map.put("TISSUE INJURY","ORTHOPEDIC");
		map.put("DYSMENORREHA","GYNECOLOGY");
		map.put("SKIN INFECTION","DERMATOLOGY");
		map.put("SKIN BURN","DERMATOLOGY");
		map.put("EAR PAIN","ENT");
	}

}

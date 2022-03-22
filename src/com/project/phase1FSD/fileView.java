package com.project.phase1FSD;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class fileView {

		static String dir= "Database/";
		public static void ascendingOrder() {
			
			File[] files = new File(dir).listFiles();
			Set<String> a = new TreeSet<>();
			for(File file : files) {
				if (!file.isFile()) {
					continue ;
				}
				a.add(file.getName());
			}
			a.forEach(i->System.out.println(i));
		}
	}
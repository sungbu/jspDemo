package net.hnjdzy.util;

import java.util.ArrayList;
import java.util.List;

import net.hnjdzy.entity.Project;

public class Test {

	public static void main(String[] args) {
		List<Project> list = new ArrayList<Project>();
		
		for(int i=1;i<=98;i++) {
			Project p = new Project();
			p.setProjectId(i+"");
			p.setProjectName("»úµç"+i);
			
			list.add(p);
		}
		
		

	}

}

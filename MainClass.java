package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	public static void filterWithoutUsingStream() {
		
		//Initialize a list
		List<String> list=Arrays.asList("knowledge","little","kingdom","knock","laptop");
		
		//List for store result
		List<String> resultList=new ArrayList<String>();
		
		//loop for iterate list
		for(String element:list) {
			if(Character.toString(element.charAt(0)).equals("k")) {
				resultList.add(element);
			}
		}
		System.out.println("Value of resultList:"+resultList);
	}
	
	public static void filterUsingStream() {
		
		//Initialize a list
		List<String> list=Arrays.asList("knowledge","little","kingdom","knock","laptop");
		
		//using stream and lambda filter the array element which String start with k
		List<String> kList=list.stream().filter(n->n.startsWith("k")).collect(Collectors.toList());
		
		System.out.println("Word Start with K:"+kList);
	}
	
	public static void streamCollect() {
		
		List<Student> studentList=Arrays.asList(new Student(01,"student1",100),new Student(02,"student2",200),new Student(03,"student3",100));
		List<String> list=studentList.stream().filter(n->n.getMarks()==100).map(n->n.getName()).collect(Collectors.toList());
		
		System.out.println("Filtered List who secured 100 mark:"+list);
		
	}
	
	public static void streamForEachOperation() {
		
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		List<Integer> updateList=new ArrayList<Integer>();
		list.stream().forEach(n->{
			updateList.add(n+10);
		});
		
		System.out.println("After addition of 10 using forEach,result list:"+updateList);
	}
	
	public static void streamMapOperation() {
		
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		List<Integer> updateList=list.stream().map(n->n+10).collect(Collectors.toList());
		
		System.out.println("After addition of 10 using map,result list:"+updateList);
	}
	
	public static void streamDistinct() {
		
		List<Integer> list=Arrays.asList(2,5,3,4,2,1,8,1,6,3,5,4);
		
		List<Integer> distinctIntList = list.stream().distinct().collect(Collectors.toList());
		
		System.out.println("Distinct Array:"+distinctIntList);
	}
	
	public static void streamSorted() {
		
		List<String> list= Arrays.asList("yogi","prem","ashish","sudhansu","akash","bijoy");
		
		List<String> sortedListAsc = list.stream().sorted().collect(Collectors.toList());
		
		List<String> sortedListDesc = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); 
		
		System.out.println("Sorted resultList asc:::"+sortedListAsc);
		
		System.out.println("Sort result list desc:::"+sortedListDesc);
	}
	
	public static void streamMatch() {
		
		List<String> list = Arrays.asList("Ashish","Prem","Akash","Bijoy","Raman");
		
		boolean anymatch = list.stream().anyMatch(l -> l.startsWith("A"));
		
		boolean allmatch = list.stream().allMatch(l -> l.startsWith("A"));
		
		boolean noneMatch = list.stream().noneMatch(l -> l.startsWith("A"));
		
		System.out.println("Any match:"+anymatch);
		
		System.out.println("All Match:"+allmatch);
		
		System.out.println("None Match:"+noneMatch);
		
	}
	
	public static void streamCount() {
		List<String> list = Arrays.asList("Ashish","Prem","Akash","Bijoy","Raman");
		
		long count = list.stream().filter(n -> n.startsWith("A")).count();
		
		System.out.println("Count:"+count);
	}
	
	public static void streamReduce() {
		
		List<String> list = Arrays.asList("Ashish","Prem","Akash","Bijoy","Raman");
		
		String result= list.stream().reduce((m,n) -> m+"-"+n).get();
		
		System.out.println("Reduce string:"+result);
	}
	
	public static void main(String[] args) {
		
		filterUsingStream();
		filterWithoutUsingStream();
		streamForEachOperation();
		streamMapOperation();
		streamCollect();
		streamDistinct();
		streamSorted();
		streamMatch();
		streamCount();
		streamReduce();
	}
}

//package com.example.demo.threaddemo;
//
//import java.util.*;
//import java.util.concurrent.CountDownLatch;
//
///**
// * 功能描述：
// *
// * @Author: hanlq
// * @Date: 2021/7/12 16:24
// */
//public class SortDemo {
//    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//list.add("M04-002-001");
//list.add("M3-602-001");
//list.add("M104-003-001");
//list.add("M103-002-11");
//list.add("M18-002-001");
//list.add("J01-002-001");
//list.add("A101-052-001");
//        HashMap<String,List<String[]>> hashMap = new HashMap<>();
//for(String s :list){
//    String[] strings = s.split("_");
//
//    String key = strings[0].substring(0,1);
//    String value = strings[0].substring(1);
//    strings[0]=value;
//    if(hashMap.containsKey(key)){
//        hashMap.get(key).add(strings);
//    }else {
//        List<String[]> list1 = new ArrayList<>();
//        list1.add(strings);
//        hashMap.put(key,list1);
//    }
//    for(String id:hashMap.keySet()){
//        if(hashMap.get(id).size()==1){
//            System.out.print(id+hashMap.get(id).get(0));
//        }else {
//            List<String[]> values =hashMap.get(id);
//            if(){}
//        }
//
//    }
//
//
//}
//        hashMap.keySet();
//
//    }
//    private static String[] getvalue(List<String[]> list){
//
//    }
//    class Code{
//        String code;
//        Integer codes
//    }
////
//// output:
//// A101-052-001
//// J01-002-001
//// M3-602-001
//// M04-002-001
//// M18-002-001
//// M103-002-11
//// M104-003-001
//
//
//
//}

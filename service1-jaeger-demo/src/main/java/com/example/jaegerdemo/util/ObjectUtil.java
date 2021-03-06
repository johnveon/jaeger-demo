package com.example.jaegerdemo.util;

/**
 * @description: ObjectUtils打印属性类
 * @author: zhoufengen
 * @create at: 2019-04-01 14:40
 **/
import com.example.jaegerdemo.table.es.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectUtil {



    public enum  GetOrSet{
        set,
        get
    }

    /**
     * 首字母大写
     * @params [name]
     * @return java.lang.String
     * @author zhoufe
     * @date 2018/1/8 18:12
     */
    public static String captureName(String name) {
//  name = name.substring(0, 1).toUpperCase() + name.substring(1);
//  return  name;
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);

    }

    /**
     * 获取属性名数组
     * */
    private static String[] getFiledName(Object o){
        List<Field> retFields = new ArrayList<>();
        getDeclaredField(o, retFields);
        String[] fieldNames=new String[retFields.size()];
        for(int i=0;i < retFields.size();i++){
            //System.out.println(fields[i].getType());
            fieldNames[i]=retFields.get(i).getName();
        }
        return fieldNames;
    }


    /**
     * 循环向上转型, 获取对象的 DeclaredField
     * @param object : 子类对象
     * @param retFields : 父类中的属性名
     * @return 父类中的属性对象
     */
    public static void getDeclaredField(Object object, List<Field> retFields){
        Class<?> clazz = object.getClass() ;
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                if (fields != null && fields.length > 0){
                    retFields.addAll(Arrays.asList(fields));
                }
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return ;
    }



    public static void main(String[] args) {

        printObj();

    }

    private static void printObj() {

        User obj = new User();
        String[] filedNames = getFiledName(obj);
        //printGetOrSetFields(filedNames, "vo", "model", GetOrSet.set);

        printGetOrSetFields(filedNames, "model", "vo", GetOrSet.set);

    }

    private static void printGetOrSetFields(String[] filedNames, String vo, String model, GetOrSet getOrSet) {
        for (String filedName : filedNames) {

            System.out.println(vo + ".set" + upperCaseFirst(filedName) + "(" + model + ".get" + upperCaseFirst(filedName) + "()" + ");");
        }
    }

    private static String upperCaseFirst(String filedName) {
        return (new StringBuilder()).append(Character.toUpperCase(filedName.charAt(0))).append(filedName.substring(1)).toString();
    }

}
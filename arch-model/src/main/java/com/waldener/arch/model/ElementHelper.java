package com.waldener.arch.model;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

/**
 * Created by Waldener on 2019/8/3.
 */
class ElementHelper {
    private List<String> fieldList = new ArrayList<>();

    ElementHelper(Element element) {

    }

    void addFiled(String field){
        fieldList.add(field);
    }

    void addMethod(){

    }

//    private String modifier;
//    private TypeName typeName;
//    private String field;
//    private String methodSet;
//    private String methodGet;
//
//    ElementHelper(Element element) {
//        modifier = element.getModifiers().toArray()[0].toString();
//        typeName = TypeName.get(element.asType());
//        field = element.getSimpleName().toString();
//        String upCaseModifer = toUpperCase(field);
//        if(typeName == TypeName.BOOLEAN){
//            if(field.startsWith("is") && field.length() > 2 && Character.isUpperCase(field.charAt(2))){
//                methodGet = field;
//                methodSet = "set" + field.substring(2);
//            }else {
//                methodGet = "is" + upCaseModifer;
//                methodSet = "set" + upCaseModifer;
//            }
//        }else {
//            methodGet = "get" + upCaseModifer;
//            methodSet = "set" + upCaseModifer;
//        }
//    }
//
//    public String getModifier() {
//        return modifier;
//    }
//
//    public TypeName getTypeName() {
//        return typeName;
//    }
//
//    public String getField() {
//        return field;
//    }
//
//    public String getMethodGet() {
//        return methodGet;
//    }
//
//    public String getMethodSet() {
//
//        return methodSet;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s %s %s %s, %s", modifier, typeName.toString(), field, methodGet, methodSet);
//    }

//    private String toUpperCase(String str){
//        if(str == null || str.isEmpty()){
//            return null;
//        }
//        char first = str.charAt(0);
//        if(Character.isUpperCase(first)){
//            return str;
//        }else {
//            StringBuilder sb = new StringBuilder();
//            sb.append(Character.toUpperCase(first)).append(str.substring(1));
//            return sb.toString();
//        }
//    }
}

package com.buyf.deploy.user.center.api;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * 根据类 注解，自动转化成接口文档
 */
public class ParseClassDtoToApi {

    /**
     * 是否是自引用: 目前自引用类型主要是指 类 包含List 成员属性，并且里面参数是当前类
     *
     * @param cl
     * @return
     */
    public static int checkCurrentClassIsSelfReference(Class cl) {
        boolean tag = false;
        Field[] declaredFields = cl.getDeclaredFields();
        int size = 0;
        Set<Integer> sSize = new HashSet<>();
        for (Field declaredField : declaredFields) {
            if (tag == true) {
                continue;
            }
            if (List.class == declaredField.getType() || ArrayList.class == declaredField.getType()) {
                if (declaredField.getGenericType() instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) declaredField.getGenericType()).getActualTypeArguments();
                    Type actualTypeArgument = actualTypeArguments[0];
                    if (actualTypeArgument.getTypeName() == cl.getName()) {
                        tag = true;
                    }
                }
            }
        }

        for (Field declaredField : declaredFields) {
            if (tag == true) {
                ParamPropertyList annotation = declaredField.getAnnotation(ParamPropertyList.class);
                if (annotation != null) {
                    sSize.add(annotation.paramProperty().length);
                    size = annotation.paramProperty().length;
                }
            }
        }
        if (tag == true && sSize.size() == 1) {
            return size;
        }
        return 0;
    }


    /**
     * 判断自引用类中的自引用字段，主要为了解决 pid- id 之间关系
     *
     * @param declaredField
     * @param cl
     * @return
     */
    public static boolean checkCurrentFieldIsSelfReference(Field declaredField, Class cl) {
        if (declaredField.getGenericType() instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) declaredField.getGenericType()).getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            if (actualTypeArgument.getTypeName() == cl.getName()) {
                return true;
            }
        }
        return false;
    }



    public static List<ParamDescDTO> parseFieldSelfReferenceClass(int selfReferenceSize, Class cl, String pid) throws ClassNotFoundException, NoSuchFieldException {
        List<ParamDescDTO> paramDescDTOList = new ArrayList<>();
        Field selfReferField = null;

        for (int i = 0; i < selfReferenceSize; i++) {
            Field[] declaredFields = cl.getDeclaredFields();
            Map<String, String> fieldPid = new HashMap<>();
            for (Field declaredField : declaredFields) {
                // 字段包含 ParamPropertyList 注解
                ParamPropertyList annotationParamPropertyList = declaredField.getAnnotation(ParamPropertyList.class);
                if (annotationParamPropertyList != null) {
                    ParamProperty[] paramProperties = annotationParamPropertyList.paramProperty();
                    if (fieldPid.get(declaredField.getName()) != null) {
                        ParamDescDTO paramDescDTO = parseParamProperty(paramProperties[i], declaredField.getName(), pid);
                        fieldPid.put(declaredField.getName(), paramDescDTO.getId());
                        paramDescDTOList.add(paramDescDTO);
                    } else {
                        ParamDescDTO paramDescDTO = parseParamProperty(paramProperties[i], declaredField.getName(), pid);
                        fieldPid.put(declaredField.getName(), paramDescDTO.getId());
                        paramDescDTOList.add(paramDescDTO);
                    }
                } else {
                    ParamProperty annotation = declaredField.getAnnotation(ParamProperty.class);
                    if (annotation != null) {
                        // 判断当前字段是否是自引用字段
                        if (checkCurrentFieldIsSelfReference(declaredField, cl)) {
                            selfReferField = declaredField;
                            continue;
                        }
                        ParamDescDTO paramDescDTO = parseParamProperty(declaredField.getAnnotation(ParamProperty.class), declaredField.getName(), pid);
                        // 普通引用类型
                        String referPid = pid;
                        if (annotation != null) {
                            referPid = paramDescDTO.getId();
                            paramDescDTOList.add(paramDescDTO);
                        }
                        Type genericType = declaredField.getType();

                        List<ParamDescDTO> paramDescDTOList1 = parseClassProperty(Class.forName(genericType.getTypeName()), referPid);
                        if (paramDescDTOList1 != null && paramDescDTOList1.size() > 1) {
                            paramDescDTOList.addAll(paramDescDTOList1);
                        }
                    }
                }
            }
            if(selfReferField != null && i != selfReferenceSize-1){
                ParamDescDTO paramDescDTO = parseParamProperty(selfReferField.getAnnotation(ParamProperty.class), selfReferField.getName(), pid);
                paramDescDTOList.add(paramDescDTO);
                pid = paramDescDTO.getId();
            }

        }
        return paramDescDTOList;
    }

    /**
     * 解析通用类
     *
     * @param cl
     * @return
     * @throws NoSuchFieldException
     * @throws ClassNotFoundException
     */
    public static List<ParamDescDTO> parseClassProperty(Class cl, String pid) throws NoSuchFieldException, ClassNotFoundException {
        Integer size = checkCurrentClassIsSelfReference(cl);
        List<ParamDescDTO> paramDescDTOList = new ArrayList<>();
        // 当前类是自引用类
        if (size > 0) {
            // 自引用类
            List<ParamDescDTO> paramDescDTOList1 = parseFieldSelfReferenceClass(size, cl, pid);
            if (paramDescDTOList1 != null && paramDescDTOList1.size() > 1) {
                paramDescDTOList.addAll(paramDescDTOList1);
            }
        } else {
            Field[] declaredFields = cl.getDeclaredFields();
            Class[] baseClass = new Class[]{String.class, Long.class, Integer.class, Boolean.class, Double.class, BigDecimal.class, BigInteger.class, Float.class, Character.class};
            for (Field declaredField : declaredFields) {
                Integer classFieldSelfReferSize = checkCurrentClassIsSelfReference(declaredField.getDeclaringClass());
                if (Arrays.asList(baseClass).contains(declaredField.getGenericType())) {
                    // 基础类型
                    ParamDescDTO paramDescDTO = parseParamProperty(declaredField.getAnnotation(ParamProperty.class), declaredField.getName(), pid);
                    if (paramDescDTO != null) {
                        paramDescDTOList.add(paramDescDTO);
                    }
                }  else {
                    // 普通引用类型
                    ParamProperty annotation = declaredField.getAnnotation(ParamProperty.class);
                    String referPid = pid;
                    if (annotation != null) {
                        ParamDescDTO paramDescDTO = parseParamProperty(declaredField.getAnnotation(ParamProperty.class), declaredField.getName(), pid);
                        referPid = paramDescDTO.getId();
                        paramDescDTOList.add(paramDescDTO);
                    }
                    Type genericType = declaredField.getType();

                    List<ParamDescDTO> paramDescDTOList1 = parseClassProperty(Class.forName(genericType.getTypeName()), referPid);
                    if (paramDescDTOList1 != null && paramDescDTOList1.size() > 1) {
                        paramDescDTOList.addAll(paramDescDTOList1);
                    }
                    return paramDescDTOList1;
                }
            }
        }
        return paramDescDTOList;
    }

    public static ParamDescDTO parseParamProperty(ParamProperty paramProperty, String paramName, String pid) {
        if (paramProperty == null) {
            return null;
        }
        ParamDescDTO paramDescDTO = new ParamDescDTO();
        paramDescDTO.setParamName(paramName);
        paramDescDTO.setPid(pid);
        Random ran1 = new Random();
        paramDescDTO.setId(String.valueOf(System.currentTimeMillis() + ran1.nextInt()));
        paramDescDTO.setParamDesc(paramProperty.paramsName());
        paramDescDTO.setParamType(paramProperty.dataType());
        return paramDescDTO;
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {
        List<ParamDescDTO> paramDescDTOList1 = parseClassProperty(ChildrenDTO.class, "0");
        paramDescDTOList1.forEach(paramDescDTO -> {
            System.out.println(paramDescDTO);
        });
    }
}

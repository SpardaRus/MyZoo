package com.github.spardarus.myzoo.admin;

import java.lang.reflect.Method;

/**
 * The choice of method money
 */
public class ChooseMoney {
    /**
     * Reflective call to a method marked with the annotation, the dependence of its argument.
     * @param em annotation argument
     * @return money
     * @throws Exception
     */
    public int chooseMoney(EMoney em) throws Exception {
        String pack="com.github.spardarus.myzoo.admin.Administrator";
        Class cl=Class.forName(pack);
        Method[] m=cl.getDeclaredMethods();
            for(Method met:m){
                if (met.isAnnotationPresent(GetMoney.class)){
                    if(met.getAnnotation(GetMoney.class).value().equals(em)){
                        return (int) met.invoke(Administrator.getInstance());
                    }
                }
            }
        return 0;
    }
}

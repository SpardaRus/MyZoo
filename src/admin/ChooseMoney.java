package admin;

import java.lang.reflect.Method;

public class ChooseMoney {
    public int chooseMoney(EMoney em) throws Exception {
        String pack="admin.Administrator";
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

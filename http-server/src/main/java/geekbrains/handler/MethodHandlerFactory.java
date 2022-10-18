package geekbrains.handler;


import geekbrains.config.Config;
import geekbrains.service.ResponseSerializer;
import geekbrains.service.SocketService;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

public class MethodHandlerFactory {

    static Reflections reflections = new Reflections("geekbrains.handler");

    public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, Config config) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HashMap<Integer, Class> map = createMap();
        Class[] param = {MethodHandler.class, SocketService.class, ResponseSerializer.class, Config.class};
        int order = getMaxOrder();
        Class clazz = map.get(order);
        PutMethodHandler putMethodHandler = (PutMethodHandler)clazz.getConstructor(param).newInstance(null,  socketService, responseSerializer, config);
        order = order - 1;
        Class cl = map.get(order);
        PostMethodHandler postMethodHandler = (PostMethodHandler)cl.getConstructor(param).newInstance(putMethodHandler, socketService, responseSerializer, config);
        return new GetMethodHandler(postMethodHandler, socketService, responseSerializer, config);
    }






    static Set<Class<?>> getSetClassWithAnnotated() {
        return  reflections.getTypesAnnotatedWith(Handler.class);
    }

    static HashMap<Integer, Class> createMap(){
        Set<Class<?>> setClassWithAnnotated = getSetClassWithAnnotated();
        HashMap<Integer, Class> methodsHandlerMap = new HashMap<>();
        for (Class<?> c : setClassWithAnnotated) {
            Handler annotation = c.getAnnotation(Handler.class);
            int order = annotation.order();
            methodsHandlerMap.put(order, c);
        }return methodsHandlerMap;
    }

    static int getMaxOrder(){
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Handler.class);
        int maxOrder = 0;
        for (Class clazz : annotated) {
            Handler annotation = (Handler) clazz.getAnnotation(Handler.class);
            int order = annotation.order();
            if(maxOrder <= order) maxOrder = order;
        }
        return maxOrder;
    }

}

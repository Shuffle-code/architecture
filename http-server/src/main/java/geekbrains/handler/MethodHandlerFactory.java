package geekbrains.handler;


import geekbrains.config.Config;
import geekbrains.service.ResponseSerializer;
import geekbrains.service.SocketService;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class MethodHandlerFactory {
    private static final String HANDLERS_PACKAGE = "geekbrains.handler";

    static Reflections reflections = new Reflections(HANDLERS_PACKAGE);

    public static MethodHandler create(SocketService socketService,
                                       ResponseSerializer responseSerializer,
                                       Config config) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        List<MethodHandler> methodHandlerList = createList(socketService, responseSerializer, config);
       MethodHandler methodHandler = null;
        for (int i = methodHandlerList.size()-1; i >= 0 ; i--) {
            methodHandler = methodHandlerList.get(i);
            System.out.println(methodHandler + " _ " + i);
        }
        return methodHandler;
    }
    static List<Class<?>> getSetClassWithAnnotated() {
        return new ArrayList<>(reflections.getTypesAnnotatedWith(Handler.class));
    }
    static List<MethodHandler> createList(SocketService socketService, ResponseSerializer responseSerializer, Config config) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Class<?>> setClassWithAnnotated = getSetClassWithAnnotated();
        setClassWithAnnotated.sort(Comparator.comparingInt(MethodHandlerFactory::getOrder));
        List<MethodHandler> methodsHandlerList = new ArrayList<>();
        MethodHandler prev = null;
        for (Class<?> clazz : setClassWithAnnotated) {
            Constructor<?> constructor = clazz.getConstructor(String.class, MethodHandler.class, SocketService.class, ResponseSerializer.class, Config.class);
            prev = (MethodHandler) constructor.newInstance(getMethod(clazz), prev, socketService, responseSerializer, config);
            methodsHandlerList.add(prev);
        }return methodsHandlerList;
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
    public static MethodHandler createWhitLesson(SocketService socketService, ResponseSerializer responseSerializer, Config config) {
//        Reflections reflections = new Reflections(HANDLERS_PACKAGE);
        List<Class<?>> classes = new ArrayList<>(reflections.getTypesAnnotatedWith(Handler.class));

        MethodHandler prev = null;
        classes.sort(Comparator.comparingInt(MethodHandlerFactory::getOrder).reversed());
        try {
            for (Class<?> clazz : classes) {
                Constructor<?> constructor = clazz.getConstructor(MethodHandler.class, SocketService.class, ResponseSerializer.class, Config.class);
                prev = (MethodHandler) constructor.newInstance(prev, socketService, responseSerializer, config);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return prev;
    }

    private static int getOrder(Class<?> clazz) {
        return clazz.getAnnotation(Handler.class).order();
    }
    private static String getMethod(Class<?> clazz) {
        return clazz.getAnnotation(Handler.class).method();
    }
}



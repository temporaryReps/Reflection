import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Descriptor {

    public void discribe(Class clazz) {
        Package aPackage = clazz.getPackage();
        System.out.printf("package %s;%n", aPackage.getName());

        int modifiers = clazz.getModifiers(); // 101010101
//        Modifier
//        modifiers = 1; // 00001
//        modifiers = 3; // 00011
//        modifiers = 5; // 00101
//        System.out.println(Modifier.isPublic(modifiers));
//        System.out.println(Modifier.isPrivate(modifiers));
//        System.out.println(Modifier.toString(modifiers));

        System.out.printf("%s %s %s", Modifier.toString(modifiers),
                clazz.isInterface() ? "interface" : "class", clazz.getSimpleName());

        System.out.printf(" extends %s", clazz.getSuperclass().getSimpleName());

        System.out.printf(" implements ");
        Class<?>[] interfaces = clazz.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            Class<?> anInterface = interfaces[i];
            System.out.print(i == 0 ? "" : ", ");
            System.out.print(anInterface.getSimpleName());
        }
        System.out.println(" {");

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.printf("\t%s %s %s;%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
        }

        System.out.println();

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.printf("\t%s %s(%s) {}%n",
                    Modifier.toString(constructor.getModifiers()),
                    clazz.getSimpleName(),
                    getParameters(constructor.getParameterTypes()));
        }

        System.out.println();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.printf("\t%s %s(%s) {}%n",
                    Modifier.toString(method.getModifiers()),
                    clazz.getSimpleName(),
                    getParameters(method.getParameterTypes()));
        }

        System.out.println("}");
    }

    private static String getParameters(Class<?>[] parametersType) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parametersType.length; i++) {
            Class<?> parameter = parametersType[i];
            result.append(i == 0 ? "" : ", ")
                    .append(parameter.getSimpleName())
                    .append(" p")
                    .append(i);
        }
        return result.toString();
    }
}

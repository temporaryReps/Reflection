import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Descriptor {
    private Class clazz;

    /**
     * describe class including fields, constructors and methods
     *
     * @param clazz which will be described
     */
    public void describe(Class clazz) {
        this.clazz = clazz;

        showPackage();
        showModifiers();
        showSuperclasses();
        showInterfaces();
        showFields();
        showConstructors();
        showMethods();
    }

    private void showPackage() {
        Package aPackage = clazz.getPackage();
        System.out.printf("package %s;%n", aPackage.getName());
    }

    private void showModifiers() {
        int modifiers = clazz.getModifiers();

        System.out.printf("%s %s %s", Modifier.toString(modifiers),
                clazz.isInterface() ? "interface" : "class", clazz.getSimpleName());
    }

    private void showSuperclasses() {
        Class superclass = clazz.getSuperclass();

        if (!superclass.equals(Object.class)) {
            System.out.printf(" extends %s", superclass.getSimpleName());
        }
    }

    private void showInterfaces() {
        Class<?>[] interfaces = clazz.getInterfaces();

        if (interfaces.length != 0) {
            System.out.printf(" implements ");
            for (int i = 0; i < interfaces.length; i++) {
                Class<?> anInterface = interfaces[i];
                System.out.print(i == 0 ? "" : ", ");
                System.out.print(anInterface.getSimpleName());
            }
        }
    }

    private void showFields() {
        System.out.println(" {");

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.printf("\t%s %s %s;%n", Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(), field.getName());
        }

        System.out.println();
    }

    private void showConstructors() {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.printf("\t%s %s(%s) {}%n",
                    Modifier.toString(constructor.getModifiers()),
                    clazz.getSimpleName(),
                    getParameters(constructor.getParameterTypes()));
        }

        System.out.println();
    }

    private void showMethods() {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.printf("\t%s %s %s(%s) {}%n",
                    Modifier.toString(method.getModifiers()),
                    method.getReturnType(),
                    method.getName(),
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

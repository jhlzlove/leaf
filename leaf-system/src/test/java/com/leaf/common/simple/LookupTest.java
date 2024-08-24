package com.leaf.common.simple;

import org.junit.jupiter.api.Test;

import java.lang.invoke.*;
import java.lang.reflect.Field;
import java.util.function.ToIntFunction;


/**
 * @author jhlz
 */
public class LookupTest {
    /**
     * test: lookUp example
     */
    @Test
    public void testlookUp() {
        Class<MethodHandles.Lookup> lookupClass = MethodHandles.Lookup.class;
        try {
            Field implLookup = lookupClass.getDeclaredField("IMPL_LOOKUP");
            implLookup.setAccessible(true);
            MethodHandles.Lookup lookup = ((MethodHandles.Lookup) implLookup.get(null));

            MethodHandle coder = lookup.in(String.class)
                    .findSpecial(String.class, "coder", MethodType.methodType(byte.class), String.class);


            CallSite callSite = LambdaMetafactory.metafactory(
                    lookup, "applyAsInt", MethodType.methodType(ToIntFunction.class),
                    MethodType.methodType(int.class, Object.class)
                    , coder, MethodType.methodType(byte.class, String.class)
            );
            ToIntFunction<String> invoke = (ToIntFunction<String>) callSite.getTarget().invoke();
            int jhlz = invoke.applyAsInt("jhlz");
            System.out.println(jhlz);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (LambdaConversionException e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}

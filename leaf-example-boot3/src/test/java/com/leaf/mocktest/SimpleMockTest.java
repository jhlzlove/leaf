package com.leaf.mocktest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/7/2 16:42
 */
@DisplayName("Spring Mockito 工具使测试")
public class SimpleMockTest {
    /**
     * test: Mockito example
     */
    @Test
    public void mockito_test() {
        List<Object> mock = Mockito.mock(List.class);
        // 使用对象
        mock.add("123");
        // 验证使用的 mock
        Mockito.verify(mock).add("123");

        // 设置调用后的返回值
        Mockito.when(mock.size()).thenReturn(1);
        Mockito.when(mock.add("run")).thenThrow(new RuntimeException("哈哈哈，调用你就出错！"));
        Mockito.when(mock.get(Mockito.anyInt())).thenReturn("get any");
        // 测试
        Assertions.assertEquals(1, mock.size());
        Assertions.assertThrowsExactly(RuntimeException.class, () -> mock.add("run"));
        Assertions.assertEquals("get any", mock.get(1000));
    }
}

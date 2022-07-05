package com.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class StackTest {
    @Test
    public void test() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        Assert.assertTrue(stack.push(1));
        Assert.assertTrue(stack.push(2));
        Assert.assertEquals(2,stack.getN());
        Assert.assertEquals(new Integer(2),stack.pop());
        Assert.assertTrue(stack.push(2));
        Assert.assertEquals(new Integer(2),stack.pop());
        Assert.assertTrue(stack.push(2));
        Assert.assertTrue(stack.push(3));
        Assert.assertEquals(4,stack.getN());
        Assert.assertEquals(new Integer(3),stack.pop());
    }
}

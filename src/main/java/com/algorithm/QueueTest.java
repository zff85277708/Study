package com.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
    @Test
    public void testArrayQueue() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        for (int i = 0; i < 8; i++)
            Assert.assertTrue(queue.enqueue("item" + i));
        Assert.assertFalse(queue.enqueue("item8"));
        Assert.assertEquals("item0",queue.dequeue());
        Assert.assertTrue(queue.enqueue("item8"));
        Assert.assertFalse(queue.enqueue("item9"));
        Assert.assertEquals("item1",queue.dequeue());
    }

    @Test
    public void testCircularQueue() {
        CircularQueue<String> queue = new CircularQueue<>();
        for (int i = 0; i < 7; i++)
            Assert.assertTrue(queue.enqueue("item" + i));
        Assert.assertFalse(queue.enqueue("item7"));
        Assert.assertEquals("item0",queue.dequeue());
        Assert.assertTrue(queue.enqueue("item7"));
        Assert.assertFalse(queue.enqueue("item8"));
        Assert.assertEquals("item1",queue.dequeue());
    }
}

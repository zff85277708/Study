package com.designPattern.behavior.state.table;

public class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        System.out.println(mario.getScore() + ":" + mario.getCurrentState());
        mario.obtainCape();
        System.out.println(mario.getScore() + ":" + mario.getCurrentState());
        mario.obtainFireFlower();
        System.out.println(mario.getScore() + ":" + mario.getCurrentState());
        mario.obtainMushRoom();
        System.out.println(mario.getScore() + ":" + mario.getCurrentState());
        mario.meetMonster();
        System.out.println(mario.getScore() + ":" + mario.getCurrentState());
    }
}

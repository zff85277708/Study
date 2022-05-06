package com.designPattern.behavior.state;

import com.designPattern.behavior.state.table.State;

public class MarioStateMachine {
    private int score;
    private IMario currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        currentState.meetMonster(this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public State getCurrentState() {
        return currentState.getName();
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}

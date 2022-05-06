package com.designPattern.behavior.state;

import com.designPattern.behavior.state.table.State;

public class CapeMario implements IMario{
    private static final CapeMario CAPE_MARIO = new CapeMario();

    private CapeMario() {}

    public static CapeMario getInstance() {
        return CAPE_MARIO;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}

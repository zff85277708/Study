package com.designPattern.behavior.state;

import com.designPattern.behavior.state.table.State;

public class FireMario implements IMario{
    private static final FireMario FIRE_MARIO = new FireMario();

    private FireMario() {}

    public static FireMario getInstance() {
        return FIRE_MARIO;
    }

    @Override
    public State getName() {
        return State.FIRE;
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
        stateMachine.setScore(stateMachine.getScore() - 300);
    }
}

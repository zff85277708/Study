package com.designPattern.darklaunch;

public class UserProgrammedDarkRule implements IDarkFeature{
    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public boolean dark(long darkTarget) {
        return darkTarget == 5201314;
    }

    @Override
    public boolean dark(String darkTarget) {
        long target = Long.parseLong(darkTarget);
        return dark(target);
    }
}

package com.designPattern.darklaunch;

/**
 * 灰度规则使用接口
 */
public interface IDarkFeature {
    boolean enabled();
    boolean dark(long darkTarget);
    boolean dark(String darkTarget);
}

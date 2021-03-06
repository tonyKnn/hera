package com.dfire.common.enums;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午11:43 2018/4/23
 * @desc
 */
public enum JobScheduleTypeEnum {
    Independent(0), Dependent(1);
    private Integer type;

    JobScheduleTypeEnum(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    public static JobScheduleTypeEnum parser(String value) {
        if ("0".equals(value)) {
            return Independent;
        }
        if ("1".equals(value)) {
            return Dependent;
        }
        return null;
    }

    public static JobScheduleTypeEnum parser(Integer v) {
        for (JobScheduleTypeEnum t : JobScheduleTypeEnum.values()) {
            if (t.getType().equals(v)) {
                return t;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }
}


package com.mandelag.ocp.chapter5;

import java.util.List;
import java.util.LinkedList;
import java.security.InvalidParameterException;
import java.util.Collections;

public class AClass {
  private final List<Schedule> schedules;

  private AClass(List<Schedule> schedules) {
    this.schedules = Collections.unmodifiableList(schedules);
  }

  class Builder {
    private List<Schedule> schedules;
    
    public Builder() {
      schedules = new LinkedList<>();
    }

    public Builder addSchedule(Schedule schedule) {
      for (Schedule s : schedules) {
        if(s.overlap(schedule)) {
          throw new InvalidParameterException("Overlap with schedule: %s.".format(s.toString()));
        }
      }
      schedules.add(schedule);
      return this;
    }

    public AClass build() {
      return new AClass(schedules);
    }
  }
}
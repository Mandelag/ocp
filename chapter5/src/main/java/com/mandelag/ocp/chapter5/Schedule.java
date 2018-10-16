package com.mandelag.ocp.chapter5;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Duration;

/**
 * Represent contiguous block of time in a day in a week.
 */
public class Schedule {
  private final DayOfWeek dayOfWeek;
  private final LocalTime startTime;
  private final LocalTime endTime;

  public Schedule(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Duration getDuration() {
    return Duration.between(startTime, endTime);
  }

  public boolean overlap(Schedule that) {
    return this.getDayOfWeek() == that.getDayOfWeek() && 
      this.getStartTime().isBefore(that.getEndTime()) &&
      this.getEndTime().isAfter(that.getStartTime());
  }

  public DayOfWeek getDayOfWeek() {
    return this.dayOfWeek;
  }

  public LocalTime getStartTime() {
    return this.startTime;
  }

  public LocalTime getEndTime() {
    return this.endTime;
  }

  public String toString() {
    return "%s from %s to %s.".format(getDayOfWeek().toString(), getStartTime().toString(), getEndTime().toString());
  }
}
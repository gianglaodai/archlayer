package com.gh.archlayer.service.filter;

import static org.junit.jupiter.api.Assertions.*;

import com.gh.archlayer.service.filter.impl.BooleanFilter;
import com.gh.archlayer.service.filter.impl.InDecimalFilter;
import com.gh.archlayer.service.filter.impl.InIntegerFilter;
import com.gh.archlayer.service.filter.impl.InStringFilter;
import com.gh.archlayer.service.filter.impl.IntegerFilter;
import com.gh.archlayer.service.filter.impl.LocalDateFilter;
import com.gh.archlayer.service.filter.impl.LocalDateTimeFilter;
import com.gh.archlayer.service.filter.impl.StringFilter;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class FilterFactoryTest {

  @Test
  void parseMany() {
    assertEquals(IntegerFilter.class, FilterFactory.parseMany(List.of("id:=:1")).get(0).getClass());
    assertEquals(IntegerFilter.class, FilterFactory.parseMany(List.of("id::1")).get(0).getClass());
    assertEquals(
        IntegerFilter.class, FilterFactory.parseMany(List.of("id:!=:1")).get(0).getClass());
    assertEquals(
        InIntegerFilter.class, FilterFactory.parseMany(List.of("id:[]:1|2")).get(0).getClass());
    assertEquals(
        InIntegerFilter.class, FilterFactory.parseMany(List.of("id:[]:1|")).get(0).getClass());
    assertEquals(
        InDecimalFilter.class, FilterFactory.parseMany(List.of("id:[]:1.2|2.3")).get(0).getClass());
    assertEquals(
        InDecimalFilter.class, FilterFactory.parseMany(List.of("id:[]:1|2.3")).get(0).getClass());
    assertEquals(
        BooleanFilter.class, FilterFactory.parseMany(List.of("id:is:true")).get(0).getClass());
    assertEquals(
        BooleanFilter.class, FilterFactory.parseMany(List.of("id:is:false")).get(0).getClass());
    assertEquals(
        LocalDateFilter.class,
        FilterFactory.parseMany(List.of("createdAt:=:2024-12-01")).get(0).getClass());
    assertEquals(
        LocalDateTimeFilter.class,
        FilterFactory.parseMany(List.of("createdAt:=:2024-12-01T12:00:00")).get(0).getClass());
    assertEquals(
        InStringFilter.class, FilterFactory.parseMany(List.of("id:[]:1|adc")).get(0).getClass());
    assertEquals(
        InStringFilter.class, FilterFactory.parseMany(List.of("id:[]:1|2:s")).get(0).getClass());
    assertEquals(
        StringFilter.class, FilterFactory.parseMany(List.of("id:=:adc")).get(0).getClass());
    assertEquals(
        StringFilter.class, FilterFactory.parseMany(List.of("id:=:1:s")).get(0).getClass());
    assertEquals(
        StringFilter.class,
        FilterFactory.parseMany(List.of("id:=:2024-12-01:s")).get(0).getClass());
    assertEquals(
        StringFilter.class,
        FilterFactory.parseMany(List.of("id:=:2024-12-01T12:00:00:s")).get(0).getClass());
  }

  @Test
  void testLocalDateTimeFilter() {
    final Filter<?> filter =
        FilterFactory.parseMany(List.of("createdAt:=:2024-12-01T12:00:00")).get(0);
    assertEquals(LocalDateTimeFilter.class, filter.getClass());
    assertEquals(LocalDateTime.parse("2024-12-01T12:00:00"), filter.getValue());
  }

  @Test
  void testStringFilter() {
    final Filter<?> filter =
        FilterFactory.parseMany(List.of("createdAt:=:2024-12-01T12:00:00:s")).get(0);
    assertEquals(StringFilter.class, filter.getClass());
    assertEquals("2024-12-01T12:00:00", filter.getValue());
  }
}

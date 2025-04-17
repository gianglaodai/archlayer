package com.gh.archlayer.utils;

import org.slf4j.helpers.MessageFormatter;

/**
 * A utility class for formatting strings.
 *
 * <p>This class provides a simple way to format strings using a specified format and arguments.
 */
public class StringFormatter {
  private StringFormatter() {}

  /**
   * Formats a string using the specified format and arguments.
   *
   * @param format the format string
   * @param args the arguments referenced by the format specifiers in the format string
   * @return the formatted string
   */
  public static String format(final String format, final Object... args) {
    return MessageFormatter.arrayFormat(format, args).getMessage();
  }
}

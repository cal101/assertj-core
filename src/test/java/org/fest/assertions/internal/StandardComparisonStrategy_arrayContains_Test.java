/*
 * Created on Sep 23, 2006
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2006-2011 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.util.Arrays.array;

import static org.junit.Assert.*;

import org.fest.assertions.internal.StandardComparisonStrategy;
import org.junit.Test;

/**
 * Tests for {@link StandardComparisonStrategy#arrayContains(Object, Object)}.
 * 
 * @author Joel Costigliola
 */
public class StandardComparisonStrategy_arrayContains_Test extends AbstractTest_StandardComparisonStrategy {

  @Test
  public void should_return_true_if_array_contains_value() {
    String[] hobbits = array("Merry", "Frodo", null, "Merry", "Sam");
    assertTrue(standardComparisonStrategy.arrayContains(hobbits, "Sam"));
    assertTrue(standardComparisonStrategy.arrayContains(hobbits, "Merry"));
    assertTrue(standardComparisonStrategy.arrayContains(hobbits, null));
  }

  @Test
  public void should_return_false_if_array_does_not_contain_value() {
    String[] hobbits = array("Merry", "Frodo", "Merry", "Sam");
    assertFalse(standardComparisonStrategy.arrayContains(hobbits, "Pippin"));
    assertFalse(standardComparisonStrategy.arrayContains(hobbits, "SAM "));
    assertFalse(standardComparisonStrategy.arrayContains(hobbits, null));
  }

  @Test
  public void should_return_false_if_array_is_empty() {
    assertFalse(standardComparisonStrategy.arrayContains(new String[] {}, "Pippin"));
  }

  @Test
  public void should_fail_if_first_parameter_is_not_an_array() {
    thrown.expect(IllegalArgumentException.class);
    standardComparisonStrategy.arrayContains("not an array", "Pippin");
  }

}
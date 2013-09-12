package com.threerings.getdown;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.threerings.getdown.util.ConfigUtilTest;
import com.threerings.getdown.util.FileUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  ConfigUtilTest.class,
  FileUtilTest.class
})
public class TestSuite_Getdown
{
  // Empty
}
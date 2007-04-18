/*
 * All content copyright (c) 2003-2006 Terracotta, Inc., except as may otherwise be noted in a separate copyright notice.  All rights reserved.
 */
package com.tctest;

import com.tc.test.activepassive.ActivePassiveTestSetupManager;

public class ArrayTest extends TransparentTestBase {

  public static final int NODE_COUNT = 1;

  public void doSetUp(TransparentTestIface t) throws Exception {
    t.getTransparentAppConfig().setClientCount(NODE_COUNT).setIntensity(1);
    t.initializeTestRunner();
  }

  protected Class getApplicationClass() {
    return ArrayTestApp.class;
  }

  protected boolean canRunCrash() {
    return true;
  }

  protected boolean canRunActivePassive() {
    return true;
  }

  public void setupActivePassiveTest(ActivePassiveTestSetupManager setupManager) {
    setupManager.setServerCount(2);
    setupManager.setServerCrashMode(ActivePassiveTestSetupManager.CONTINUOUS_ACTIVE_CRASH);
    setupManager.setServerCrashWaitInSec(60);
    setupManager.setServerShareDataMode(ActivePassiveTestSetupManager.DISK);
    setupManager.setServerPersistenceMode(ActivePassiveTestSetupManager.PERMANENT_STORE);
  }

}

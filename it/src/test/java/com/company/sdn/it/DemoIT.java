/*
 * Copyright © 2016 No rights reserved and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.company.sdn.it;

import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.editConfigurationFilePut;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opendaylight.controller.mdsal.it.base.AbstractMdsalTestBase;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.karaf.options.LogLevelOption.LogLevel;
import org.ops4j.pax.exam.options.MavenUrlReference;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class DemoIT extends AbstractMdsalTestBase {
    private static final Logger LOG = LoggerFactory.getLogger(DemoIT.class);

    @Override
    public String getModuleName() {
        return "demo";
    }

    @Override
    public String getInstanceName() {
        return "demo-default";
    }

    @Override
    public MavenUrlReference getFeatureRepo() {
        return maven()
                .groupId("com.company.sdn")
                .artifactId("demo-features")
                .classifier("features")
                .type("xml")
                .versionAsInProject();
    }

    @Override
    public String getFeatureName() {
        return "odl-demo-ui";
    }

    @Override
    public Option getLoggingOption() {
        Option option = editConfigurationFilePut(ORG_OPS4J_PAX_LOGGING_CFG,
                logConfiguration(DemoIT.class),
                LogLevel.INFO.name());
        option = composite(option, super.getLoggingOption());
        return option;
    }

    @Test
    public void testdemoFeatureLoad() {
        Assert.assertTrue(true);
    }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.spi.checkpoint.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.internal.managers.checkpoint.GridCheckpointManagerAbstractSelfTest;
import org.apache.ignite.util.IgniteS3TestConfiguration;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Checkpoint manager test using {@link S3CheckpointSpi}.
 */
public class S3CheckpointManagerSelfTest extends GridCheckpointManagerAbstractSelfTest {
    /** {@inheritDoc} */
    @Override protected IgniteConfiguration getConfiguration(String igniteInstanceName) throws Exception {
        assertTrue("Unexpected Ignite instance name: " + igniteInstanceName, igniteInstanceName.contains("s3"));

        IgniteConfiguration cfg = super.getConfiguration(igniteInstanceName);

        S3CheckpointSpi spi = new S3CheckpointSpi();

        AWSCredentials cred = new BasicAWSCredentials(IgniteS3TestConfiguration.getAccessKey(),
            IgniteS3TestConfiguration.getSecretKey());

        spi.setAwsCredentials(cred);

        spi.setBucketNameSuffix(S3CheckpointSpiSelfTest.getBucketNameSuffix());

        cfg.setCheckpointSpi(spi);

        return cfg;
    }

    /**
     * @throws Exception Thrown if any exception occurs.
     */
    @Ignore("https://issues.apache.org/jira/browse/IGNITE-2420")
    @Test
    public void testS3Based() throws Exception {
        retries = 6;

        doTest("s3");
    }

    /**
     * @throws Exception Thrown if any exception occurs.
     */
    @Ignore("https://issues.apache.org/jira/browse/IGNITE-2420")
    @Test
    public void testMultiNodeS3Based() throws Exception {
        retries = 6;

        doMultiNodeTest("s3");
    }
}

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
import org.apache.ignite.spi.GridSpiStartStopAbstractTest;
import org.apache.ignite.testframework.junits.spi.GridSpiTest;
import org.apache.ignite.util.IgniteS3TestConfiguration;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Grid S3 checkpoint SPI start stop self test.
 */
@GridSpiTest(spi = S3CheckpointSpi.class, group = "Checkpoint SPI")
public class S3CheckpointSpiStartStopSSEAlgorithmSelfTest extends GridSpiStartStopAbstractTest<S3CheckpointSpi> {
    /** {@inheritDoc} */
    @Override protected void spiConfigure(S3CheckpointSpi spi) throws Exception {
        AWSCredentials cred = new BasicAWSCredentials(IgniteS3TestConfiguration.getAccessKey(),
            IgniteS3TestConfiguration.getSecretKey());

        spi.setAwsCredentials(cred);
        spi.setBucketNameSuffix(S3CheckpointSpiSelfTest.getBucketNameSuffix());
        spi.setSSEAlgorithm("AES256");

        super.spiConfigure(spi);
    }

    /** {@inheritDoc} */
    @Ignore("https://issues.apache.org/jira/browse/IGNITE-2420")
    @Test
    @Override public void testStartStop() throws Exception {
        super.testStartStop();
    }
}

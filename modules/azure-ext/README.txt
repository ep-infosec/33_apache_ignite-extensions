Apache Ignite Azure Module
------------------------

Apache Ignite Azure module provides Azure Blob Storage based implementation of IP finder for TCP discovery.

Depending on how you use Ignite, you can an extension using one of the following methods:

- If you use the binary distribution, move the libs/{module-dir} to the 'libs' directory of the Ignite distribution before starting the node.
- Add libraries from libs/{module-dir} to the classpath of your application.
- Add a module as a Maven dependency to your project.


Building Azure Module And Running Tests
---------------------------------------

To build and run Azure extension use the command below with the right credentials to the Azure service:

mvn clean package -pl modules/azure-ext -Dtest.azure.account.name=uname -Dtest.azure.account.key=key
-Dtest.azure.endpoint=http://127.0.0.1:10000/devstoreaccount


Importing Azure Module In Maven Project
-------------------------------------

If you are using Maven to manage dependencies of your project, you can add Azure module
dependency like this (replace '${ignite.version}' with actual Ignite version you are
interested in):

<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                        http://maven.apache.org/xsd/maven-4.0.0.xsd">
    ...
    <dependencies>
        ...
        <dependency>
            <groupId>org.apache.ignite</groupId>
            <artifactId>ignite-azure-ext</artifactId>
            <version>${ignite-azure-ext.version}</version>
        </dependency>
        ...
    </dependencies>
    ...
</project>

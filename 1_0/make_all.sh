#! /bin/sh

javac ./ru/rsatu/HelloWorld.java

jar cmvf ./ru/rsatu/manifest.mf  helloWorld.jar ./ru/rsatu/HelloWorld.class
jar cmvf ./ru/rsatu/supplier/manifest.mf helloWorldSupplier.jar ./ru/rsatu/supplier/HelloWorldSupplier.class
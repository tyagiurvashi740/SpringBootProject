//package com.example.springBootProject.config;
//
//import org.jasypt.encryption.StringEncryptor;
//import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
//import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//@PropertySource("application.properties")
//  {
//
//    @Bean(name= "encryptorBean")
//    public StringEncryptor passwordEncryptor(){
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword("the password"); // encryptor's private key config.setAlgorithm("PBEWithMD5AndDES")
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
//        config.setProviderName("'SunJCE");
////        config.setAlgorithm("PBEWithMD5AndDES");
//        config.setSaltGeneratorClassName("prg-jasypt.salt.RandomSaltGenerator");
////        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
//        config.setStringOutputType("base64");
//        encryptor.setConfig(config);
//        return encryptor;
//    }
//
//}

/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.log;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @Desc 将Http请求日志写入MongoDB数据库
 * @Author feizi
 * @Date 2016/10/26 14:03
 * @Package_name com.feizi.log
 */
public class MongoAppender extends AppenderSkeleton{

    //mongodb的连接客户端
    private MongoClient mongoClient;
    //数据库实例对象
    private MongoDatabase mongoDatabase;
    //记录日志信息的文档集合
    private MongoCollection<BasicDBObject> logsCollection;

    //连接mongodb的串
    private String connectionUrl;
    //数据库名称
    private String databaseName;
    //集合名称
    private String collectionName;

    @Override
    protected void append(LoggingEvent loggingEvent) {
        if(null == mongoDatabase){
            MongoClientURI conMongoClientURI = new MongoClientURI(connectionUrl);
            mongoClient = new MongoClient(conMongoClientURI);
            mongoDatabase = mongoClient.getDatabase(databaseName);
            logsCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
        }

        logsCollection.insertOne((BasicDBObject) loggingEvent.getMessage());
    }

    @Override
    public void close() {
        if(null != mongoClient){
            mongoClient.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}

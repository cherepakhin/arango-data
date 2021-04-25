package ru.perm.v.arangodata;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.config.ArangoConfiguration;

public class ArangoConfig implements ArangoConfiguration {

    String host;
    String dbname;
    String user;

    public ArangoConfig(String host, String dbname, String user) {
        this.host = host;
        this.dbname = dbname;
        this.user = user;
    }

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder()
                .host(host, 8529)
                .user(user);
    }

    @Override
    public String database() {
        return dbname;
    }

}

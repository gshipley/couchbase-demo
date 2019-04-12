package com.openshift.couchbase;

import java.util.Date;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CouchbaseDemoController {
    @Autowired
    Environment environment;
    @RequestMapping("/")
    public String defaultRoute() {

        Cluster cluster = CouchbaseCluster.create("cb-example");
        cluster = cluster.authenticate("QWRtaW5pc3RyYXRvcg==", "cGFzc3dvcmQ=");
        Bucket bucket = cluster.openBucket("default");

        JsonObject user = JsonObject.empty()
        .put("timestamp", new java.util.Date().toString())
        .put("firstname", "Walter")
        .put("lastname", "White")
        .put("job", "chemistry teacher")
        .put("age", 50);

        JsonDocument doc = JsonDocument.create(new Date().toString(), user);
        JsonDocument response = bucket.insert(doc);

        JsonDocument walter = bucket.get("walter");
        bucket.close();
        cluster.disconnect();
        return("Found: " + walter.toString());
    }

}


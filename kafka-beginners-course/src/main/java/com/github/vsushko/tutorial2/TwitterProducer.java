package com.github.vsushko.tutorial2;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author vsushko
 */
public class TwitterProducer {
    private Logger logger = LoggerFactory.getLogger(TwitterProducer.class.getName());

    private String consumerKey = "nSyj44g5xvs0YRvIwRwqLQ";
    private String consumerSecret = "bfdIgJvwXZCe6U3id08rqzgFRNDKiFaGcFGQoy04Wo";
    private String token = "378129048-h1tXU9hfubtI6hHZnL0spB3d148cqhT3oBqJ5Csg";
    private String secret = "cI0NgkvbbP9Nir1RtrS0R9Ki70RIiBIzmA2ExGUnZyYmj";

    public TwitterProducer() {

    }

    public static void main(String[] args) {
        new TwitterProducer().run();
    }

    private void run() {
        logger.info("Setup");

        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>(1000);

        // create a twitter client
        Client client = createTwitterClient(msgQueue);
        // attempts to establish a connection
        client.connect();

        // on a different thread, or multiple different threads....
        while (!client.isDone()) {
            String msg = null;
            try {
                msg = msgQueue.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                client.stop();
            }

            if (msg != null) {
                logger.info(StringEscapeUtils.unescapeJava(msg));
            }
        }
        logger.info("End of application");
    }

    private Client createTwitterClient(BlockingQueue<String> msgQueue) {
        // declare the host you want to connect to, the endpoint, and authentication
        Hosts hosts = new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        List<String> terms = Lists.newArrayList("java", "api");
        endpoint.trackTerms(terms);

        // These secrets should be read from a config file
        Authentication oAuth1 = new OAuth1(consumerKey, consumerSecret, token, secret);
        ClientBuilder builder = new ClientBuilder()
                .name("Hosebird-Client-01")
                .hosts(hosts)
                .authentication(oAuth1)
                .endpoint(endpoint)
                .processor(new StringDelimitedProcessor(msgQueue));

        return builder.build();
    }
}

package cmb.qmx.es.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 80254142
 * @description
 * @date
 */
@Configuration
public class ElasticSearchConfig {
    private final static String host = "55.14.112.190";
    private final static Integer port = 9200;
//    private final static String username="1487";
//    private final static String password="QnMPGKq8yJqnukj";

    @Bean
    public RestHighLevelClient getRestHighLevelClient(){
        RestClientBuilder builder = RestClient.builder(new HttpHost(host,port));
        //ElasticSearch用户名、密码认证
        builder.setHttpClientConfigCallback(f->{
            CredentialsProvider provider = new BasicCredentialsProvider();
//            provider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(username,password));
            f.setDefaultCredentialsProvider(provider);
            return f;
        });
        //创建连接
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }
}

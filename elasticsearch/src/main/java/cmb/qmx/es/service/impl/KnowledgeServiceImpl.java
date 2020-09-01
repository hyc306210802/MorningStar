package cmb.qmx.es.service.impl;

import cmb.qmx.es.entity.Knowledge;
import cmb.qmx.es.entity.Student;
import cmb.qmx.es.service.KnowledgeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author 80254142
 * @description
 * @date
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    /**
     * 索引名称（默认）
     */
    private final String INDEX_NAME = "student-80296464";

    /**
     * 类型（默认）
     */
    private final String TYPE = "doc";

    @Qualifier("getRestHighLevelClient")
    @Autowired
    private RestHighLevelClient client;


    @Override
    public String add(Knowledge knowledge) throws IOException {
        //1.创建请求
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME, TYPE);
        //2.设置请求参数
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(knowledge);
        searchRequest.source(json, XContentType.JSON);
        //3.发起请求
        try {
            IndexResponse response = client.index(request);
            if (response.getResult() == DocWriteResponse.Result.CREATED) {
                System.out.println("添加成功");
            } else if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                System.out.println("更新成功");
            }
        } catch (IOException e) {

        }
        return "";
    }

    @Override
    public String updateById(String id, Map<String, Object> map) {
        UpdateRequest request = new UpdateRequest(INDEX_NAME, TYPE, id);
        request.doc(map);
        try {
            UpdateResponse response = client.update(request);
            if (response.getResult() == DocWriteResponse.Result.CREATED) {
                System.out.println("添加成功");
            } else if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                System.out.println("更新成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String searchByName(String name) {

        //1.创建请求
        IndexRequest request = new IndexRequest(INDEX_NAME, TYPE);
        //2.设置请求参数
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.getFactory(name);
        request.source(json, XContentType.JSON);
        //3.发起请求
        try {
            IndexResponse response = client.index(request);
            if (response.getResult() == DocWriteResponse.Result.CREATED) {
                System.out.println("添加成功");
            } else if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                System.out.println("更新成功");
            }
        } catch (IOException e) {

        }
        return "";

    }

    @Override
    public String searchByInterest(String interest) {
        return "";
    }

    @Override
    public String searchOrderByName() {
        return "";
    }

    @Override
    public String termsAggregation() {
        return "";
    }
}

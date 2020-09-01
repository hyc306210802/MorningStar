package cmb.qmx.es;

import cmb.qmx.es.entity.Knowledge;
import cmb.qmx.es.entity.Student;
import cmb.qmx.es.service.KnowledgeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;

/**
 * @author 80254142
 * @description
 * @date
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsDemoApplication.class)
public class StudentTest {
    @Autowired
    private KnowledgeService knowledgeService;

    @Test
    public void testAdd() throws IOException {
        Knowledge knowledge = new Knowledge("招银网络科技","男","胡一尘",new Date());
        knowledgeService.add(knowledge);

    }

    @Test
    public void testUpdateById() throws IOException {

    }

    @Test
    public void testSearchByName() throws IOException {

    }

    @Test
    public void testSearchByInterest(){

    }

    @Test
    public void testSearchOrderByName(){

    }

    @Test
    public void testSearchOrderByAge(){

    }

    @Test
    public void testSearchOrderByRegisterTime(){

    }

    @Test
    public void testPageSearch(){

    }

    @Test
    public void testDeleteByMatchQuery(){

    }

    @Test
    public void testTermsAggregation(){

    }
}

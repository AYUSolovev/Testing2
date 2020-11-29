package application.bisinessLayer.test;

import application.dataLayer.repository.TestRepository;
import application.model.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<Test> getAllTest() {
        List<Test> tests = (List<Test>)testRepository.findAll();
        for(int i = 0; i < tests.size(); i++){
            tests.get(i).setQuestions(null);
        }
        return tests;
    }

    @Override
    public Test getTestById(String id){
        Long idL = new Long(id);
        return testRepository.getById(idL);
    }

    @Override
    public void deleteTest(String id){
        Long idL = new Long(id);
        testRepository.deleteById(idL);
    }

    @Override
    @Transactional
    public void createTest(Test test){
        testRepository.save(test);
    }
}

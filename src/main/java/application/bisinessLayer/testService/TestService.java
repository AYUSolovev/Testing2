package application.bisinessLayer.testService;

import application.model.test.Test;

import java.util.List;

public interface TestService {
    List<Test> getAllTest();
    Test getTestById(String id);
    void deleteTest(String id);
}

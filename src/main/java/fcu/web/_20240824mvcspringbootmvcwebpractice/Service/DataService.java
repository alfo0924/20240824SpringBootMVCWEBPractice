package fcu.web._20240824mvcspringbootmvcwebpractice.Service;

import fcu.web._20240824mvcspringbootmvcwebpractice.Model.Data;
import fcu.web._20240824mvcspringbootmvcwebpractice.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public void saveData(String content) {
        Data data = new Data();
        data.setContent(content);
        dataRepository.save(data);
    }

    public List<Data> getAllData() {
        return dataRepository.findAll();
    }
}
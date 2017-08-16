package studentsystem.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.app.models.Resource;
import studentsystem.app.repository.ResourceRepository;
import studentsystem.app.services.interfaces.ResourceService;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:22.
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public void register(Resource resource) {
        this.resourceRepository.save(resource);
    }
}

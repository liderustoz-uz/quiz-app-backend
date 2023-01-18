package uz.bakhromjon.ustoztalim.services.variant;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.mappers.VariantMapper;
//import uz.bakhromjon.ustoztalim.repositories.VariantRepository;
import uz.bakhromjon.ustoztalim.repositories.VariantRepository;
import uz.bakhromjon.ustoztalim.services.AbstractService;

@Service
public class VariantServiceImpl extends AbstractService<VariantRepository, VariantMapper> implements VariantService {
    public VariantServiceImpl(VariantRepository repository, @Qualifier(value = "variantMapperImpl") VariantMapper mapper) {
        super(repository, mapper);
    }
}

package one.digitalinnovation.lab.spring.service;

import one.digitalinnovation.lab.spring.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Client HTTP, criado vua <b>OpenFeign</b>, para cosumo da API <b>Via Cep</b>.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud Openfeign</a>
 * @see <a href="https://viacep.com.br/">Via Cep</a>
 *  */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Address consultCep(@PathVariable("cep")String cep);
}

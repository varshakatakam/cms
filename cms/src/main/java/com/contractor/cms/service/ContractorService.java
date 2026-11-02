package com.contractor.cms.service;

import com.contractor.cms.dto.EmployeeRequestDTO;
import com.contractor.cms.dto.EmployeeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContractorService {
    private final RestTemplate restTemplate;
    public ContractorService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public EmployeeDTO[] getAllEmployee(){
        String url="http://localhost:8081/api/employees?employeeType=CONTRACTOR";
        return restTemplate.getForObject(url,EmployeeDTO[].class);
    }
    public EmployeeDTO getEmployeeById(Long id){
        String url="http://localhost:8081/api/employees/" +id+"?employeeType=CONTRACTOR";
        return restTemplate.getForObject(url,EmployeeDTO.class);
    }
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        String url="http://localhost:8081/employees";
        return restTemplate.postForObject(url,employeeDTO,EmployeeDTO.class);
    }
    public EmployeeDTO createEmployeeFromRequest(EmployeeRequestDTO request){
        String url="http://localhost:8081/api/employees";
        return restTemplate.postForObject(url,request,EmployeeDTO.class);
    }
    public void updateEmployee(Long id,EmployeeDTO employeeDTO){
        String url="http://localhost:8081/api/employees/"+id+"?employeeType=CONTRACTOR";
        restTemplate.put(url,employeeDTO);
    }
    public void deleteEmployee(Long id){
        String url="http://localhost:8081/api/employees/"+id+"?employeeType=CONTRACTOR";
        restTemplate.delete(url);
    }
}
